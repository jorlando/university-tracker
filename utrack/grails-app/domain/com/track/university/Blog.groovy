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
		[
			id:this.id,
			materia:materia.toMap(),
			publicaciones:publicacionesBlog.sort{it.fecha}]
	}
	
	static def obtenerTodosLosBlogs(){
		Blog.findAll()
	}
}
