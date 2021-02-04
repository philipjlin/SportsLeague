class UrlMappings {

	static mappings = {

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //Default Route
        "/"(controller:"League", action:"index")
        "500"(view:'/error')


        //Conference Routes
        "/conference"(controller:"Conference", action:"show")
        "500"(view:'/error')


        //BlogEntry Routes
        "/blogentry"(controller:"BlogEntryController", action:"index")
        "500"(view:'/error')

        "/blogentry/addCommentToBlogEntry"(controller:"BlogEntry)", action:"addCommentToBlogEntry")
        "500"(view:'/error')


        //User and Person Routes
        "/users"(controller:"UserController", action:"index")
        "500"(view:'/error')
    }
}
