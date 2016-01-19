package com.track.university

import com.utrack.university.LoginUtils

class LoginFilters {	
	LoginUtils loginUtils = new LoginUtils()
    def filters = {
		/*allExceptIndex(controller:"alumno",action:"index",invert:true) {
            before = {
				def apiKeyCookie = loginUtils.getApikey(request)
				if(!(apiKeyCookie?.value)){
					redirect(controller:"alumno", action:"index")
				}else{
					def padronDesencodeado = loginUtils.decode(apiKeyCookie?.value)
					if(padronDesencodeado!=session.padron){
						redirect(controller:"alumno", action:"index")
					}
				}
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }*/
    }
}
