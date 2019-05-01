package example.grails

import groovy.transform.CompileStatic

@CompileStatic
class SearchController {

    ItunesSearchService itunesSearchService

    def index(String searchTerm) {
        if(searchTerm) {
            List<Album> searchResults = itunesSearchService.search(searchTerm)
            [searchTerm: searchTerm, searchResults: searchResults]
        }
    }
}
