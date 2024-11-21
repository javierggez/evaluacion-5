<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horóscopo Chino - Templo de la Fortuna</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Tu CSS personalizado -->
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
</head>
<body>
<div class="temple-container container">
    <div class="temple-header text-center">
        <h1 class="temple-title display-4">易 Templo del Horóscopo Chino 命</h1>
        <p class="text-light">Descubre tu destino en el antiguo zodíaco chino</p>
    </div>

    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="temple-card">
                <div class="temple-decoration"></div>
                <form id="horoscopeForm" class="mb-4">
                    <div class="mb-3">
                        <label class="form-label">Fecha de Nacimiento</label>
                        <input type="date" class="form-control" id="birthdate" required>
                    </div>
                    <button type="submit" class="btn btn-temple">Consultar Destino</button>
                </form>
            </div>
        </div>
    </div>

    <div class="row" id="zodiacContainer">
        <!-- Los signos del zodíaco se cargarán dinámicamente -->
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Tu JavaScript personalizado -->
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>