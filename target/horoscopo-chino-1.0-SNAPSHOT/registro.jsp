<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro - Horóscopo Chino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
    <style>
        .registro-card {
            background: rgba(255, 255, 255, 0.95);
            border: 2px solid var(--temple-gold);
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        .registro-header {
            background: linear-gradient(rgba(196, 30, 58, 0.9), rgba(196, 30, 58, 0.7));
            color: var(--stone-color);
            border-bottom: 2px solid var(--temple-gold);
            border-radius: 8px 8px 0 0;
            padding: 1.5rem;
        }

        .btn-registro {
            background-color: var(--temple-red);
            border: 2px solid var(--temple-gold);
            color: white;
            transition: all 0.3s ease;
        }

        .btn-registro:hover {
            background-color: var(--temple-gold);
            color: var(--temple-red);
            transform: translateY(-2px);
        }

        .btn-volver {
            background-color: transparent;
            border: 2px solid var(--temple-gold);
            color: var(--temple-red);
            transition: all 0.3s ease;
        }

        .btn-volver:hover {
            background-color: var(--temple-gold);
            color: white;
            transform: translateY(-2px);
        }

        .form-control {
            border: 2px solid var(--temple-gold);
            transition: all 0.3s ease;
            padding: 0.75rem;
        }

        .form-control:focus {
            border-color: var(--temple-red);
            box-shadow: 0 0 0 0.2rem rgba(196, 30, 58, 0.25);
        }

        .form-label {
            color: var(--temple-red);
            font-weight: 500;
        }
    </style>
</head>
<body>
<div class="temple-container container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="registro-card">
                <div class="registro-header">
                    <h3 class="text-center mb-0">
                        易 Registro de Usuario 命
                    </h3>
                </div>
                <div class="card-body p-4">
                    <form action="registro" method="post">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre:</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>
                        <div class="mb-3">
                            <label for="username" class="form-label">Usuario:</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Correo Electrónico:</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña:</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="mb-4">
                            <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento:</label>
                            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
                        </div>
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-registro btn-lg">Registrarse</button>
                            <a href="login.jsp" class="btn btn-volver btn-lg">Volver al Login</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>