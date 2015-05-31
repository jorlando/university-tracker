package com.track.university

class AlumnoController {
	AlumnoService alumnoService
	
    def login() {
		def padronInt = new Integer(params?.padron)
		//println this.class.toString() + ": " + padronInt
		println this.class.toString() + ": " + params
		def userToLogin = alumnoService.login(padronInt, params?.clave)																																								
		def view = "myAccount"																																														
		if(!userToLogin){ view = "login" }
		render(view:view,model:[user:userToLogin])
	}																												 
																																					
	def create() {
		println this.class.toString() + ": " + params
		def userToLogin = alumnoService.create(params)
		def view = "myAccount"
		render(view:"myAccount",model:[user:userToLogin])
	}
	
	def registration() {
		render(view:"registration")
	}
	
	def index() {
		render(view:"login")
	}
	
	def estadoMaterias(){	//Todas las materias de la carrera del alumno por optativas / obligatorias
		Carrera carreraAlumno = alumnoService.obtenerCarrera(params?.padron)
		render(view:"estadoMaterias",model:[carrera:carreraAlumno])
	}

	def estadoCursadas(){
		if (params.padron){
			
			Alumno alumno = alumnoService.obtenerAlumno(params?.padron)
			def materiasAprobadas = []
			alumno.obtenerCursadasAprobadas().each(){materiasAprobadas.add(it.materia)}

			def materiasEnCurso = []
			alumno.obtenerCursadasEnCurso().each(){materiasEnCurso.add(it.materia)}

			def materiasDesaprobadas = []
			alumno.obtenerCursadasDesaprobadas().each(){materiasDesaprobadas.add(it.materia)}

			render	(view:"estadoCursadas",model:[	materiasAprobadas: materiasAprobadas,
													materiasDesaprobadas: materiasDesaprobadas,
													materiasEnCurso: materiasEnCurso]
					)

		}
		else render("Debe ingresar un padron")

	
	}
}
																																																																																																																																																																																																																																																																																																																												