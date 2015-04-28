package com.track.university

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Materias)
class MateriasSpec extends Specification {


    void "Pruebo guardar una Materia Erronea"() {
    	
    	given: "Creo una Materia Erronea"
    		def materiasErronea = new Materias()  

    	when: "Guardo la Materia"
    		materiaCorrecta.save(flush: true, failOnError: true)
    	
    	then: "Todo debe salir mal"
    		thrown(grails.validation.ValidationException)
    		//!Materias.findByCodigo("61.08")
    }

    def "Guardo una Materia Correcta"(){
    	
    	given: "Creo una Materia Buena"
    		def materiaCorrecta = new Materias(codigo: "61.08", descripcion: "Algebra II", creditos: "8") 
    	
    	when: "Guardo la Materia"
    		materiaCorrecta.save(flush: true, failOnError: true)

    	then: "Todo debe salir bien"
    		notThrown(grails.validation.ValidationException)

    	cleanup:
    		materiaCorrecta.delete(flush:true)
    }
}
