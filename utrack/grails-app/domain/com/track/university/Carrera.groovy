package com.track.university

class Carrera {
	
	String nombre
	int codigo
	
	static hasMany = [materiasObligatorias:Materia, materiasOptativas:Materia]

    static constraints = {
		codigo blank:false, nullable: false, unique: true
		nombre blank:false, nullable:false
    }
	
	def obtenerMateriasOptativas(materiasAExcluir){
		this.eliminarCursadas(materiasOptativas, materiasAExcluir)
	}
	
	def obtenerMateriasObligatorias(materiasAExcluir){
		this.eliminarCursadas(materiasObligatorias, materiasAExcluir)
	}
	
	def eliminarCursadas(materiasDeLaCarrera,materiasCursadas){
		def materiasPendientes=[]
		def materiasCursadasAEliminar = materiasCursadas.collect{it.obtenerMateria()}
		materiasDeLaCarrera.each{Materia materiaAEvaluar->
			if(!(materiasCursadasAEliminar.contains(materiaAEvaluar))){
				materiasPendientes.add(materiaAEvaluar)
			}
		}
		materiasPendientes
	}
}
