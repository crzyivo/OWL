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
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value='Cuenta'/>
        </jsp:include>
        <div class="owlbooks-account">
            <a href="VerUsuario.do"><div class="owlbooks-section owlbooks-account-data">
                <img src="images/data.png" alt="" />
                <p>Datos personales</p>
            </div></a>
            <a href="Mov.do"><div class="owlbooks-section owlbooks-account-activity">
                <img src="images/money.png" alt="" />
                <p>Movimientos</p>
            </div></a>
            <a href="BorrarUsuario.do"><div class="owlbooks-section owlbooks-account-deleteaccount">
                <img src="images/delete.png" alt="" />
                <p>Eliminar cuenta</p>
            </div></a>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
