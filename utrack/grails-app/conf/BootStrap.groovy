import grails.util.Environment;
import com.track.university.*;

class BootStrap {

    def init = { servletContext ->
		/*if(Environment.current.equals(Environment.DEVELOPMENT)){
			def mockObjects = []
			
			//Algunas Materia con correlativas
			//Materia materia1 = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: "8")
			//Materia materia2 = new Materia(codigo: "61.03", descripcion: "Analisis II", creditos: "8")
			//Materia materia3 = new Materia(codigo: "61.09", descripcion: "Prob. y Estadistica II B", creditos: "6")
			//materia3.addToCorrelativas(materia1)
			//materia3.addToCorrelativas(materia2)
			//mockObjects << materia1
			//mockObjects << materia2
			//mockObjects << materia3
			
			// CARRERAS con Materia
			Carrera licSistemas = new Carrera(codigo:9, nombre:"Lic. Analisis de Sistemas")
			//licSistemas.addToMaterias(materia1)
			//licSistemas.addToMaterias(materia2)
			//licSistemas.addToMaterias(materia3)
			//mockObjects << licSistemas
			
			Carrera ingSistemas = new Carrera(codigo:10, nombre:"Ing. Sistemas")
			//ingSistemas.addToMaterias(materia1)
			//ingSistemas.addToMaterias(materia2)
			//ingSistemas.addToMaterias(materia3)
			//mockObjects << ingSistemas
			
			Alumno userUno = new Alumno(padron:111, nombreCompleto:"alumno uno", email:"alumno1@university.com", clave:"test",carrera:licSistemas)
			mockObjects << userUno
			Alumno userDos = new Alumno(padron:222, nombreCompleto:"alumno dos", email:"alumno2@university.com", clave:"test",carrera:ingSistemas)
			mockObjects << userDos
			Alumno userTres = new Alumno(padron:333, nombreCompleto:"alumno tres", email:"alumno3@university.com", clave:"test",carrera:ingSistemas)
			mockObjects << userTres
			
			
			
			
			
			//Guardo todo, 
			//flush sirve para persistir inmediatamente, no aguarda a la transaccion
			//failOnError levanta una excepcion si falla el salvado.

			mockObjects.each { it.save(flush:true, failOnError:true) }
			
		}*/
	}

	def destroy = {
	}
}
