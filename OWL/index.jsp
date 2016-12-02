<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<% session.setAttribute("current","index.jsp"); %>
<html lang="es">
	<head>
        <jsp:include page="head.jsp" >
            <jsp:param name="title" value="Owl Books"/>
            <jsp:param name="specificCss" value="index"/>
        </jsp:include>
	</head>
	<body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="owlbooks-section">
			<p>Nota: Se muestra una vista de la página principal con la sesión sin iniciar. Para consultar los detalles de una cuenta, pulsar <a href="account.jsp">aquí</a>.</p>
		</div>
		<h1 class="owlbooks-h-mostread">Lo más leído</h1>
		<div class="owlbooks-section owlbooks-mostread">
			<ol>
				<li><span class="owlbooks-mostread-title"><a href="book.jsp"><em>El Quijote</em></a></span>, de Miguel de Cervantes Saavedra.</li>
				<li><span class="owlbooks-mostread-title"><em>El Quijote (versión extendida)</em></span>, de Miguel de Cervantes Saavedra.</li>
				<li><span class="owlbooks-mostread-title"><em>Otra vez tú, don Quijote</em></span>, de Miguel de Cervantes Saavedra.</li>
			</ol>
		</div>
		<h1 class="owlbooks-h-categories">Categorías</h1>
		<div class="owlbooks-section owlbooks-categories">
			<a href="category.jsp"><div class="owlbooks-category">
				<h2 class="owlbooks-h-category">Ciencia ficción</h2>
				<p>535 libros</p>
			</div></a>
			<a href=""><div class="owlbooks-category">
				<h2 class="owlbooks-h-category">Policíaca</h2>
				<p>23 libros</p>
			</div></a>
			<a href=""><div class="owlbooks-category">
				<h2 class="owlbooks-h-category">Misterio</h2>
				<p>623 libros</p>
			</div></a>
			<a href=""><div class="owlbooks-category">
				<h2 class="owlbooks-h-category">Histórica</h2>
				<p>32 libros</p>
			</div></a>
			<div class="owlbooks-category">
			</div>
			<div class="owlbooks-category">
			</div>
			<div class="owlbooks-category">
			</div>
			<div class="owlbooks-category">
			</div>
			<div class="owlbooks-category">
			</div>
		</div>
        <%@include file="footer.jsp" %>
	</body>
</html>
