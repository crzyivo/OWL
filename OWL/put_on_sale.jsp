<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<% session.setAttribute("current","sell.jsp"); %>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Poner a la venta un ejemplar"/>
            <jsp:param name="specificCss" value="account_personal"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value='Libros > El Quijote > Poner a la venta'/>
        </jsp:include>
        <div class="owlbooks-account">
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
