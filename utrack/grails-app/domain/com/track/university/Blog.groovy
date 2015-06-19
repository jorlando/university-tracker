package com.track.university

class Blog {
	
	Materia materia
	static hasMany = [publicaciones: Publicacion]
	

    static constraints = {
    }
	
	static Blog buscarBlog(Integer blog){
		Blog.findById(blog)
	}
	
	def toMap(){
		def publicacionesBlog = publicaciones.collect{it.toMap()}
		[materia:materia.toMap(),
			publicaciones:publicacionesBlog]
	}
	
	def obtenerTodosLosBlogs(){
		Blog.findAll()
	}
}
