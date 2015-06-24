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
		redirect(action: "obtenerPublicacion", params: [publicacionId:params.publicacionId,blogId:params.blogId])
	}
	
	def obtenerTodosLosBlogs() {
		def blogs = blogService.obtenerTodosLosBlogs()
		def blogsMap = blogs.collect{it.toMap()}
		render blogsMap as JSON
	}
	
	def obtenerBlog() {
		def blogMap =this.obtenerBlogMap(params.blogId)
		render	(view:"blog",model:[blog: blogMap])
	}
	
	def obtenerBlogMap(blogId) {
		def blog = blogService.obtenerBlog(blogId)
		blog.toMap()
	}
	
	def obtenerPublicacion() {
		def publicacion = blogService.obtenerPublicacion(params.publicacionId)
		def publicacionMap = publicacion.toMap()
		def blog=this.obtenerBlogMap(params.blogId)
		render	(view:"publicacion",model:[publicacion: publicacionMap,blog:blog])
	}
}
