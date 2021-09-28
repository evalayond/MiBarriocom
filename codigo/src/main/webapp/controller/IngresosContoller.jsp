<%@page import="to.TOIngresos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlIngresos"%>
<% controlIngresos controladorIngresos= new controlIngresos();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOIngresos> ingresos = controladorIngresos.listaIngresos();
        out.print(new Gson().toJson(ingresos));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Este Ingreso no esta disponible");
    }
    
%>
