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
			
			//Algunas materias con correlativas
			Materias materia1 = new Materias(codigo: "61.08", descripcion: "Algebra II", creditos: "8")
			Materias materia2 = new Materias(codigo: "61.03", descripcion: "Analisis II", creditos: "8")
			Materias materia3 = new Materias(codigo: "61.09", descripcion: "Prob. y Estadistica II B", creditos: "6")
			materia3.addToCorrelativas(materia1)
			materia3.addToCorrelativas(materia2)
			mockObjects << materia1
			mockObjects << materia2
			mockObjects << materia3
			
			//Guardo todo, 
			//flush sirve para persistir inmediatamente, no aguarda a la transaccion
			//failOnError levanta una excepcion si falla el salvado.

			mockObjects.each { it.save(flush:true, failOnError:true) }
		}
	}

	def destroy = {
	}
}
