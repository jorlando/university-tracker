/* GN 27/04/2015 
 * Se define la clase materia, la misma contendrá la descripciond e las distintas materias de la 
 * Facultad, asi como la ruta de acceso a las correlatividades de la misma.
  */

package com.track.university

class Materias {

	String codigo
	String descripcion
	int	creditos

	static hasMany = [correlativas:Materias]
	//static belongsTo = [materia: Materias]

    static constraints = {
    }
}
