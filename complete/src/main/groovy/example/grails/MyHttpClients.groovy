package example.grails

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyHttpClients {

    @Inject
    @Client("https://itunes.apple.com/")
    RxHttpClient itunesLowLevelClient
}
