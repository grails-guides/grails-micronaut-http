package example.grails
import groovy.transform.CompileStatic
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.reactivex.Single
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class ItunesSearchService {

    @Autowired
    ItunesClient itunesClient

    List<Album> searchWithDeclarativeClient(String searchTerm) {
        Single<String> rxResult = itunesClient.search(searchTerm)
        String searchResult = rxResult.blockingGet()
        println searchResult
        []
    }

    String searchWithApi(String searchTerm) {
        String baseUrl = "https://itunes.apple.com/"
        HttpClient client = HttpClient.create(baseUrl.toURL())
        HttpRequest request = HttpRequest.GET("/search?limit=25&media=music&entity=album&term=${searchTerm}")

        HttpResponse<String> resp = client.toBlocking().exchange(request, String)
        resp.body()
    }
}
