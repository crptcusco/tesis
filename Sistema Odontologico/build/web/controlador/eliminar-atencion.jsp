<%@page import="modelo.AtencionProblema"%>
<%@page import="modelo.AtencionAccion"%>
<%@page import="modelo.DataBaseHelper"%>
<%@page import="modelo.Atencion"%>
<%
    String codigo = request.getParameter("codigo");
    
    
    //eliminando las acciones relacioandas a esa atenci�nten
    AtencionAccion.eliminar(codigo);
    // Eliminando los problemas relacionados a esa atenci�n
    AtencionProblema.eliminar(codigo);
    
    
//eliminando la atencion
    Atencion atencion = Atencion.buscarPorCodigo(codigo);
    atencion.eliminar();
    response.sendRedirect("../secretaria/atencion.jsp?campana="+request.getParameter("campana"));
%>
