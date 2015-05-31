<table id="miCarreraTable">
	<thead>
		<tr>
			<th> Codigo </th>
			<th> Materia </th>
			<th> Creditos </th>
			<th> Estado </th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${materias}">
		<tr>
			<td>${it.codigo}</td>
			<td>${it.descripcion}</td>
			<td>${it.creditos}</td>
			<td>*Pendiente*</td>
		</tr>
	</g:each>
	</tbody>
</table>