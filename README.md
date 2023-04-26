<h1>Projeto Gastomeu</h1>
<h2>Descrição</h2>
<p>Este projeto é uma aplicação web para gerenciamento de despesas pessoais, onde o usuário pode cadastrar suas categorias de gastos, cartões de crédito, transações e gerar relatórios de suas despesas.</p><h2>Tecnologias Utilizadas</h2>
<ul>
	<li>Java</li>
	<li>Spring Boot</li>
	<li>PostgreSQL</li>
	<li>Hibernate</li>
	<li>MapStruct</li>
	<li>Lombok</li>
</ul>
<h2>Configuração</h2>
<p>Clone o repositório:</p>
<pre>
	<code class="!whitespace-pre hljs language-sh">git clone https://github.com/seu-usuario/gastomeu.git</code>
</pre>
<p>Configure as credenciais do banco de dados no arquivo 
	<code>application.yaml</code>:
</p>
<pre>
  <code class="!whitespace-pre hljs language-bash">
    spring:
        datasource:
          url: jdbc:postgresql://localhost:5432/gastomeu
          username: seu-usuario
          password: sua-senha
  </code>
</pre>
<p>Execute a aplicação:</p>
<pre>
	<code class="!whitespace-pre hljs language-sh">./mvnw spring-boot:run</code>
</pre>
<p>Acesse a aplicação em <a href="http://localhost:8080/gastomeu" target="_new">http://localhost:8080/gastomeu</a></p>
<h2>Funcionalidades</h2>
<ul>
	<li>Cadastro de categorias de gastos</li>
	<li>Cadastro de cartões de crédito</li>
	<li>Cadastro de transações</li>
	<li>Geração de relatórios de despesas</li>
</ul>
<h2>Como contribuir</h2>
<ol>
	<li>Faça um fork do projeto</li>
	<li>Crie uma branch para a sua feature (<code>git checkout -b feature/nome-da-feature</code>)</li>
	<li>Commit suas mudanças (<code>git commit -m 'Adicionando nova funcionalidade'</code>)</li>
	<li>Faça um push para a branch (<code>git push origin feature/nome-da-feature</code>)</li>
	<li>Abra um Pull Request</li>
</ol>
<h2>Licença</h2>
<p>Distribuído sob a licença MIT. Veja <code>LICENSE</code> para mais informações.</p>
