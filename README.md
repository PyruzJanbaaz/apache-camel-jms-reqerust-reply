# JMS request-reply with Spring-Apache-Camel(requester)
JMS request-reply project by Apache camel - Spring DSL

- Spring 4.3.7.RELEASE
- Apache Camel 2.18.2
- Apache Activemq 5.6.0
- JavaSE 1.8
- Maven 3.3.9


While decoupling of messaging applications is a primary driver of the JMS specification, there are cases where an application needs to send a request and will not continue until it receives a response indicating its request was handled. This sort of messaging pattern is known as request/response messaging, and you can think of it as a sort of Remote Procedure Call (RPC) over JMS if that helps.

Traditionally, this type of architecture has been implemented using TCP client and server applications that operate synchronously across a network connection. There are several problems that arise in this implementation, the biggest of which can be scaling. Because the TCP client and server are tightly coupled, it's difficult to add new clients to handle an increasing workload. Using messaging based architecture we can reduce or eliminate this scaling issue along with other issues of fault tolerance and so on. In the messaging paradigm, a requester sends a request message to a queue located on a remote broker and one or more responders can take this message, process it, and return a response message to the requester. In the following diagram, we see a visual depiction of the typical implementation of the request/response pattern over JMS:


![alt text](https://static.packt-cdn.com/products/9781782169413/graphics/9413_01_05.jpg)


# Usage
- Download and install ActivceMQ : https://wiki.eveoh.nl/display/MYTT/Software+packages+and+download+locations
- Run ActiveMQ
- Run the project for call API to send messages(request)
- Make a new request by  postman: [Get] http://localhost:8080/rrp and set new header by key and value. (key = [message] , value = [#test-2;USERNAME])
- Go to http://localhost:8161/admin/queues.jsp on your browser. By default the Username and password is "admin", "admin".


# How it works...
    <camelContext trace="true" xmlns="http://camel.apache.org/schema/spring">
        <route id="inbound">
            <from uri="restlet:http://0.0.0.0:8080/rrp?restletMethods=get,post"/>
            <filter>
                <method ref="socketMessageFilter" method="filter"/>
                <to uri="seda:next"/>
            </filter>
        </route>
        <route>
            <from uri="seda:next"/>
            <choice>
                <when>
                    <method ref="socketMessageValidator" method="validation"/>
                    <process id="inboundProcessor" ref="inboundProcessor"/>
                    <to uri="activemq:queue:inbound?replyTo=outbound&amp;requestTimeout=60000&amp;replyToType=Exclusive&amp;maxConcurrentConsumers=5"
                        pattern="InOut"/>
                    <process ref="outboundProcessor"/>
                </when>
                <otherwise>
                    <transform>
                        <simple>info:duplicate</simple>
                    </transform>
                </otherwise>
            </choice>
        </route>
    </camelContext>


As you can see in the code, the request application creates a JMS MessageProducer object for sending its request along with a MessageConsumer to listen for the response. In the application, I create a JMS temporary queue and assign that to JMSReplyTo for every request message I send.
In the following, I'll building another application for listening to queues, processing requests and sending reponses through the queue.please fllow blow link:

https://github.com/PyruzJanbaaz/Jms-Request-Reply

