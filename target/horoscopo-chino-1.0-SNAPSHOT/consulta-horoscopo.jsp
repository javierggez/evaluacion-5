<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta Horóscopo Chino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">

    <style>
        .horoscopo-container {
            background: rgba(255, 255, 255, 0.9);
            border: 2px solid var(--temple-gold);
            border-radius: 10px;
            padding: 2rem;
            margin-top: 2rem;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        .horoscopo-header {
            background: linear-gradient(rgba(196, 30, 58, 0.9), rgba(196, 30, 58, 0.7));
            padding: 1rem;
            border-radius: 8px;
            margin-bottom: 2rem;
            border: 2px solid var(--temple-gold);
        }

        .signo-card {
            background: white;
            border: 2px solid var(--temple-gold);
            border-radius: 8px;
            padding: 1.5rem;
            margin-bottom: 1.5rem;
            transition: transform 0.3s ease;
        }

        .signo-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }

        .nav-link {
            color: var(--temple-red);
            font-weight: 500;
            transition: all 0.3s ease;
        }

        .nav-link:hover {
            color: var(--temple-gold);
        }

        .signo-icon {
            font-size: 2.5rem;
            color: var(--temple-red);
            margin-bottom: 1rem;
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

                    <form action="${pageContext.request.contextPath}/logout" method="post" class="d-inline">
                    <button type="submit" class="btn logout-btn ms-2">Cerrar Sesión</button>
                </form>
            </div>
        </div>
    </nav>

    <!-- Contenido principal -->
    <div class="horoscopo-container">
        <div class="horoscopo-header text-center text-white">
            <h2>Tu Horóscopo Chino</h2>
            <p class="mb-0">Bienvenido, ${usuario.nombre}</p>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="signo-card text-center">
                    <div class="signo-icon">${iconoSigno}</div>
                    <h3>Tu fecha de nacimiento: ${usuario.fechaNacimiento}</h3>
                    <h4 class="mb-4">Tu signo es: ${nombreSigno}</h4>
                </div>


                    </div>
                </div>



                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>