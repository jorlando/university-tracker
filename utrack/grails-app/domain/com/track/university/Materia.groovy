/* GN 27/04/2015 
 * Se define la clase materia, la misma contendrá la descripciond e las distintas materias de la 
 * Facultad, asi como la ruta de acceso a las correlatividades de la misma.
  */

package com.track.university

class Materia {

    Carrera carrera
	String codigo
	String descripcion
	int	creditos

	static hasMany = [ correlativas: Materia, cursadas: Cursada ]

    //static belongsTo = Alumno

    static constraints = {
    	
    	codigo blank:false, nullable: false, unique: true
    	descripcion blank:false, nullable:false
    	creditos nullable:false, min: 1
    }

    def buscarMateriasCursadas(alumno){
        Materia.findAllByEstudiantes(alumno)
    }
}
