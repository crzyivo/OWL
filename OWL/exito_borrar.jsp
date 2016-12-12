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
        <meta http-equiv="refresh" content="3; URL='Index.do'" />
    </head>
    <body>
        <div class="owlbooks-account">
            <div class="owlbooks-message-success">
                Cuenta borrada con éxito.
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
