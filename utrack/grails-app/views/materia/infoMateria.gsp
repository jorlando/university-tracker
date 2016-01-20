<html>
	<head>
		<title>University Track</title>
	</head>
	<body>		
		<h2>${codigo} - ${descripcion}</h2>
		<a href="${createLink(uri:'/blog/'+codigo)}">Ver Blog</a>
		<p>Correlativas</p>
		
		<g:each in="${correlativas}">
			<p>${it.codigo} - ${it.descripcion}</p>
		</g:each>
	</body>
</html>