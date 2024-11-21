<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="modelo.Usuario"%>
<%@ page import="java.util.List"%>

<%
    List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");
    System.out.println("JSP - Número de usuarios: " + (usuarios != null ? usuarios.size() : "null"));
    if(usuarios != null) {
        for(Usuario u : usuarios) {
            System.out.println("JSP - Usuario: " + u.getId() + " - " + u.getNombre());
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios - Horóscopo Chino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
    <style>
        .lista-usuarios-container {
            background: rgba(255, 255, 255, 0.95);
            border: 2px solid var(--temple-gold);
            border-radius: 10px;
            padding: 2rem;
            margin-top: 2rem;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        .lista-header {
            background: linear-gradient(rgba(196, 30, 58, 0.9), rgba(196, 30, 58, 0.7));
            color: var(--stone-color);
            border-bottom: 2px solid var(--temple-gold);
            border-radius: 8px;
            padding: 1.5rem;
            margin-bottom: 2rem;
        }

        .table {
            border: 2px solid var(--temple-gold);
            border-radius: 8px;
            overflow: hidden;
        }

        .table thead {
            background-color: var(--temple-red);
            color: white;
        }

        .table th {
            border-bottom: 2px solid var(--temple-gold);
        }

        .table tbody tr {
            transition: all 0.3s ease;
        }

        .table tbody tr:hover {
            background-color: rgba(196, 30, 58, 0.1);
        }

        .btn-accion {
            border: 1px solid var(--temple-gold);
            transition: all 0.3s ease;
        }

        .btn-editar {
            background-color: var(--temple-gold);
            color: white;
        }

        .btn-editar:hover {
            background-color: #b38f2d;
            transform: translateY(-2px);
        }

        .btn-eliminar {
            background-color: var(--temple-red);
            color: white;
        }

        .btn-eliminar:hover {
            background-color: #a01830;
            transform: translateY(-2px);
        }

        .btn-volver {
            background-color: var(--temple-red);
            border: 2px solid var(--temple-gold);
            color: white;
            transition: all 0.3s ease;
            padding: 0.75rem 2rem;
        }

        .btn-volver:hover {
            background-color: var(--temple-gold);
            color: var(--temple-red);
            transform: translateY(-2px);
        }

        .nav-link {
            color: white;
            transition: all 0.3s ease;
        }

        .nav-link:hover {
            color: var(--temple-gold);
        }

        .logout-btn {
            background-color: transparent;
            border: 2px solid var(--temple-gold);
            color: white;
            transition: all 0.3s ease;
        }

        .logout-btn:hover {
            background-color: var(--temple-gold);
            color: var(--temple-red);
            transform: translateY(-2px);
        }
        .btn-volver {
            display: inline-block;
            background-color: var(--temple-red);
            border: 2px solid var(--temple-gold);
            color: white;
            padding: 0.75rem 2rem;
            transition: all 0.3s ease;
            cursor: pointer;
            text-decoration: none;
            position: relative;
            overflow: hidden;
        }

        .btn-volver:hover {
            background-color: var(--temple-gold);
            color: var(--temple-red);
            transform: translateY(-2px);
            text-decoration: none;
        }

        .btn-volver::after {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: linear-gradient(
                    45deg,
                    transparent,
                    rgba(255,255,255,0.2),
                    transparent
            );
            transform: rotate(45deg);
            transition: transform 0.6s;
        }

        .btn-volver:hover::after {
            transform: rotate(45deg) translate(50%, 50%);
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark" style="background: var(--temple-red);">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">易 Horóscopo Chino 命</a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="${pageContext.request.contextPath}/consulta-horoscopo">Mi Horóscopo</a>
                <form action="${pageContext.request.contextPath}/logout" method="post" class="d-inline">
                    <button type="submit" class="btn logout-btn ms-2">Cerrar Sesión</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="lista-usuarios-container">
        <div class="lista-header text-center">
            <h2 class="mb-0">Lista de Usuarios</h2>
        </div>

        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Usuario</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Signo</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty usuarios}">
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.username}</td>
                            <td>${usuario.fechaNacimiento}</td>
                            <td>${usuario.animal}</td>
                            <td>
                                <div class="btn-group" role="group">
                                    <a href="${pageContext.request.contextPath}/modificar-usuario?id=${usuario.id}"
                                       class="btn btn-accion btn-editar btn-sm me-1">
                                        Editar
                                    </a>
                                    <a href="${pageContext.request.contextPath}/eliminar-usuario?id=${usuario.id}"
                                       class="btn btn-accion btn-eliminar btn-sm"
                                       >
                                        Eliminar
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty usuarios}">
                    <tr>
                        <td colspan="6" class="text-center">No hay usuarios registrados</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>

        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/consulta-horoscopo"
               class="btn btn-volver btn-lg">
                Volver
            </a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>