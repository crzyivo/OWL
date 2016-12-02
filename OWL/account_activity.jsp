<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="head.jsp" >
            <jsp:param name="title" value="Movimientos de la cuenta"/>
            <jsp:param name="specificCss" value="account_personal"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="header.jsp" >
            <jsp:param name="owlbooksLocation" value='Cuenta > Movimientos'/>
        </jsp:include>
        
        <%--
            String modo = (String) session.getAttribute("modo");
            String accion;
            if(modo.equals(new String("NUEVO"))){
                accion="InsertarUsuraio.do";
            }else if(modo.equals(new String("EDICION"))){
                accion="EditarUsuario.do";
            }
        --%>
        <div class="owlbooks-account">
            <h1>Movimientos de la cuenta</h1>
            <table class="owlbooks-account-activity" id="owlbooks-account-activity">
                <tr class="owlbooks-account-activity-header" id="owlbooks-account-activity-header">
                    <th>Fecha y hora<br></th>
                    <th>Concepto</th>
                    <th>Producto</th>
                    <th>Importe</th>
                </tr>
                <tr>
                    <td>2011-07-21 14:35<br></td>
                    <td>Registro en OwlBooks<br></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>2011-08-15 11:40<br></td>
                    <td>Puesta a la venta<br></td>
                    <td>5541854 - El Quijote, de Miguel de Cervantes Saavedra<br></td>
                    <td></td>
                </tr>
                <tr>
                    <td>2011-08-16 19:01<br></td>
                    <td>Venta</td>
                    <td>5541854 - El Quijote, de ...<br></td>
                    <td>11,50 €</td>
                </tr>
            </table>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
