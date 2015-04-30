package com.track.university

class MateriaController {
	AlumnoService alumnoService

    def index() { render("holaa")}

    def materiasAlumno () {

    	Integer padron = params?.int("padron")
    	
    	println(padron)

    	def alumno = Alumno.buscarAlumno(padron)

    	if (!alumno)
    	{
    		render("Debe especificar el padron")
    	}else{
    		Materia.buscarMateriasCursadas(alumno)
    	}

    }
}
