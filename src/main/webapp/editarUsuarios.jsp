<%-- 
    Document   : altaUsuarios
    Created on : Mar 16, 2026, 9:50:46 AM
    Author     : antonella
--%>

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "components/header.jsp"%>
<%@include file = "components/bodyprimeraparte.jsp"%>

<h1>Edición de usuarios</h1>

<% Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");%>


<form class="user" action="SvEditUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre usuario" value="<%=usu.getNombreUsuario()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña" value="<%=usu.getContrasenia()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol" value="<%=usu.getRol()%>">
        </div>

        <button  class="btn btn-primary btn-user btn-block" type="submit">
            Guardar cambios
        </button>
        <hr>

        </form>

        <%@include file = "components/bodyfinal.jsp"%>
