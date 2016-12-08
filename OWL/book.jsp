<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.util.List,java.util.Arrays"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="El Quijote, de Miguel de Cervantes Saavedra"/>
            <jsp:param name="specificCss" value="book"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value="Libros > ${titulo}"/>
        </jsp:include>
        <div class="owlbooks-container">
            <div class="owlbooks-navbar-left">
                <h1 class="owlbooks-h-mostread">Lo más leído</h1>
                <div class="owlbooks-section owlbooks-mostread">
                    <ol>
                        <li><i>El Quijote</i>, de Miguel de Cervantes Saavedra.</li>
                        <li><i>El Quijote (versión extendida)</i>, de Miguel de Cervantes Saavedra.</li>
                        <li><i>Otra vez tú, don Quijote</i>, de Miguel de Cervantes Saavedra.</li>
                    </ol>
                </div>
                <h1 class="owlbooks-h-categories">Categorías</h1>
                <div class="owlbooks-section owlbooks-categories">
                    <ul>
                        <li>Ciencia ficción (535 libros)</li>
                        <li>Policíaca (23 libros)</li>
                    </ul>
                </div>
            </div>
            <div class="owlbooks-body">
                <div class="owlbooks-section owlbooks-product">
                    <h1><em><%=request.getAttribute("titulo")%></em><span class="owlbooks-secondary-text">, de <%=request.getAttribute("autor")%></span></h1>
                    <div class="owlbooks-product-actions">
                        <a href="#buy"><div class="owlbooks-product-action owlbooks-product-buy">Comprar este libro</div></a>
                        <a href=""><div class="owlbooks-product-action owlbooks-product-sell">Vender este libro</div></a>
                    </div>
                    <div class="owlbooks-product-description">
                        <div class="owlbooks-product-cover">
                            <div style="width:140px; height:200px; border:1px solid #000; background: #fff"></div>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam accumsan dolor a mauris dapibus, gravida viverra sem elementum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce sagittis mattis ante id venenatis. Vestibulum placerat venenatis ipsum et pretium. Integer vel arcu lobortis, maximus mi ac, sagittis lectus. Integer et nulla sagittis, sodales nisl vel, aliquam augue. Proin metus dui, fermentum id venenatis quis, elementum sit amet ante. Vivamus ornare dui in condimentum sodales. Donec blandit viverra auctor. Ut sollicitudin quam sed laoreet ultricies. Nam est mi, dictum ac magna eget, lobortis scelerisque velit. Maecenas et tortor a augue euismod sodales.</p>
                        <p>Pellentesque condimentum nulla eu ligula auctor rhoncus. Fusce sed quam non odio convallis mollis. Duis eu ex eu lectus accumsan laoreet ut ac mauris. Donec congue felis non quam pharetra, a rhoncus magna bibendum. Etiam accumsan tempus nisl, nec lacinia justo volutpat et. Donec vel nibh vitae metus pharetra fermentum. Sed pulvinar, mauris quis ultrices bibendum, leo quam tempus erat, eget venenatis elit leo quis tellus. Nunc vitae nisl dapibus, semper lectus in, imperdiet dolor. Ut eleifend tempus leo eleifend mattis. Proin rhoncus molestie fringilla. Vivamus sit amet ante imperdiet, iaculis sem maximus, placerat urna. Quisque maximus mauris dignissim ultrices gravida.</p>
                    </div>
                    <div>
                        <h2 id="buy">Ejemplares disponibles</h2>
                        <!--
                            Ejemplares del libro ordenados de menor a mayor precio.
                        -->
                        <div class="owlbooks-section owlbooks-categories"><% 
                        List<String> ejemplaresList = (List<String>) request.getAttribute("libros"); 
                        if (!(ejemplaresList.isEmpty())) {
                            for (String libro : ejemplaresList) {
                            String[] at = libro.split(","); %>
                            <div class="owlbooks-product-copy">
                                <ul class="owlbooks-product-copy-info">
                                    <li>Precio: <strong><%=at[2]%>€</strong></li>
                                    <li>Editorial: <strong><%=at[0]%></strong></li>
                                    <li>Año de publicación: <%=at[1]%></li>
                                    <li>ISBN: <%=at[3]%></li>
                                    <li>Vendedor: <%=at[4]%></li>
                                    <li>Origen: <%=at[5]%></li>
                                    <li>Estado: <span class="owlbooks-product-copy-info-<%=at[2].toLowerCase()%>"><%=at[6]%></span></li>
                                </ul>
                                <a href=""><div class="owlbooks-product-action owlbooks-product-buy owlbooks-product-copy-buy">Comprar este ejemplar</div></a>
                            </div>
                            <%}
                            }%>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
