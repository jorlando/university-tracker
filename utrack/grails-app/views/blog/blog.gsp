<html>
	<head>
		<title>University Track</title>
	</head>
	<body>
		<h2>Blog - ${blog?.materia?.codigo} - ${blog?.materia?.descripcion}</h2>
		<g:render template="/blog/tablaPublicaciones" model="['blog':blog]" />
	</body>
</html>