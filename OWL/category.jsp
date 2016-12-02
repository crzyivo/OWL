<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Owl Books"/>
            <jsp:param name="specificCss" value="category"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value='Categorías > Ciencia ficción'/>
        </jsp:include>
        <div class="owlbooks-section">
			<p>Nota: Se muestra una vista de la página principal con la sesión sin iniciar. Para consultar los detalles de una cuenta, pulsar <a href="account.jsp">aquí</a>.</p>
		</div>
		<h1 class="owlbooks-h-categories">Libros en la categoría «Ciencia&nbsp;ficción»</h1>
		<div class="owlbooks-section owlbooks-categories">
			<a href="book.jsp"><div class="owlbooks-book">
                <div style="width:100px; height:140px; border:1px solid #000; background: #fff; float:left; margin-right:.9em;"></div>
				<h2 class="owlbooks-h-book">El Quijote</h2>
				<p>de Miguel de Cervantes Saavedra.</p>
                <p>0 ejemplares en venta.</p>
			</div></a>
            <a href=""><div class="owlbooks-book">
                <div style="width:100px; height:140px; border:1px solid #000; background: #fff; float:left; margin-right:.9em;"></div>
                <h2 class="owlbooks-h-book">El principito</h2>
                <p>de Antoine de Saint-Exupéry.</p>
                <p>0 ejemplares en venta.</p>
            </div></a>
            <a href=""><div class="owlbooks-book">
                <div style="width:100px; height:140px; border:1px solid #000; background: #fff; float:left; margin-right:.9em;"></div>
                <h2 class="owlbooks-h-book">El principito</h2>
                <p>Lorem ipsum sit dolorem amet.</p>
                <p>0 ejemplares en venta.</p>
            </div></a>
            <a href=""><div class="owlbooks-book">
                <div style="width:100px; height:140px; border:1px solid #000; background: #fff; float:left; margin-right:.9em;"></div>
                <h2 class="owlbooks-h-book">El principito</h2>
                <p>Lorem ipsum sit dolorem amet.</p>
                <p>0 ejemplares en venta.</p>
            </div></a>
			<div class="owlbooks-book">
			</div>
			<div class="owlbooks-book">
			</div>
			<div class="owlbooks-book">
			</div>
			<div class="owlbooks-book">
			</div>
			<div class="owlbooks-book">
			</div>
		</div>
        <%@include file="includes/footer.jsp" %>
	</body>
</html>
