<%@page import="to.TOLogin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlLogin"%>
<% controlLogin controladorLogin= new controlLogin();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOLogin> login = controladorLogin.listaLogin();
        out.print(new Gson().toJson(login));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Este Login no esta disponible");
    }
    
%>
