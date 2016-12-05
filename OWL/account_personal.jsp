<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.List,java.util.Arrays"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Datos de la cuenta"/>
            <jsp:param name="specificCss" value="account_personal"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value='Cuenta > Datos personales'/>
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
            <h1>Datos personales asociados a la cuenta</h1>
            <p>Los campos marcados con un asterisco (<span class="owlbooks-account-personal-form-required-example">*</span>) son obligatorios.
            <form class="owlbooks-account-personal-form" method="post" action=EditarUsuario.do>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="email">Correo electrónico:</label>
                    <input type="email" name="ncorreo" id="email" value="<%=request.getAttribute("correo")%>" required disabled /><span class="owlbooks-secondary-text">(es tu identificador de acceso)</span>
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="passwd">Contraseña:</label>
                    <input type="password" name="nclave" id="passwd" required /><span class="owlbooks-secondary-text">(REQUISITOS DE LA CLAVE...)</span>
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="confirm-passwd">Confirmar contraseña:</label>
                    <input type="password" name="nconfirmarclave" id="confirm-passwd" required />
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="name">Nombre:</label>
                    <input type="text" name="nnombre" id="name" value="<%=request.getAttribute("nombre")%>" required />
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="surname">Apellidos:</label>
                    <input type="text" name="napellidos" id="surname" value="<%=request.getAttribute("apellidos")%>" required />
                </div>
                <div class="owlbooks-account-personal-form-group">
                    <label for="phone">Teléfono:</label>
                    +34<input type="number" name="ntelefono" id="phone" min="100000000" max="999999999" value="<%=request.getAttribute("telefono")%>" />
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="birth">Año de nacimiento:</label>
                    <input type="number" name="nnacimiento" id="birth" min="1920" max="1999" value="<%=request.getAttribute("nacimiento")%>" required />
                </div>
                <fieldset>
                    <legend>Dirección postal <span class="owlbooks-secondary-text">(se revelará solo a tus compradores)</span></legend>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="street">Calle:</label>
                        <input type="text" name="ncalle" id="street" value="<%=request.getAttribute("calle")%>" required />
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label for="number">Número:</label>
                        <input type="text" name="nnumero" id="number"  maxlength="9" size="9" value="<%=request.getAttribute("numero")%>" /><span class="owlbooks-secondary-text">(si no hay número, dejar en blanco)</span>
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label for="floor">Piso/Puerta:</label>
                        <input type="text" name="npiso" id="floor"  maxlength="9" size="9" value="<%=request.getAttribute("piso")%>" />
                    </div>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="city">Población:</label>
                        <input type="text" name="npoblacion" id="city"  maxlength="40" value="<%=request.getAttribute("poblacion")%>" required />
                    </div>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="province">Provincia:</label>
                        <select id="province" name="nprovincia"required><%
                                                    List<String> listaProvincias = Arrays.asList("Álava,Albacete,Alicante,Almería,Asturias,Ávila,Badajoz,Barcelona,Burgos,Cantabria,Castellón,Ceuta,Ciudad Real,Cuenca,Cáceres,Cádiz,Córdoba,Gerona,Granada,Guadalajara,Guipúzcoa,Huelva,Huesca,Islas Baleares,Jaén,La Coruña,La Rioja,Las Palmas,León,Lugo,Lérida,Madrid,Melilla,Murcia,Málaga,Navarra,Orense,Palencia,Pontevedra,Salamanca,Santa Cruz de Tenerife,Segovia,Soria,Tarragona,Teruel,Toledo,Valencia,Valladolid,Vizcaya,Zamora,Zaragoza".split(","));
                            String provinciaPredefinida = (String) request.getAttribute("provincia");
                            for (String provincia : listaProvincias) {
                            if (provinciaPredefinida.equals(provincia)) { %>
                            <option value="<%=provincia%>" selected=""><%=provincia%></option><% 
                            }
                            else { %>
                            <option value="<%=provincia%>"><%=provincia%></option><% 
                            }
                            } %>
                        </select>
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label>País:</label>
                        <div>España</div>
                    </div>
                </fieldset>
                <div class="owlbooks-account-personal-form-group">
                    <input type="submit" value="Guardar" />
                    <input type="reset" value="Deshacer cambios" />
                    <input type="submit" value="Cancelar" />
                </div>
            </form>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
