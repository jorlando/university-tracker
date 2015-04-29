package com.track.university

class Carrera {
	
	String nombre
	int codigo
	static hasMany = [materias:Materias]

    static constraints = {
		codigo blank:false, nullable: false, unique: true
		nombre blank:false, nullable:false
    }
}
