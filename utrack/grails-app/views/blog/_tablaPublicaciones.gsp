<table class="tablaPublicaciones" border="1">
	<thead>
		<tr>
			<th> Fecha </th>
			<th> Creador </th>
			<th> Titulo </th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${blog.publicaciones}">
		<tr>
			<td>${it.fecha}</td>
			<td>${it.creador}</td>
			<td><a href="${createLink(uri:'/blogs/'+blog.id+'/publicacion/'+it.id)}">${it.titulo}</a></td>
		</tr>
	</g:each>
	</tbody>
</table>