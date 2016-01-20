<html>
	<head>
		<title>University Track</title>
	</head>
	<body>
		<h2>Blog - ${params.materia}</h2>
		<g:render template="/blog/tablaPublicaciones" model="['blog':blog]" />
		
		<g:form controller="blog" action="crearPublicacion" method="post">
			<h3>Agregar Publicacion</h3>
			<p class="ch-form-row">
			<label for="titulo"> Titulo : </label>
			<input id="titulo" name="titulo" size="200" placeholder="" type="text" class="required-key" required><br>
			<label for="cuerpo"> Texto : </label>
				<input id="cuerpo" name="cuerpo" size="1000" placeholder="Ingrese el cuerpo de su publicacion" type="text" class="required-key" required><br>
				<input id="blogId" name="blogId" size="5" type="text" value="${blog?.id}" required hidden=true ><br>
				<input id="padron" name="padron" size="6" type="text" value="111" required hidden=true><br>			
			</p>
			<p class="ch-form-actions"><input type="submit" value="Comentar!" class="ch-btn" id="submitCreateKey"/></p>
			</g:form>
	</body>
</html>