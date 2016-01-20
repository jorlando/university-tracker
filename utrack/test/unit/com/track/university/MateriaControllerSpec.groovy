package com.track.university

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MateriaController)
@Mock([Materia])
class MateriaControllerSpec extends Specification {

    def setup() {
		Materia algebra = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: "8")
		Materia analisis = new Materia(codigo: "61.03", descripcion: "Analisis II", creditos: "8")
		Materia probabilidadEstadistica = new Materia(codigo: "61.09", descripcion: "Prob. y Estadistica II B", creditos: "6")
		Materia inteligenciaArtifical = new Materia(codigo: "75.23", descripcion: "Inteligencia Artificial", creditos: "6")
		
		probabilidadEstadistica.addToCorrelativas(algebra)
		probabilidadEstadistica.addToCorrelativas(analisis)
		probabilidadEstadistica.save()
		inteligenciaArtifical.save()
    }

    def cleanup() {
    }

    void "test mostrarInfoMateria sin id"() {
		when:
			controller.mostrarInfoMateria()
		then:
			response.text == "materia invalida"
    }
	
	void "test mostrarInfoMateria con un id no guardado"() {
		given:
			params.id= "75.41"
		when:
			controller.mostrarInfoMateria()
		then:
			response.text == "materia invalida"
	}
	
	void "test mostrarInfoMateria con una materia sin correlativas"() {
		given:
			params.id= "61.08"
		when:
			controller.mostrarInfoMateria()
		then:
			view == "/materia/infoMateria"
			model.correlativas == []
			model.codigo == "61.08"
			model.descripcion == "Algebra II"
	}
	
	void "test mostrarInfoMateria con una materia con correlativas"() {
		given:
			params.id= "61.09"
		when:
			controller.mostrarInfoMateria()
		then:
			view == "/materia/infoMateria"
			model.correlativas.contains([codigo: "61.03", descripcion: "Analisis II"])
			model.correlativas.contains([codigo: "61.08",descripcion: "Algebra II"])
			model.codigo == "61.09"
			model.descripcion == "Prob. y Estadistica II B"
	}
	
	
	//view == "..."
	//model == [...]
}
