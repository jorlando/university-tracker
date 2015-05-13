<html>
	<head>
		<title>University Track</title>
	</head>
	<body>
		<h2>Estado de la Carrera</h2>
		<br>
		<h3>Materias Obligatorias</h3>
		<g:render template="/materia/tablaMaterias" model="['materias':carrera.materiasObligatorias]" />
		<br>
		<h3>Materias Optativas</h3>
		<g:render template="/materia/tablaMaterias" model="['materias':carrera.materiasOptativas]" />
	</body>
</html>