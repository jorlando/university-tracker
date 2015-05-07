package com.track.university

enum Cuatrimestre {PRIMERO, SEGUNDO}

class Periodo {

	static Integer finDePrimerCuatrimestre = 7

	Integer anio
	Cuatrimestre cuatrimestre

    static constraints = {  anio blank:false, nullable:false
    						cuatrimestre blank:false, nullable:false
    }

    public Periodo(Integer nuevoAnio, Integer nuevoMes){
    	this.anio = nuevoAnio
    	(nuevoMes <= finDePrimerCuatrimestre )? PRIMERO : SEGUNDO
    }

    public Periodo(Date fecha){
    	this.anio = fecha.getYear
    	(fecha.getMonth <= finDePrimerCuatrimestre )? PRIMERO : SEGUNDO
    }


}
