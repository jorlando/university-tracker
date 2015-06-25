package com.utrack.university

import javax.servlet.http.Cookie

class LoginUtils {

	public LoginUtils() {
	}
	
	def encode(padron){
		def octal = Integer.toOctalString(new Integer(padron))
		def hexa = Integer.toHexString(new Integer(octal.toString()))
		hexa
	}
	
	def decode(padronEncoded){
		def hexaInt = Integer.parseInt(padronEncoded.trim(), 16 );
		def octalInt = Integer.parseInt(hexaInt.toString(), 8 );
	}
	
	def getApikey(request){
    	Cookie cookieApi = request.cookies?.find{ it.name == "api_key" }
    	return cookieApi
	}
	
	def setApikey(key,response){
		Cookie cookie = new Cookie('api_key', key)
		cookie.setPath('/')
		response.addCookie(cookie)
	}
	
	def login(padron,response){
		def padronEncoded=this.encode(padron)
		this.setApikey(padronEncoded, response)
	}

}
