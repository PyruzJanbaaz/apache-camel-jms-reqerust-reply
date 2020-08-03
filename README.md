# Spring-Apache-Camel
Http/JMS request-reply project by Apache camel - Spring DSL

While decoupling of messaging applications is a primary driver of the JMS specification, there are cases where an application needs to send a request and will not continue until it receives a response indicating its request was handled. This sort of messaging pattern is known as request/response messaging, and you can think of it as a sort of Remote Procedure Call (RPC) over JMS if that helps.

Traditionally, this type of architecture has been implemented using TCP client and server applications that operate synchronously across a network connection. There are several problems that arise in this implementation, the biggest of which can be scaling. Because the TCP client and server are tightly coupled, it's difficult to add new clients to handle an increasing workload. Using messaging based architecture we can reduce or eliminate this scaling issue along with other issues of fault tolerance and so on. In the messaging paradigm, a requester sends a request message to a queue located on a remote broker and one or more responders can take this message, process it, and return a response message to the requester. In the following diagram, we see a visual depiction of the typical implementation of the request/response pattern over JMS:


![alt text](https://static.packt-cdn.com/products/9781782169413/graphics/9413_01_05.jpg)
