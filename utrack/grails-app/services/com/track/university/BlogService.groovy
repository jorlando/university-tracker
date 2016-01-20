package com.track.university

class BlogService {

    def crearPublicacion(materia, String titulo, String cuerpo, Alumno alumnoCreador) {
		Publicacion nuevaPublicacion = new Publicacion(titulo:titulo,cuerpo:cuerpo, creador:alumnoCreador)
		Blog blogBuscado = Materia.obtenerBlogDeMateria(materia)
		blogBuscado.addToPublicaciones(nuevaPublicacion)
		blogBuscado.save(flush:true, failOnError:true)
    }
	
	def obtenerBlog(blogId){
		Blog.buscarBlog(new Integer(blogId))
	}
	
	
	def obtenerPublicacion(publicacionId){
		Publicacion.buscarPublicacion(new Integer(publicacionId))
	}
	
	
	def crearComentario(publicacionId,String texto, Alumno alumnoCreador){
		Publicacion publicacionAComentar = this.obtenerPublicacion(publicacionId)
		Comentario nuevoComentario = new Comentario(texto:texto,creador:alumnoCreador)
		publicacionAComentar.addToComentarios(nuevoComentario)
		publicacionAComentar.save(flush:true, failOnError:true)
	}
}
