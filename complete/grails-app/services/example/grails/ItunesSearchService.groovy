package example.grails
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class ItunesSearchService {

    @Autowired
    ItunesClient itunesClient

    List<Album> search(String searchTerm) {
        SearchResult searchResult = itunesClient.search(searchTerm)
        searchResult.results
    }
}
