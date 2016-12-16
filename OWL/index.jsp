<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.List,java.util.Arrays"
%><!DOCTYPE html>
<% session.setAttribute("current","Index.do"); %>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="specificCss" value="index"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"></jsp:include>
        <div class="owlbooks-searchbar">
            <form>
                <input type="text" class="owlbooks-searchbar-text" id="owlbooks-searchbar-text">
                <input type="submit" class="owlbooks-searchbar-button" id="owlbooks-searchbar-button" value="Search">
            </form>
        </div>
        <h1 class="owlbooks-h-mostread">Lo más leído</h1>
        <div class="owlbooks-section owlbooks-mostread">
            <ol>
            <%List<String> MostReadList = (List<String>) request.getAttribute("masLeidos"); 
            if (MostReadList != null) {
                for(String lib:MostReadList){
                    String[] at = lib.split(",");%>
                <li><span class="owlbooks-mostread-title"><a href="LibroEjemplar.do?id=<%=at[3]%>"><em><%=at[0]%></em></a></span>, de <%=at[1]%>.</li>
                <%}
                }%>
            </ol>
        </div>
        <h1 class="owlbooks-h-categories">Categorías</h1>
        <div class="owlbooks-section owlbooks-categories">
        <%List<String> CategoryList = (List<String>) request.getAttribute("categorias"); 
            if (CategoryList != null) {
                for(String cat:CategoryList){
                    String[] at = cat.split(",");%>
            <a href="Categoria.do?categoria=<%=at[0]%>"><div class="owlbooks-category">
                <h2 class="owlbooks-h-category"><%=at[0]%></h2>
                <p><%=at[1]%> libros</p>
            </div></a>
            <%}
          }%>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
