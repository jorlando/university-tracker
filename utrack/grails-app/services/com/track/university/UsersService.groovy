package com.track.university

import java.util.Date;


class UsersService {

    def login(Integer padron, String password) {
		Users userToLogin = Users.findByPadron(padron)
		if(userToLogin?.validPassword(password)){return userToLogin}
		false
    }
	
	Users createUser(paramsToCreate){
		Users newUser = new Users()
		newUser.padron = new Integer(paramsToCreate.padron)
		newUser.fullName = paramsToCreate.fullName
		newUser.email = paramsToCreate.email
		newUser.password = paramsToCreate.password
		newUser.save(failOnError:true)
		newUser
	}
	
	Users modifyUser(paramsToCreate){
		Users newUser = new Users()
		if(paramsToCreate?.fullName){ newUser.fullName = paramsToCreate.fullName }
		if(paramsToCreate?.email){ newUser.email = paramsToCreate.email }
		if(paramsToCreate?.password){ newUser.password = paramsToCreate.password }
		newUser.save(failOnError:true)
		newUser
	}
}
