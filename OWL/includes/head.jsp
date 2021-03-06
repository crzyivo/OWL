<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><title>OwlBooks<% if (request.getParameter("title") != null) { %> - ${param.title}<% } %></title>
        <link rel="stylesheet" type="text/css" href="css/common.css" />
        <link rel="stylesheet" type="text/css" href="css/${param.specificCss}.css" />
        <link rel="apple-touch-icon" sizes="57x57" href="images/ico/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="images/ico/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="images/ico/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="images/ico/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="images/ico/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="images/ico/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="images/ico/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="images/ico/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="images/ico/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"  href="images/ico/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="images/ico/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="images/ico/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="images/ico/favicon-16x16.png">
        <link rel="manifest" href="images/ico/manifest.json">
        <meta charset="UTF-8" />
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="images/ico/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">
        <meta name="description" content="Vende y compra libros de altos vuelos">
        <meta name="keywords" content="libros,compra,venta,biblioteca,books,marketplace,bookcrossing,bestsellers">
        <meta name="author" content="David Abián, Iván Escuín y Héctor Herrmann">
        <script type="text/javascript">
            function owlDisplayLoginPopup(){
                var NAME = document.getElementById("owlbooks-login-display");
                var CLASS = NAME.className;
                if (CLASS == "owlbooks-login-hidden") NAME.className = "owlbooks-login-displayed";
                else NAME.className = "owlbooks-login-hidden";
            }
        </script>
