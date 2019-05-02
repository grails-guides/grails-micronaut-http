package example.grails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "gameflict")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
