package example.grails

import groovy.transform.CompileStatic

@CompileStatic
class SearchController {

    ItunesSearchService itunesSearchService

    def searchWithDeclarativeClient(String searchTerm) {
        if(searchTerm) {
            List<Album> searchResults = itunesSearchService.searchWithDeclarativeClient(searchTerm)
            respond([searchTerm: searchTerm, searchResults: searchResults])
        }
    }

    def searchWithApi(String searchTerm) {
        if(searchTerm) {
            String searchResults = itunesSearchService.searchWithApi(searchTerm)
            respond([searchResults: searchResults])
        }
    }
}
