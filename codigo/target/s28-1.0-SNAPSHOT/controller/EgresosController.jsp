<%@page import="to.TOEgresos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlEgresos"%>
<% controlEgresos controladorEgresos= new controlEgresos();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOEgresos> egresos = controladorEgresos.listaEgresos();
        out.print(new Gson().toJson(egresos));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Este Egreso no esta disponible");
    }
    
%>
