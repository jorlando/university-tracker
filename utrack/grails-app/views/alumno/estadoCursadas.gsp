<html>
	<head>
		<title>University Track</title>
	</head>
	<body>
		<h2>Estado de la Cursada</h2>
		<br>
		<h3>Materias Aprobadas</h3>
		<g:render template="/materia/tablaMaterias" model="['materias':materiasAprobadas]" />
		<br>
		<h3>Materias En Curso</h3>
		<g:render template="/materia/tablaMaterias" model="['materias':materiasEnCurso]" />
		<br>
		<h3>Materias Desaprobadas</h3>
		<g:render template="/materia/tablaMaterias" model="['materias':materiasDesaprobadas]" />
	</body>
</html>