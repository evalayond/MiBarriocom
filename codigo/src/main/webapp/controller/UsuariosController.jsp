<%@page import="to.TOLogin"%>
<%@page import="to.TOVendedores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlLogin"%>
<% controlLogin controladorLogin = new controlLogin();
    String usuario = request.getParameter("usuario");
    String clave = request.getParameter("clave");
    TOVendedores vendedor = controladorLogin.login(usuario, clave);
    out.print(new Gson().toJson(vendedor));
%>

