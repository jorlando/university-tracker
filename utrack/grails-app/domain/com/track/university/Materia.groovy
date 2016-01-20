/* GN 27/04/2015 
 * Se define la clase materia, la misma contendrá la descripciond e las distintas materias de la 
 * Facultad, asi como la ruta de acceso a las correlatividades de la misma.
  */

package com.track.university

class Materia {

	String codigo
	String descripcion
	int	creditos
	Blog blog = new Blog()

	static hasMany = [ correlativas: Materia, cursadas: Cursada ]

    static constraints = {
    	codigo blank:false, nullable: false, unique: true
    	descripcion blank:false, nullable:false
    	creditos nullable:false, min: 1
    }
	
	def toMap(){
		[codigo:this.codigo,descripcion:this.descripcion]
	}
	
	static Materia buscarMateria(String materia){
		Materia.findByCodigo(materia)
	}
	
	static Blog obtenerBlogDeMateria(String materia){
		Materia.findByCodigo(materia).blog
	}
	
	def obtenerCorrelativas(){
		this.correlativas.collect{[codigo:it.codigo, descripcion:it.descripcion]}
	}

    
}
