class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		"/home"(controller: "alumno"){
			action = [GET: "index"]
		}
		
		"/registration"(controller: "alumno"){
			action = [GET: "registration"]
		}
		
		"/blogs/$blogId?"(controller: "blog"){
			action = [GET: "obtenerBlog"]
		}
		"/blogs/$blogId/publicacion/$publicacionId?"(controller: "blog"){
			action = [GET: "obtenerPublicacion"]
		}
		
		"/console/$action/" { controller = "console" }
		
	}
}
