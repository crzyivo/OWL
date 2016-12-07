<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.Calendar"
%><!DOCTYPE html>
<% session.setAttribute("current","put_on_sale.jsp"); %>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Poner a la venta un ejemplar"/>
            <jsp:param name="specificCss" value="put_on_sale"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value='Libros > El Quijote > Poner a la venta'/>
        </jsp:include>
        <div class="owlbooks-account">
            <h1>Poner a la venta un ejemplar de El Quijote</h1>
            <p>Los campos marcados con un asterisco (<span class="owlbooks-account-personal-form-required-example">*</span>) son obligatorios.
            <form class="owlbooks-account-personal-form" method="post" action="">
                <div class="owlbooks-account-personal-form">
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="editor">Editorial:</label>
                        <input type="text" name="neditorial" id="editor" required />
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label for="publicationyear">Año de publicación:</label>
                        <input type="number" name="nanyopub" id="publicationyear" min="-2000" max="<%=Calendar.getInstance().get(Calendar.YEAR)%>" value="<%=Calendar.getInstance().get(Calendar.YEAR)%>" />
                    </div>
                    <div class="owlbooks-account-personal-form-group">
                        <label for="isbn">ISBN:</label>
                        <input type="text" name="nisbn" id="isbn" />
                    </div>
                    <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-required">
                        <label for="price">Precio:</label>
                        <input type="number" name="nprecio" id="price" min="0" max="99" maxlength="2" size="2" value="4" required />,
                        <select id="pricecents" name="npreciocentimos" required>
                            <option value="00" selected="">00</option>
                            <option value="05">05</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="25">25</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="35">35</option>
                            <option value="39">39</option>
                            <option value="40">40</option>
                            <option value="45">45</option>
                            <option value="49">49</option>
                            <option value="50">50</option>
                            <option value="55">55</option>
                            <option value="59">59</option>
                            <option value="60">60</option>
                            <option value="65">65</option>
                            <option value="69">69</option>
                            <option value="70">70</option>
                            <option value="75">75</option>
                            <option value="79">79</option>
                            <option value="80">80</option>
                            <option value="85">85</option>
                            <option value="89">89</option>
                            <option value="90">90</option>
                            <option value="95">95</option>
                            <option value="99">99</option>
                        </select>&nbsp;€
                    </div>
                </div>
                <div class="owlbooks-account-personal-form-group-checkboxes">
                    <input type="checkbox" class="owlbooks-account-personal-form-required" id="owlbooks-readpolicies-checkbox" required ><p>He leído y acepto el <a href="aviso_legal.jsp" target="_blank">aviso legal</a> y la <a href="privacy_policy.jsp" target="_blank">política de privacidad</a>.</p><br>
                    <input type="checkbox" class="owlbooks-account-personal-form-required" id="owlbooks-authenticity" required ><p>Declaro, bajo pena de perjurio, que poseo el ejemplar en cuestión y que los datos arriba especificados son ciertos.</p>
                </div>
                <div class="owlbooks-account-personal-form-group owlbooks-account-personal-form-group-actions">
                    <input type="submit" value="Guardar" />
                    <input type="reset" value="Limpiar" />
                    <input type="submit" value="Cancelar" />
                </div>
            </form>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
