package com.track.university

class UsersController {
	UsersService usersService
	
    def login() {
		def padronInt = new Integer(params?.padron)
		//println this.class.toString() + ": " + padronInt
		println this.class.toString() + ": " + params
		def userToLogin = usersService.login(padronInt, params?.password)																																								
		def view = "myAccount"																																														
		if(!userToLogin){ view = "login" }
		render(view:view,model:[user:userToLogin])
	}																												 
																																					
	def create() {
		println this.class.toString() + ": " + params
		def userToLogin = usersService.createUser(params)
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
																																																																																																																																																																																																																																																																																																																												