# simple-rest-app (stocks)
A simple REST (+UI) application written in Java.

## Setup
### Clone project
```
$ cd ~/projects

$ git clone https://github.com/opreaalex/simple-rest-app
```

## How to run
### Navigate to the root project directory and start the application
```
$ cd ~/projects/simple-rest-app

$ mvn clean spring-boot:run
```
The application will run (by default) at: <b>localhost:8080</b>.

## Run unit tests with maven
```
mvn test
```

## Interact with the application
### Create a new stocks
```
$ curl -X POST -H "Content-Type: application/json" -d '{"name": "test", "currentPrice": 9001}' http://localhost:8080/api/stocks
```
### Get all stocks
```
$ curl http://localhost:8080/api/stocks
```
### Get a single stock
```
$ curl http://localhost:8080/api/stocks/1
```
### Update an entry (currentPrice)
```
$ curl -X PUT -H "Content-Type: application/json" -d '{"currentPrice": 9002}' http://localhost:8080/api/stocks/1
```

You can also see the stocks in a webpage by simply visiting <b>localhost:8080</b>.
The webpage is automatically updated as new stocks are added.

