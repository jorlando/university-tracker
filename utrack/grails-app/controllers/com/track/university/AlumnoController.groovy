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
}
																																																																																																																																																																																																																																																																																																																												