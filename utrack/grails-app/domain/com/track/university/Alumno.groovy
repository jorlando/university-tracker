package com.track.university

class Alumno {
	
	Integer padron
	String nombreCompleto
	String email
	Date fechaRegistracion = new Date()
	String clave
	Carrera carrera
	
	static hasMany = [cursos: Materia]

    static constraints = {
    	padron blank: false
    	nombreCompleto blank: false
    	email blank: false
    	clave blank: false
		carrera nulleable: true
    }

	boolean validPassword(pwd){
		(pwd==this.clave)
	}
    
    Alumno buscarAlumno(Integer unPadron){ 
    	Alumno.findAllByPadron(unPadron) 
    }
}
