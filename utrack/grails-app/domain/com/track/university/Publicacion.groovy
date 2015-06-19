package com.track.university

class Publicacion {
	String titulo
	String cuerpo
	Alumno creador
	
	static hasMany = [comentarios:Comentario]

    static constraints = {
    }
	
	static Publicacion buscarPublicacion(Integer publicacionId){
		Publicacion.findById(publicacionId)
	}
	
	def toMap(){
		def misComentarios = this.comentarios.collect{it.toMap()}
		[titulo: this.titulo,
		cuerpo: this.cuerpo,
		creador: this.creador.nombreCompleto,
		comentarios:misComentarios]
	}
}
