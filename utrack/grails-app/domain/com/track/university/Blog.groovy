package com.track.university

class Blog {
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
			publicaciones:publicacionesBlog.sort{it.fecha}]
	}
}
