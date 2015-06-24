package com.track.university

class Publicacion {
	String titulo
	String cuerpo
	Alumno creador
	Date dateCreated
	
	static hasMany = [comentarios:Comentario]

    static constraints = {
    }
	
	static mapping = {
		sort dateCreated: "desc"
	}
	
	static Publicacion buscarPublicacion(Integer publicacionId){
		Publicacion.findById(publicacionId)
	}
	
	def toMap(){
		def misComentarios = this.comentarios.collect{it.toMap()}
		[
			id:this.id,
			titulo: this.titulo,
			cuerpo: this.cuerpo,
			creador: this.creador.nombreCompleto,
			comentarios:misComentarios.sort{it.fecha},
			fecha: this.dateCreated]
	}
}
