<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.List,java.util.Arrays"
%><!DOCTYPE html>
<% session.setAttribute("current","index.jsp"); %>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="specificCss" value="index"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"></jsp:include>
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
        <%List<String> CategoryList = (List<String>) request.getAttribute("categorias"); 
            if (CategoryList != null) {
                for(String cat:CategoryList){
                    String[] at = cat.split(",");{%>
            <a href="Categoria.do?categoria=<%=at[0]%>"><div class="owlbooks-category">
                <h2 class="owlbooks-h-category"><%=at[0]%></h2>
                <p><%=at[1]%> libros</p>
            </div></a>
            <%}
            }
          }%>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
