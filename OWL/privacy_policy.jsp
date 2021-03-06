<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="includes/head.jsp" >
            <jsp:param name="title" value="Política de privacidad"/>
            <jsp:param name="specificCss" value="privacy_policy"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" >
            <jsp:param name="owlbooksLocation" value='Política de privacidad'/>
        </jsp:include>
        <div class="owlbooks-privacy-policy">
            <h1>Política de privacidad<!-- fuente: <https://www.avellanadigital.com/es/los-3-textos-legales-que-debe-tener-tu-pagina-web> --></h1>
            <p>En cumplimiento de lo establecido en la Ley Orgánica 15/1999, de 13 de diciembre, de Protección de Datos de Carácter Personal, le informamos de que, mediante la cumplimentación del presente formulario, sus datos personales quedarán incorporados y serán tratados en un fichero automatizado denominado USUARIOS OWLBOOKS, titularidad de OWLBOOKS, S. L., con la finalidad de poder gestionar su solicitud, así como para mantenerle informado de futuras promociones, noticias y novedades relacionadas con el sector.</p>
            <p>OWLBOOKS, S. L. se compromete a tratar de forma confidencial los datos de carácter personal facilitados y a no comunicar o ceder dicha información a terceros.</p>
            <p>Usted podrá de forma libre y voluntaria facilitar la información que se le pide en los formularios salvo en los campos que aparecen como obligatorios. La no introducción de la información solicitada como obligatoria podrá tener como consecuencia que no pueda atenderse su solicitud.</p>
            <p>A su vez, y en virtud de lo establecido en la Ley 34/2002, de 11 de julio, de Servicios de la Sociedad de la Información y de Comercio electrónico, OWLBOOKS, S. L. informa de que podrá utilizar las direcciones de correo electrónico facilitadas, para remitirle información acerca de sus productos y servicios, avisos y ofertas y, en general, información de carácter comercial de interés relativa a la actividad de la empresa.</p>
            <p>Asimismo, le informamos de la posibilidad que tiene de ejercer los derechos de acceso, rectificación, cancelación y oposición de sus datos de carácter personal de forma presencial en las oficinas de OWLBOOKS, S. L., acompañando copia de DNI, o bien mediante correo electrónico dirigido a 696773@unizar.es.</p>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
