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
            <form class="owlbooks-account-personal-form" method="post" action=InsertarUsuario.do>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="email">Correo electrónico:</label>
                    <input type="email" name="correo" id="email" required /><span class="owlbooks-secondary-text">(es tu identificador de acceso)</span>
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="name">Nombre:</label>
                    <input type="text" name="nombre" id="name" required />
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="surname">Apellidos:</label>
                    <input type="text" name="apellidos" id="surname" required />
                </div>
                <div class="owlbooks-account-personal-form-group">
                    <label for="phone">Teléfono:</label>
                    +34<input type="number" name="telefono" id="phone" min="100000000" max="999999999" />
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="birth">Año de nacimiento:</label>
                    <input type="number" name="nacimiento" id="birth" min="1920" max="1999" required />
                </div>
                <fieldset>
                    <legend>Dirección postal <span class="owlbooks-secondary-text">(se revelará solo a tus compradores)</span></legend>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="street">Calle:</label>
                        <input type="text" name="calle" id="street"  required />
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label for="number">Número:</label>
                        <input type="text" name="numero" id="number"  maxlength="9" size="9" /><span class="owlbooks-secondary-text">(si no hay número, dejar en blanco)</span>
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label for="floor">Piso/Puerta:</label>
                        <input type="text" name="piso" id="floor"  maxlength="9" size="9" />
                    </div>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="city">Población:</label>
                        <input type="text" name="poblacion" id="city"  maxlength="40" required />
                    </div>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="province">Provincia:</label>
                        <select id="province" name="provincia"required><% 
                            List<String> listaProvincias = Arrays.asList("Álava,Albacete,Alicante,Almería,Asturias,Ávila,Badajoz,Barcelona,Burgos,Cantabria,Castellón,Ceuta,Ciudad Real,Cuenca,Cáceres,Cádiz,Córdoba,Gerona,Granada,Guadalajara,Guipúzcoa,Huelva,Huesca,Islas Baleares,Jaén,La Coruña,La Rioja,Las Palmas,León,Lugo,Lérida,Madrid,Melilla,Murcia,Málaga,Navarra,Orense,Palencia,Pontevedra,Salamanca,Santa Cruz de Tenerife,Segovia,Soria,Tarragona,Teruel,Toledo,Valencia,Valladolid,Vizcaya,Zamora,Zaragoza".split(","));
                            String provinciaPredefinida = new String("Zaragoza");//request.getAttribute("provincia");
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
