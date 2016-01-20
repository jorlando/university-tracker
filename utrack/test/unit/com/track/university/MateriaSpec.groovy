package com.track.university

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Materia)
class MateriaSpec extends Specification {


    def "No se puede crear una Materia sin Codigo"() {
    	
    	given: 
    		def materiaErronea = new Materia(descripcion: "Mat", creditos: 1)  

    	when: "Guardo la Materia"
    		materiaErronea.save(flush: true, failOnError: true)
    	
    	then: "Debe levantar una excepcion"
    		thrown(grails.validation.ValidationException)
    }

    def "No se puede crear uan Materia sin Descripcion"(){

        given: 
            def materiaErronea = new Materia(codigo: "61.08", creditos: 1)  

        when: "Guardo la Materia"
            materiaErronea.save(flush: true, failOnError: true)
        
        then: "Todo debe salir mal"
            thrown(grails.validation.ValidationException)
    }

    def "No se puede crear un Materia sin Creditos"(){
        
        given: 
            def materiaErronea = new Materia(codigo: "61.08", descripcion: "Algebra II")  

        when: "Guardo la Materia"
            materiaErronea.save(flush: true, failOnError: true)
        
        then: "Todo debe salir mal"
            thrown(grails.validation.ValidationException)
    }
    
    def "No se puede crear una Materia con Creditos en 0"(){  

        given:
            def materiaErronea = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: 0)  

        when: "Guardo la Materia"
            materiaErronea.save(flush: true, failOnError: true)
        
        then: "Todo debe salir mal"
            thrown(grails.validation.ValidationException)
    	
    }

    def "Se puede guardar una Materia con Codigo, Descripcion y Creditos"(){
    	
    	given:
    		def materiaCorrecta = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: 8) 
    	
    	when: "Guardo la Materia"
    		materiaCorrecta.save(flush: true, failOnError: true)

    	then: "Todo debe salir bien"
    		notThrown(grails.validation.ValidationException)

    	cleanup:
    		materiaCorrecta.delete(flush:true)
    }
	
	def "test obtenerCorrelativas de una materia con correlativas"(){
		given:
			def materiaPrincipal = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: 8)
			def materiaCorrelativa1 = new Materia(codigo: "1", descripcion: "correlativa1", creditos: 8)
			def materiaCorrelativa2 = new Materia(codigo: "2", descripcion: "correlativa2", creditos: 8)
			materiaPrincipal.addToCorrelativas(materiaCorrelativa1)
			materiaPrincipal.addToCorrelativas(materiaCorrelativa2)
			materiaPrincipal.save(flush: true, failOnError: true)
		when:
			def correlativas = materiaPrincipal.obtenerCorrelativas()
		then:
			correlativas == [[codigo:"1", descripcion:"correlativa1"], [codigo:"2", descripcion:"correlativa2"]]
	}
	
	def "test obtenerCorrelativas de una materia sin correlativas"(){
		given:
			def materiaPrincipal = new Materia(codigo: "61.08", descripcion: "Algebra II", creditos: 8)
			materiaPrincipal.save(flush: true, failOnError: true)
		when:
			def correlativas = materiaPrincipal.obtenerCorrelativas()
		then:
			correlativas == []
	}
}
