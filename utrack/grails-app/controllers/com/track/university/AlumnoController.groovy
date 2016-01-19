package com.track.university

import com.utrack.university.LoginUtils

class AlumnoController {
	AlumnoService alumnoService
	LoginUtils loginUtils = new LoginUtils()
	
    def login() {
		def padronInt = new Integer(params?.padron)
		def userToLogin = alumnoService.login(padronInt, params?.clave)																																								
		def view = "myAccount"																																														
		if(!userToLogin){ 
			view = "login"
			render(view:view,model:[user:userToLogin])
		}
		else{
			loginUtils.login(padronInt, response)
			session.padron=padronInt
			forward(action:"estadoCursadas", params:[padron:padronInt])
		}
		
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
			
			def materiasPendientesObligatorias=[]
			def materiasYaCursadas=alumno.obtenerCursadas()
			
			Carrera carreraAlumno = alumno.obtenerCarrera()
			def materiasObligatoriasPendientes = carreraAlumno.obtenerMateriasObligatorias(materiasYaCursadas)
			def materiasOptativasPendientes = carreraAlumno.obtenerMateriasOptativas(materiasYaCursadas)

			render	(view:"estadoCursadas",model:[	materiasAprobadas: materiasAprobadas,
													materiasDesaprobadas: materiasDesaprobadas,
													materiasEnCurso: materiasEnCurso,
													materiasObligatoriasPendientes: materiasObligatoriasPendientes,
													materiasOptativasPendientes:materiasOptativasPendientes]
					)

		}
		else render("Debe ingresar un padron")

	
	}
}
																																																																																																																																																																																																																																																																																																																												