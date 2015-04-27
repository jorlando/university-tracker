import grails.util.Environment;
import com.track.university.*;

class BootStrap {

    def init = { servletContext ->
		if(Environment.current.equals(Environment.DEVELOPMENT)){

			def mockObjects = []

			//POOL
			//KEY-TRANSACTIONS
			Users userUno = new Users(padron:111, fullName:"alumno uno", email:"alumno1@university.com", password:"test")
			mockObjects << userUno
			Users userDos = new Users(padron:222, fullName:"alumno dos", email:"alumno2@university.com", password:"test")
			mockObjects << userDos
			Users userTres = new Users(padron:333, fullName:"alumno tres", email:"alumno3@university.com", password:"test")
			mockObjects << userTres
			//Materias materia1 = new Materias(codigo: "61.08", descripcion: "Algebra II")
			//mockObjects << materia1
			//mockObjects << new Materias(codigo: "61.03", descripcion: "Analisis Matematico II")
			//mockObjects new Materias(codigo: "61.09", descripcion: "Prob. y Estadistica II B")


			
			mockObjects.each { it.save(failOnError:true) }
		}
	}

	def destroy = {
	}
}
