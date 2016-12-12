<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Pago procesado"/>
            <jsp:param name="specificCss" value="account"/>
        </jsp:include>
    </head>
    <body>
        <div class="owlbooks-account">
            <div class="owlbooks-message-success">
                El pago se ha procesado con éxito por medio de la plataforma PayPal.<br>
                Se avisará al vendedor de que debe hacer llegar su ejemplar a OwlBooks en un plazo máximo de 15 días.<br>
                ¡Gracias por confiar en OwlBooks! ;-)
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>