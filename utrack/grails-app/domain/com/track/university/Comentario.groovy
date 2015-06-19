package com.track.university

class Comentario {
	Alumno creador
	String texto

    static constraints = {
    }
	
	def toMap(){
		[creador:this.creador.nombreCompleto,
			texto:this.texto]
	}
}
