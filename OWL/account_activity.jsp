<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.List,java.util.Arrays"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Movimientos de la cuenta"/>
            <jsp:param name="specificCss" value="account_activity"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
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
            
            <h2>Puestas en Venta</h2>
            <table class="owlbooks-account-activity" id="owlbooks-account-activity">
                <tr class="owlbooks-account-activity-header" id="owlbooks-account-activity-header">
                    <th>Fecha y hora<br></th>
                    <th>Concepto</th>
                    <th>Producto</th>
                    <th>Importe</th>
                </tr>
                 <%List<String> ActivityVList = (List<String>) request.getAttribute("ventas"); 
                    if (ActivityVList != null) {
                        for(String cat:ActivityVList){
                            String[] at = cat.split(",");%>
                <tr>
                    <td><%=at[0]%><br></td>
                    <td><%=at[3]%><br></td>
                    <td><%=at[1]%></td>
                    <td><%=at[2]%></td>
                </tr>
                <%}
                }%>
            </table>
            
            <h2>Compras</h2>
            <table class="owlbooks-account-activity" id="owlbooks-account-activity">
                <tr class="owlbooks-account-activity-header" id="owlbooks-account-activity-header">
                    <th>Fecha y hora<br></th>
                    <th>Concepto</th>
                    <th>Producto</th>
                    <th>Importe</th>
                </tr>
                 <%List<String> ActivityCList = (List<String>) request.getAttribute("compras"); 
                    if (ActivityCList != null) {
                        for(String cat:ActivityCList){
                            String[] at = cat.split(",");%>
                <tr>
                    <td><%=at[0]%><br></td>
                    <td><%=at[3]%><br></td>
                    <td><%=at[1]%></td>
                    <td><%=at[2]%></td>
                </tr>
                <%}
                }%>
            </table>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
