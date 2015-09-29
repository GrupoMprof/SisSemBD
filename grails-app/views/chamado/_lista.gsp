<g:if test="${chamados?.size() > 0 }">
	<table>
		<tr>
			<th>Título</th>
			<th>Data Abertura</th>
			<th>Solução</th>
			<th>Status</th>
		</tr>
		
		<g:each var="chamado" in="${chamados}">
		<tr>
			<td>${chamado?.titulo}</td>
			<td>${chamado?.dataAbertura}</td>
			<td>${chamado?.solucao}</td>
			<td>${chamado?.status?.descricao}</td>
		</tr>
		</g:each>	
		
	</table>
</g:if>
<g:else>Não existe chamados cadastrados!!</g:else>