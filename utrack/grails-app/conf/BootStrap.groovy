import grails.util.Environment;
import com.track.university.*;

class BootStrap {

    def init = { servletContext ->
		if(Environment.current.equals(Environment.DEVELOPMENT)){
			def mockObjects = []
			
			Blog blogAlgebra = new Blog()
			mockObjects << blogAlgebra
			
			Blog blogAnalisis = new Blog()
			mockObjects << blogAnalisis
			
			Blog blogProba = new Blog()
			mockObjects << blogProba
			
			Blog blogInteligenciaArtificial = new Blog()
			mockObjects << blogInteligenciaArtificial
			
			//Algunas Materia con correlativas
			Materia algebra = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: 8)
			algebra.blog = blogAlgebra
			Materia analisis = new Materia(codigo: "61.03", descripcion: "Analisis II", creditos: 8)
			analisis.blog = blogAnalisis
			Materia probabilidadEstadistica = new Materia(codigo: "61.09", descripcion: "Prob. y Estadistica II B", creditos: 6)
			probabilidadEstadistica.blog = blogProba
			Materia inteligenciaArtifical = new Materia(codigo: "75.23", descripcion: "Inteligencia Artificial", creditos: 6)
			inteligenciaArtifical.blog = blogInteligenciaArtificial
			
			probabilidadEstadistica.addToCorrelativas(algebra)
			probabilidadEstadistica.addToCorrelativas(analisis)
			mockObjects << algebra
			mockObjects << analisis
			mockObjects << probabilidadEstadistica
			mockObjects << inteligenciaArtifical
			
			// CARRERAS con Materia
			Carrera licSistemas = new Carrera(codigo:9, nombre:"Lic. Analisis de Sistemas")
			licSistemas.addToMateriasObligatorias(algebra)
			licSistemas.addToMateriasObligatorias(analisis)
			licSistemas.addToMateriasObligatorias(probabilidadEstadistica)
			licSistemas.addToMateriasOptativas(inteligenciaArtifical)
			mockObjects << licSistemas
			
			Carrera ingSistemas = new Carrera(codigo:10, nombre:"Ing. Sistemas")
			ingSistemas.addToMateriasObligatorias(algebra)
			ingSistemas.addToMateriasObligatorias(analisis)
			ingSistemas.addToMateriasObligatorias(probabilidadEstadistica)
			ingSistemas.addToMateriasObligatorias(inteligenciaArtifical)
			mockObjects << ingSistemas
			
			Alumno userUno = new Alumno(padron:111, nombreCompleto:"alumno uno", email:"alumno1@university.com", clave:"test",carrera:licSistemas)
			mockObjects << userUno
			Alumno userDos = new Alumno(padron:222, nombreCompleto:"alumno dos", email:"alumno2@university.com", clave:"test",carrera:ingSistemas)
			mockObjects << userDos

			Cursada cursada = new Cursada(	alumno: userUno, materia: algebra)
			mockObjects << cursada
			
			// BLOG Materias 
/*			
			Publicacion nuevaPublicacion1 = new Publicacion(titulo:"titulo de una publicacion1",
															cuerpo:"cuerpo de una publicacion1",
															creador:userUno)
			Publicacion nuevaPublicacion2 = new Publicacion(titulo:"titulo de una publicacion2",
															cuerpo:"cuerpo de una publicacion2",
															creador:userDos)
			algebra.blog.addToPublicaciones(nuevaPublicacion1)
			algebra.blog.addToPublicaciones(nuevaPublicacion2)
			
			Comentario nuevoComentario1 = new Comentario(texto:"texto 1 publicacion",creador:userDos)
			nuevaPublicacion1.addToComentarios(nuevoComentario1)
			Comentario nuevoComentario2 = new Comentario(texto:"texto 2 publicacion",creador:userDos)
			nuevaPublicacion1.addToComentarios(nuevoComentario2)
			
			mockObjects << nuevaPublicacion1
			mockObjects << nuevaPublicacion2*/
			
			//Guardo todo, 
			//flush sirve para persistir inmediatamente, no aguarda a la transaccion
			//failOnError levanta una excepcion si falla el salvado.

			mockObjects.each { it.save(flush:true, failOnError:true) }
			
		}
	}

	def destroy = {
	}
}
