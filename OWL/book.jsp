<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.util.List,java.util.Arrays"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<% session.setAttribute("current","LibroEjemplar.do"); %>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="${titulo}, de ${autor}"/>
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
                    <%List<String> MostReadList = (List<String>) request.getAttribute("masLeidos"); 
                    if (MostReadList != null) {
                        for(String lib:MostReadList){
                            String[] at = lib.split(",");%>
                                <li><a href="LibroEjemplar.do?id=<%=at[3]%>"><i><%=at[0]%></i></a>, de <%=at[1]%>.</li>
                        <%}
                    }%>
                    </ol>
                </div>
                <h1 class="owlbooks-h-categories">Categorías</h1>
                <div class="owlbooks-section owlbooks-categories">
                    <ul>
                    <%List<String> CategoryList = (List<String>) request.getAttribute("categorias"); 
                    if (CategoryList != null) {
                        for(String cat:CategoryList){
                            String[] at = cat.split(",");%>
                        <li><a href="Categoria.do?categoria=<%=at[0]%>"><em><%=at[0]%></em></a>, <%=at[1]%> libros</li>
                        <%}
                    }%>
                    </ul>
                </div>
            </div>
            <div class="owlbooks-body">
                <div class="owlbooks-section owlbooks-product">
                    <h1><em><%=request.getAttribute("titulo")%></em><span class="owlbooks-secondary-text">, de <%=request.getAttribute("autor")%></span></h1>
                    <% if(request.getAttribute("errorlogin")!=null){%>
                        <div class="owlbooks-band-errors">
                            Debes iniciar sesion para poder vender un libro
                        </div>
                    <%}%> 
                     <% if(request.getAttribute("errorloginC")!=null){%>
                        <div class="owlbooks-band-errors">
                            Debes iniciar sesion para poder comprar un libro
                        </div>
                    <%}%>
                    <div class="owlbooks-product-actions">
                        <a href="#buy"><div class="owlbooks-product-action owlbooks-product-buy">Comprar este libro</div></a>
                        <a href="Vender.do?id=<%=request.getAttribute("id")%>"><div class="owlbooks-product-action owlbooks-product-sell">Vender este libro</div></a>
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
                                    <li>Estado: <span class="owlbooks-product-copy-info-<%=at[6].toLowerCase()%>"><%=at[6]%></span></li>
                                </ul>
                                <a href="ComprarEjemplar.do?ejemplar=<%=at[7]%>"><div class="owlbooks-product-action owlbooks-product-buy owlbooks-product-copy-buy">Comprar este ejemplar</div></a>
                            </div>
                            <%}
                            }else{%>
                            <div class="owlbooks-band-none">
                                Ahora mismo no tenemos ejemplares de este libro a la venta.<br>
                                ¡Sé el primero en vender uno!
                            </div><% 
                            }%>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
