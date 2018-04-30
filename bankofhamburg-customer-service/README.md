# Bank of Hamburg Customer Service

Run service
```
../gradlew bootRun
```

### Exemplary usage

`helloWorld` endpoint: GET request
```
curl -v http://localhost:8080/helloWorld?type=fuu
```

`customer` endpoint: POST request
```
curl -v -F firstName=Jana -F lastName=Müller http://localhost:8080/customer
```