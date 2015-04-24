<html>
	<head>
		<title>University Track</title>
	</head>
	<body>
			
		<g:form controller="users" action="create" class="ch-form" method="get">
				<h2>Registra tu cuenta</h2>
				<p class="ch-form-row">
					<label for="padron"> Padron : </label>
					<input id="padron" name="padron" size="10" placeholder="11222" type="number" class="required-key"><br>
					<label for="fullName"> Nombre Completo : </label>
					<input id="fullName" name="fullName" size="50" placeholder="Juan Perez" type="text" class="required-key"><br>
					<label for="email"> Email : </label>
					<input id="email" name="email" size="50" placeholder="nombre.apellido@gmail.com" type="text" class="required-key"><br>
					<label for="password"> Password : </label>
					<input id="password" name="password" size="50" type="text" class="required-key"><br>	
				</p>
				<p class="ch-form-actions"><input type="submit" value="Registrar" class="ch-btn" id="submitSaveOwner"/></p>
		</g:form>
	</body>
</html>