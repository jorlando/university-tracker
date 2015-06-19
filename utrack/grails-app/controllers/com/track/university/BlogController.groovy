package com.track.university

import grails.converters.JSON

class BlogController {

	def blogService
	def alumnoService
	
    def crearPublicacion() {
		def creador = alumnoService.obtenerAlumno(params.padron)
		blogService.crearPublicacion(params.blogId, params.titulo, params.cuerpo, creador)
		Blog blogParaMostrar = blogService.obtenerBlog(params.blogId)
		render blogParaMostrar.toMap() as JSON
    }
	
	def crearComentario() {
		def creador = alumnoService.obtenerAlumno(params.padron)
		blogService.crearComentario(params.publicacionId, params.texto, creador)
		Blog blogParaMostrar = blogService.obtenerBlog(params.blogId)
		render blogParaMostrar.toMap() as JSON
	}
	
	def obtenerTodosLosBlogs() {
		def blogs = blogService.obtenerTodosLosBlogs()
		def blogsMap = blogs.collect{it.toMap()}
		render blogsMap as JSON
	}
}
