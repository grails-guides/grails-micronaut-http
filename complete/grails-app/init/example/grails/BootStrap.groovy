package example.grails

class BootStrap {

    def init = { servletContext ->
        new RecordLabel(name:"Warner").save()
        new RecordLabel(name:"Sony").save()
    }
    def destroy = {
    }
}
