
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%><%
{
boolean login = false;
if (session.getAttribute("user") == null) { %>
    <div class="owlbooks-header owlbooks-unlogged"><% 
}
else {
login = true; %>
    <div class="owlbooks-header owlbooks-loggedin"><% 
}
boolean error = false;
if (session.getAttribute("errorMessage") != null) {
error = true;
} %>
            <div class="owlbooks-logo">
                <a href="Index.do"><img src="images/logo.png" alt="Owl Books" /></a>
            </div>
            <div class="owlbooks-location"><%
            if (request.getParameter("owlbooksLocation") != null) { %>
                Estás&nbsp;en: <strong><a href="Index.do">Portada</a> > ${param.owlbooksLocation}</strong>
            <% } %></div>
            <div class="owlbooks-top-actions"><%
                if (error) { %>
                <div class="owlbooks-login-display" id="owlbooks-login-display"><%
                }
                else { %>
                <div class="owlbooks-login-hidden" id="owlbooks-login-display"><%
                } %>
                    <div class="owlbooks-login owlbooks-clickable" onclick="owlDisplayLoginPopup();"><% 
                        if (!login) { %>
                        iniciar&nbsp;sesión&nbsp;<span class="owlbooks-only-if-hidden">»</span><% 
                        }
                        else { %>
                        <img src="images/menu.png" /><% 
                        } %>
                    </div>
                    <div class="owlbooks-login-popup-separator"></div>
                    <div class="owlbooks-login-popup"><% 
                        if (!login) { %>
                        <form class="owlbooks-account-personal-form" method="post" action=login.do><% 
                            if (error) { %>
                            <p class="owlbooks-login-error">Email o contraseña erroneos</p><% 
                            } %>
                            <label for="owlbooks-email" class="owlbooks-hidden">Correo electrónico:</label>
                            <input type="email" name="owlbooks-correo" id="owlbooks-email" required placeholder="correo@electronico.com" /><br>
                            <label for="owlbooks-passwd" class="owlbooks-hidden">Contraseña:</label>
                            <input type="password" name="owlbooks-clave" id="owlbooks-passwd" required placeholder="contraseña" /><br>
                            <p class="owlbooks-secondary-text">¿Aún no eres miembro? <a class="owlbooks-link-signup" id="owlbooks-link-signup" href="signup.jsp">Regístrate</a> en OwlBooks.</p>
                            <input type="submit" value="Acceder »" id="owlbooks-submit-login" />
                        </form><% 
                        }
                        else { %>
                        <p class="owlbooks-login-welcome">¡Hola, <%=session.getAttribute("username")%>!</p>
                        <ul class="owlbooks-login-actions">
                            <a id="owlbooks-login-action-myaccount" href="account.jsp"><li>Mi cuenta »</li></a>
                            <a id="owlbooks-login-actions-logout" href="logout.do"><li>Cerrar sesión »</li></a>
                        </ul><% 
                        } %>
                    </div>
                </div>
            </div>
        </div><% 
} %>