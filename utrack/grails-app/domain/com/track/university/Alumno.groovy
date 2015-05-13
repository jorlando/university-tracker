package com.track.university

class Alumno {
	
	Integer padron
	String nombreCompleto
	String email
	Date fechaRegistracion = new Date()
	String clave
	Carrera carrera
	
	static hasMany = [cursadas: Cursada]

    static constraints = {
    	padron blank: false
    	nombreCompleto blank: false
    	email blank: false
    	clave blank: false
		carrera nullable: true
    }

	boolean validPassword(pwd){
		(pwd==this.clave)
	}
    
    static Alumno buscarAlumno(Integer unPadron){ 
    	Alumno.findByPadron(unPadron) 
    }
}
