import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/greetings'
        body '''
        {
            "value": "Hallo",
            "lang": "DE
        }
        '''
    }
    response {
        status 201
    }
}