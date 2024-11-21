<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Usuario - Horóscopo Chino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
    <style>
        .eliminar-container {
            background: rgba(255, 255, 255, 0.95);
            border: 2px solid var(--temple-gold);
            border-radius: 10px;
            padding: 2rem;
            margin-top: 2rem;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        .eliminar-header {
            background: linear-gradient(rgba(196, 30, 58, 0.9), rgba(196, 30, 58, 0.7));
            color: var(--stone-color);
            border-radius: 8px 8px 0 0;
            padding: 1.5rem;
            margin: -2rem -2rem 2rem -2rem;
            border-bottom: 2px solid var(--temple-gold);
        }

        .user-info {
            background: rgba(196, 30, 58, 0.1);
            border: 1px solid var(--temple-gold);
            border-radius: 8px;
            padding: 1.5rem;
            margin-bottom: 2rem;
        }

        .warning-icon {
            font-size: 3rem;
            color: var(--temple-red);
            margin-bottom: 1rem;
        }

        .btn-eliminar {
            background-color: var(--temple-red);
            border: 2px solid var(--temple-gold);
            color: white;
            transition: all 0.3s ease;
        }

        .btn-eliminar:hover {
            background-color: #a01830;
            transform: translateY(-2px);
        }

        .btn-cancelar {
            background-color: transparent;
            border: 2px solid var(--temple-gold);
            color: var(--temple-red);
            transition: all 0.3s ease;
        }

        .btn-cancelar:hover {
            background-color: var(--temple-gold);
            color: white;
            transform: translateY(-2px);
        }

        .confirmation-text {
            font-size: 1.1rem;
            color: var(--temple-red);
            margin-bottom: 2rem;
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
                <a class="nav-link" href="${pageContext.request.contextPath}/listar-usuarios">Lista de Usuarios</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/consulta-horoscopo.jsp">Mi Horóscopo</a>


                    <form action="${pageContext.request.contextPath}/logout" method="post" class="d-inline">
                    <button type="submit" class="btn logout-btn ms-2">Cerrar Sesión</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="eliminar-container">
                <div class="eliminar-header text-center">
                    <h2 class="mb-0">Confirmar Eliminación</h2>
                </div>

                <div class="text-center">
                    <div class="warning-icon">⚠️</div>
                    <p class="confirmation-text">
                        ¿Está seguro que desea eliminar el siguiente usuario?
                    </p>
                </div>

                <div class="user-info">
                    <h4 class="text-center mb-3">Información del Usuario</h4>
                    <div class="row">
                        <div class="col-sm-6">
                            <p><strong>Nombre:</strong> ${usuario.nombre}</p>
                            <p><strong>Usuario:</strong> ${usuario.username}</p>
                        </div>
                        <div class="col-sm-6">
                            <p><strong>Fecha de Nacimiento:</strong> ${usuario.fechaNacimiento}</p>
                            <p><strong>Signo:</strong> ${usuario.signo}</p>
                        </div>
                    </div>
                </div>

                <form action="eliminar-usuario" method="post" class="text-center">
                    <input type="hidden" name="id" value="${usuario.id}">
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-eliminar btn-lg">
                            Confirmar Eliminación
                        </button>
                        <a href="listar-usuarios.jsp" class="btn btn-cancelar btn-lg">
                            Cancelar
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>