<html>
	<head>
		<title>University Track</title>
	</head>
	<body>
		<g:if test="${user==false}">
			<h3>Fallo el login</h3>
		</g:if>
		<g:form controller="alumno" action="login" class="ch-form" method="get">
				<h2>Ingresa tu cuenta</h2>
				<p class="ch-form-row">
					<label for="padron"> Padron : </label>
					<input id="padron" name="padron" size="10" placeholder="11222" type="number" class="required-key"><br>
					<label for="password"> Password : </label>
					<input id="clave" name="clave" size="50" type="text" class="required-key"><br>
					<a href="registration">No tengo cuenta</a>	
				</p>
				<p class="ch-form-actions"><input type="submit" value="Ingresar" class="ch-btn" id="submitSaveOwner"/></p>
		</g:form>
	</body>
</html>