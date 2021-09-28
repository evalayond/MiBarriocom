<%@page import="to.TOUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlUsuarios"%>
<% controlUsuarios controladorUsuarios = new controlUsuarios();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOUsuarios> usuarios = controladorUsuarios.listaUsuarios();
        out.print(new Gson().toJson(usuarios));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    
    
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Esta opción no esta disponible");
    }
    
%>

