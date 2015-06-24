package com.track.university

import java.util.Date;

class Comentario {
	Alumno creador
	String texto
	Date dateCreated

    static constraints = {
    }
	static mapping = {
		sort dateCreated: "desc"
	}
	
	def toMap(){
		[creador:this.creador.nombreCompleto,
			texto:this.texto,
			fecha: this.dateCreated]
	}
}
