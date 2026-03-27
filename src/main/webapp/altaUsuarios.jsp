<%-- 
    Document   : altaUsuarios
    Created on : Mar 16, 2026, 9:50:46 AM
    Author     : antonella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "components/header.jsp"%>
<%@include file = "components/bodyprimeraparte.jsp"%>

<h1>Alta usuarios</h1>

<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol">
        </div>

        <button  class="btn btn-primary btn-user btn-block" type="submit">
            Crear usuario
        </button>
        <hr>

        </form>

        <%@include file = "components/bodyfinal.jsp"%>