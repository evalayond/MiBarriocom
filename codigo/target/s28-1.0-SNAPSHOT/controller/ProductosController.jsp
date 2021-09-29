<%@page import="to.TOProductos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="controller.controlProductos"%>
<% controlProductos controladorProductos = new controlProductos();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOProductos> productos = controladorProductos.listaProductos();
        out.print(new Gson().toJson(productos));
    }else if("insertar".equals(opcion)){
    
    }else if("actualizar".equals(opcion)){
    
    
    }else if("eliminar".equals(opcion)){
    }else{
        out.println("Este producto no esta disponible");
    }
    
%>
