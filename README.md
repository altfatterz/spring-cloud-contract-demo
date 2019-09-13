### Converting Spring Cloud Contract DSL into WireMock stub mappings

```bash
cd spring-cloud-contract-producer
mvn spring-cloud-contract:convert
```

Check the generated mappings in the `target/stubs` folder

### Run stubs mappings from current directory:

```bash
mvn spring-cloud-contract:run
```

This is launching the StubRunner with contracts from the `target/stubs` folder.

```
⇒  http :8080
HTTP/1.1 404 Not Found
Content-Type: text/plain
Server: Jetty(9.2.z-SNAPSHOT)
Transfer-Encoding: chunked

Request was not matched
                                               =======================

-----------------------------------------------------------------------------------------------------------------------
| Closest stub                                             | Request                                                  |
-----------------------------------------------------------------------------------------------------------------------
                                                           |
GET                                                        | GET
/ping                                                      | /                                                   <<<<< URL does not match
                                                           |
                                                           |
-----------------------------------------------------------------------------------------------------------------------
```

```
http :8080/stubs

HTTP/1.1 404 Not Found
Content-Type: text/plain
Server: Jetty(9.2.z-SNAPSHOT)
Transfer-Encoding: chunked

Request was not matched
                                               =======================

-----------------------------------------------------------------------------------------------------------------------
| Closest stub                                             | Request                                                  |
-----------------------------------------------------------------------------------------------------------------------
                                                           |
GET                                                        | GET
/greetings/DE                                              | /stubs                                              <<<<< URL does not match
                                                           |
                                                           |
-----------------------------------------------------------------------------------------------------------------------

```


### Run stubs mappings via `spring cli`

```bash
sdk install springboot 2.1.8.RELEASE
spring install org.springframework.cloud:spring-cloud-cli:2.0.0.RELEASE 
spring cloud stubrunner
```
with the following configuration

```yaml
stubrunner:
  stubsMode: LOCAL
  ids:
    - com.example:spring-cloud-contract-producer:+:9876
```

The Stub Runner server will be available on: http://localhost:8750/stubs

Note the latest spring boot 2.1.x spring cloud is not compatible, see [issue](https://stackoverflow.com/questions/53410910/issues-with-spring-cloud-cli-nosuchmethoderror-org-springframework-cloud-launc)




 
