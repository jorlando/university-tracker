package com.track.university

import grails.converters.JSON

class BlogController {

	def blogService
	def alumnoService
	
    def crearPublicacion() {
		def creador = alumnoService.obtenerAlumno(111)
		//def creador = alumnoService.obtenerAlumno(params.padron)
		blogService.crearPublicacion(params.materia, params.titulo, params.cuerpo, creador)
		redirect(action: "obtenerBlog", params: [blogId:params.blogId])
    }
	
	def crearComentario() {
		def creador = alumnoService.obtenerAlumno(params.padron)
		blogService.crearComentario(params.publicacionId, params.texto, creador)
		redirect(action: "obtenerPublicacion", params: [publicacionId:params.publicacionId,blogId:params.blogId])
	}
	
	def obtenerBlog() {
		println params
		Blog blog = Materia.obtenerBlogDeMateria(params.materia)
		render	(view:"blog",model:[blog: blog.toMap()])
	}
		
	def obtenerPublicacion() {
		def publicacion = blogService.obtenerPublicacion(params.publicacionId)
		def publicacionMap = publicacion.toMap()
		Blog blog = Materia.obtenerBlogDeMateria(params.materia)
		render	(view:"publicacion",model:[publicacion: publicacionMap,blog:blog.toMap()])
	}
}
