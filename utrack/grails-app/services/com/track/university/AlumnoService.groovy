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
		newUser.save(failOnError:true)
		newUser
	}
	
	Alumno modify(paramsToCreate){
		Alumno newUser = new Alumno()
		if(paramsToCreate?.nombreCompleto){ newUser.nombreCompleto = paramsToCreate.nombreCompleto }
		if(paramsToCreate?.email){ newUser.email = paramsToCreate.email }
		if(paramsToCreate?.clave){ newUser.clave = paramsToCreate.clave }
		newUser.save(failOnError:true)
		newUser
	}
}
