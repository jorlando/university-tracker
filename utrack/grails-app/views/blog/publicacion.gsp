<html>
	<head>
		<title>University Track</title>
	</head>
	<body>		
		<p>Volver al blog <a href="${createLink(uri:'/blogs/'+blog?.id)}" >${blog?.materia?.codigo} - ${blog?.materia?.descripcion}</a></p>
		
		<h3>${publicacion.titulo}</h3>
		<h4>${publicacion.fecha}</h4>
		<p>${publicacion.cuerpo}</p>
		<h4>Comentarios</h4>
		<table class="tablaComentarios">
				<tbody>
					<g:each in="${publicacion?.comentarios}">
					<tr>
						<td>${it.fecha}</td>
						<td>${it.creador}</td>
						<td>${it.texto}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			
			<g:form controller="blog" action="crearComentario" method="post">
			<h3>Agregar comentario</h3>
			<p class="ch-form-row">
				<input id="texto" name="texto" size="1000" placeholder="Ingrese su comentario" type="text" class="required-key" required><br>
				<input id="blogId" name="blogId" size="5" type="text" value="${blog.id}" required><br>
				<input id="padron" name="padron" size="6" type="text" value="111" required ><br>
				<input id="publicacionId" name="publicacionId" size="6" type="text" value="${publicacion.id}" required><br>			
			</p>
			<p class="ch-form-actions"><input type="submit" value="Comentar!" class="ch-btn" id="submitCreateKey"/></p>
			</g:form>
	</body>
</html>