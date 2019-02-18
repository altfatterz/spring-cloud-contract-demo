import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url("/greeting") {
            queryParameters {
                parameter("lang", "DE")
            }
        }
    }
    response {
        body("Hallo")
        status 200
    }
}