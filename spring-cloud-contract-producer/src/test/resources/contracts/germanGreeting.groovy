import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/greetings/DE'
    }
    response {
        status 200
        body("""
            {
              "id": 1,
              "lang": "DE",
              "value": "Hallo"
            }
            """)
        headers {
            contentType(applicationJson())
        }
    }
}