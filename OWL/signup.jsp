<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<% session.setAttribute("current","singup.jsp"); %>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Registrarse"/>
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
            <h1>Datos para el registro</h1>
            <p>Los campos marcados con un asterisco (<span class="owlbooks-account-personal-form-required-example">*</span>) son obligatorios.
            <form class="owlbooks-account-personal-form" method="post" action=InsertarUsuraio.do>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="email">Correo electrónico:</label>
                    <input type="email" name="correo" id="email" required /><span class="owlbooks-secondary-text">(es tu identificador de acceso)</span>
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                    <label for="passwd">Contraseña:</label>
                    <input type="password" name="clave" id="passwd" required /><span class="owlbooks-secondary-text">(REQUISITOS DE LA CLAVE...)</span>
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
                        <select id="province" name="provincia"required>
                            <option value="Álava">Álava</option>
                            <option value="Albacete">Albacete</option>
                            <option value="Alicante">Alicante</option>
                            <option value="Almería">Almería</option>
                            <option value="Andalucía">Andalucía</option>
                            <option value="Asturias">Asturias</option>
                            <option value="Ávila">Ávila</option>
                            <option value="Badajoz">Badajoz</option>
                            <option value="Barcelona">Barcelona</option>
                            <option value="Burgos">Burgos</option>
                            <option value="Cantabria">Cantabria</option>
                            <option value="Castellón">Castellón</option>
                            <option value="Ceuta">Ceuta</option>
                            <option value="Ciudad Real">Ciudad Real</option>
                            <option value="Cuenca">Cuenca</option>
                            <option value="Cáceres">Cáceres</option>
                            <option value="Cádiz">Cádiz</option>
                            <option value="Córdoba">Córdoba</option>
                            <option value="Gerona">Gerona</option>
                            <option value="Granada">Granada</option>
                            <option value="Guadalajara">Guadalajara</option>
                            <option value="Guipúzcoa">Guipúzcoa</option>
                            <option value="Huelva">Huelva</option>
                            <option value="Huesca">Huesca</option>
                            <option value="Islas Baleares">Islas Baleares</option>
                            <option value="Jaén">Jaén</option>
                            <option value="La Coruña">La Coruña</option>
                            <option value="La Rioja">La Rioja</option>
                            <option value="Las Palmas">Las Palmas</option>
                            <option value="León">León</option>
                            <option value="Lugo">Lugo</option>
                            <option value="Lérida">Lérida</option>
                            <option value="Madrid">Madrid</option>
                            <option value="Melilla">Melilla</option>
                            <option value="Murcia">Murcia</option>
                            <option value="Málaga">Málaga</option>
                            <option value="Navarra">Navarra</option>
                            <option value="Orense">Orense</option>
                            <option value="Palencia">Palencia</option>
                            <option value="Pontevedra">Pontevedra</option>
                            <option value="Salamanca">Salamanca</option>
                            <option value="Santa Cruz de Tenerife">Santa Cruz de Tenerife</option>
                            <option value="Segovia">Segovia</option>
                            <option value="Soria">Soria</option>
                            <option value="Tarragona">Tarragona</option>
                            <option value="Teruel">Teruel</option>
                            <option value="Toledo">Toledo</option>
                            <option value="Valencia">Valencia</option>
                            <option value="Valladolid">Valladolid</option>
                            <option value="Vizcaya">Vizcaya</option>
                            <option value="Zamora">Zamora</option>
                            <option value="Zaragoza" selected="">Zaragoza</option>
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
