package com.track.university

import grails.converters.JSON;

class MateriaController {
    def materiasAlumno () {

    	Integer padron = params?.int("padron")
    	def alumno = Alumno.buscarAlumno(padron)

    	if (!alumno)
    	{
    		render("Debe especificar el padron")
    	}else{
    		alumno.obtenerCursadas()
    	}
    }
	
	def mostrarInfoMateria(){
		Materia materia = Materia.buscarMateria(params.id)
		if (!materia){
			render("materia invalida")
		}else{
			def mapToView = [
								correlativas: materia.obtenerCorrelativas(),
								codigo: materia.getCodigo(),
								descripcion:materia.getDescripcion()
							]
			render(view:"infoMateria",model:mapToView)
		}
	}
}
