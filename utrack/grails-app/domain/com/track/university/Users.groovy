package com.track.university

class Users {
	
	Integer padron
	String fullName
	String email
	Date registrationDate = new Date()
	String password
	
	boolean validPassword(pwd){
		(pwd==this.password)
	}

    static constraints = {
    }
}
