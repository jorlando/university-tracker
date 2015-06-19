package com.track.university


class Cursada {

	enum Estado {CURSANDO, APROBADA, DESAPROBADA}

	Alumno alumno
	Materia materia
	Periodo periodo 
	Estado estado = Estado.CURSANDO
	
    static constraints = {
    	periodo nullable:true
    	//alumno unique:["materia", "periodo"]

    }
	
	def obtenerMateria(){
		return materia
	}
}
