>> Assumption (Server will sends the transactions from endpoints, 
> we need to track the transactions so will push the transactions objects to Q, consumer will listen the messages from Q)

Steps To execute this
> start rabbitmq server
> fire the localhost:8080/transaction api with transaction object like
> http://localhost:8080/transaction?id=12345&amt=102&type=dr 