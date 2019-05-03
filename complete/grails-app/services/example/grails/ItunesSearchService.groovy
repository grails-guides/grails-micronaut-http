package example.grails

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class ItunesSearchService {

    @Autowired
    ItunesClient itunesClient

    List<Album> searchWithApi(String searchTerm) {
        String baseUrl = "https://itunes.apple.com/"
        HttpClient client = HttpClient.create(baseUrl.toURL())
        HttpRequest request = HttpRequest.GET("/search?limit=25&media=music&entity=album&term=${searchTerm}")

        HttpResponse<String> resp = client.toBlocking().exchange(request, String)
        String json = resp.body()
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        SearchResult searchResult = objectMapper.readValue(json, SearchResult)
        searchResult.results
    }

    List<Album> searchWithDeclarativeClient(String searchTerm) {
        SearchResult searchResult = itunesClient.search(searchTerm)
        searchResult.results
    }


}
