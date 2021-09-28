<%@page import="to.TOVendedores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlVendedores"%>
<% controlVendedores controladorVendedores= new controlVendedores();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOVendedores> vendedores = controladorVendedores.listaVendedores();
        out.print(new Gson().toJson(vendedores));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Este vendedor no esta disponible");
    }
    
%>
