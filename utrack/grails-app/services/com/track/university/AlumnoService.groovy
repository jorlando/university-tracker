package com.track.university

import java.util.Date;


class AlumnoService {

    def login(Integer padron, String password) {
		Alumno userToLogin = Alumno.findByPadron(padron)
		if(userToLogin?.validPassword(password)){return userToLogin}
		false
    }
	
	Alumno create(paramsToCreate){
		Alumno newUser = new Alumno()
		newUser.padron = new Integer(paramsToCreate.padron)
		newUser.nombreCompleto = paramsToCreate.nombreCompleto
		newUser.email = paramsToCreate.email
		newUser.clave = paramsToCreate.clave
		newUser.carrera = Carrera.findByCodigo(paramsToCreate?.carrera)
		newUser.save(flush:true, failOnError:true)
		newUser
	}
	
	Alumno modify(paramsToCreate){
		Alumno userModify = new Alumno()
		if(paramsToCreate?.nombreCompleto){ userModify.nombreCompleto = paramsToCreate.nombreCompleto }
		if(paramsToCreate?.email){ userModify.email = paramsToCreate.email }
		if(paramsToCreate?.clave){ userModify.clave = paramsToCreate.clave }
		if(paramsToCreate?.carrera){ userModify.carrera = Carrera.findByCodigo(paramsToCreate?.carrera) }
		userModify.save(flush:true, failOnError:true)
		userModify
	}
	
}
