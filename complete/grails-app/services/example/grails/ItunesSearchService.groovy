package example.grails
import groovy.transform.CompileStatic

@CompileStatic
class ItunesSearchService {

    List<Album> search(String searchTerm) {
        [new Album(artistName: "Nirav", collectionName: "Blues", collectionViewUrl: "http://nirav.org")]
    }
}
