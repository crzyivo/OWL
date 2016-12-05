<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Cuenta"/>
            <jsp:param name="specificCss" value="account"/>
        </jsp:include>
    </head>
    <body>
        <div class="owlbooks-account">
            <p>Cuenta borrada con exito</p>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
