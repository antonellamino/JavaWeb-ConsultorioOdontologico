<%-- 
    Document   : verUsuarios
    Created on : Mar 16, 2026, 11:30:52 AM
    Author     : antonella
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "components/header.jsp"%>
<%@include file = "components/bodyprimeraparte.jsp"%>

<!-- Nav Item - Tables -->
<li class="nav-item active">
    <a class="nav-link" href="tables.html">
        <i class="fas fa-fw fa-table"></i>
        <span>Tables</span></a>
</li>

<!-- Divider -->
<hr class="sidebar-divider d-none d-md-block">

<!-- Sidebar Toggler (Sidebar) -->
<div class="text-center d-none d-md-inline">
    <button class="rounded-circle border-0" id="sidebarToggle"></button>
</div>

</ul>
<!-- End of Sidebar -->

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">


        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">Ver usuarios</h1>
            <p class="mb-4">Lista de usuarios</p>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre de usuario</th>
                                    <th>Rol</th>
                                    <th style="width: 210px">Accion</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre de usuario</th>
                                    <th>Rol</th>
                                    <th style="width: 210px">Accion</th>
                                </tr>
                            </tfoot>

                            <%
                                List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");

                            %>
                            <tbody>
                                <% for (Usuario usu : listaUsuarios) {%>
                                <tr>
                                    <td><%=usu.getId_usuario()%></td>
                                    <td><%=usu.getNombreUsuario()%></td>
                                    <td><%=usu.getRol()%></td>

                                    <td style="display:flex; width: 230px">
                                        <form name="eliminar" action="SvElimUsuarios" method="POST">
                                            <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;">
                                                <i class="fas fa-trash-alt"></i> Eliminar
                                            </button>
                                            <input type="hidden" name="id" value="<%=usu.getId_usuario()%>">
                                        </form>
                                        <form name="editar" action="SvEditUsuarios" method="GET">
                                            <button type="submit" class="btn btn-primary btn-user btn-block"; style="magin-left: 5px;">
                                                <i class="fas fa-pencil-alt"></i>Editar
                                            </button>
                                            <input type="hidden" name="id" value="<%=usu.getId_usuario()%>">
                                        </form>
                                    </td>
                                </tr>

                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->

    </div>

    <%@include file = "components/bodyfinal.jsp"%>
