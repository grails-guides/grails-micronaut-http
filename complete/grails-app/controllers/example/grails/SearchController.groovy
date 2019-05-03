package example.grails

import groovy.transform.CompileStatic

@CompileStatic
class SearchController {

    ItunesSearchService itunesSearchService

    def searchWithDeclarativeClient(String searchTerm) {
        if(searchTerm) {
            List<Album> albums = itunesSearchService.searchWithDeclarativeClient(searchTerm)
            respond([searchTerm: searchTerm, albums: albums])
        }
    }

    def searchWithApi(String searchTerm) {
        if(searchTerm) {
            List<Album> albums = itunesSearchService.searchWithApi(searchTerm)
            respond([searchTerm: searchTerm, albums: albums])
        }
    }

    def searchWithClientBeanInContext(String searchTerm) {
        if(searchTerm) {
            List<Album> albums = itunesSearchService.searchWithClientBeanInContext(searchTerm)
            respond([searchTerm: searchTerm, albums: albums])
        }
    }
}
