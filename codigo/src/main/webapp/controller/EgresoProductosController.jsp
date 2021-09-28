<%@page import="to.TOEgresoProductos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlEgresoProductos"%>
<% controlEgresoProductos controladorEgresoProductos= new controlEgresoProductos();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOEgresoProductos> egresoProductos = controladorEgresoProductos.listaEgresoProductos();
        out.print(new Gson().toJson(egresoProductos));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Este EgresoProducto no esta disponible");
    }
    
%>

