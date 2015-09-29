<g:if test="${chamados?.size() > 0 }">
	<table>
		<tr>
			<!-- <th>Usuário</th> -->
			<th>Título</th>
			<th>Data Abertura</th>
			<th>Data Fechamento</th>
			<th>Status</th>
			<th>Ações</th>
		</tr>
		
		<g:each var="chamado" in="${chamados}">
		<tr>
			<!-- <td>${chamado?.usuario?.username}</td>  -->
			<td>${chamado?.titulo}</td>
			<td>${chamado?.dataAbertura}</td>
			<td>${chamado?.dataFechamento}</td>
			<td>${chamado?.status?.descricao}</td>
			<td>				
				<g:remoteLink controller="chamadoAdmin" action="alterar" update="divForm" id="${chamado.id}">Atender</g:remoteLink>
				&nbsp;
				<a href="#" onclick="excluir('${chamado.id}')">Excluir</a>
			</td>	
		</tr>
		</g:each>	
		
	</table>
</g:if>
<g:else>Não existe chamados cadastrados!!</g:else>