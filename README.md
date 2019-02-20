## Converting Spring Cloud Contract DSL into WireMock stub mappings

```bash
mvn spring-cloud-contract:convert
```

## Run stubs mappings from current directory:

```bash
mvn spring-cloud-contract:run
```

## Running stubs from repository

```bash
mvn spring-cloud-contract:run -Dstubs="com.example:spring-cloud-contract-producer"
```




with the latest spring boot 2.1.x spring cloud is not compatible, see [issue](https://stackoverflow.com/questions/53410910/issues-with-spring-cloud-cli-nosuchmethoderror-org-springframework-cloud-launc)

```bash
skd install sprinboot 2.0.8.RELEASE
spring install org.springframework.cloud:spring-cloud-cli:2.0.0.RELEASE 
spring cloud stubrunner
```

wit the following configuration

```yaml
stubrunner:
  stubsMode: LOCAL
  ids:
    - com.example:spring-cloud-contract-producer:+:9876
```

The Stub Runner server will be available on: http://localhost:8750/stubs

 
