<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.List,java.util.Arrays"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Resultado"/>
            <jsp:param name="specificCss" value="category"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value="Resultado de ${termino}"/>
        </jsp:include>

        <h1 class="owlbooks-h-categories">Resultado de la busqueda «<%=request.getAttribute("termino")%>»</h1>
        <div class="owlbooks-section owlbooks-categories"><% 
        List<String> librosList = (List<String>) request.getAttribute("libros"); 
        if (librosList != null) {
            for (String libro : librosList) {
            String[] at = libro.split(","); %>
            <a href="LibroEjemplar.do?id=<%=at[3]%>"><div class="owlbooks-book">
                <div style="width:100px; height:140px; border:1px solid #000; background: #fff; float:left; margin-right:.9em;"></div>
                <h2 class="owlbooks-h-book"><%=at[0] %></h2>
                <p>de <%=at[1]%>.</p>
                <p><%=at[2]%> ejemplares en venta.</p>
            </div></a><% 
            }
        }else{%>
            <div class="owlbooks-band-none">
                Su busqueda no ha producido ningun resultado.
            </div><%
        }%>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
