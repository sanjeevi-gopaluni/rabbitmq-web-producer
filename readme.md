### Exchange Types
* Direct Exchange (associated queues)
* fanout Exchange (broadcast)
* Topic Exchange  
* Header Exchange
> >> Assumption (Server will sends the transactions from endpoints, 
> we need to track the transactions so will push the transactions objects to Q, consumer will listen the messages from Q)

Steps To execute this
> start rabbitmq server
> fire the localhost:8080/transaction api with transaction object like
> http://localhost:8080/direct/transaction?id=12348&amt=102&type=dr&exchange=topic-exchange&routingKey=logs 

### RabbitMq Consumer repo link [RabbitMq Consumer repo link](https://github.com/sanjeevi-gopaluni/rabbitmq-consumer) 