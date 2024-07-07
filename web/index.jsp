<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PPP</title>
        <link rel="shortcut icon" href="assets/images/Captura de pantalla 2024-07-04 031225.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/style.css"/>
        <style>
            body {
                                background-color: #007bff; /* Mismo color azul para botón */

                font-family: 'Work Sans', sans-serif;
                background-image: url('https://elucubracion.com/wp-content/uploads/2014/05/fondo-abstracto-1.png'); /* Asegúrate de cambiar esta URL por la URL de tu imagen de fondo deseada */
                background-size: cover;
                background-position: center;
            }
            .bg-indigo {
                background-color: var(--bs-indigo);
            }
            .text-indigo {
                color: var(--bs-indigo);
            }
        </style>
    </head>
    
    <body class="d-flex justify-content-center align-items-center vh-100">
        <div class="bg-white p-5 rounded-5 text-secondary shadow" style="width: 25rem;">
            <div class="d-flex justify-content-center">
                <img src="assets/images/images (2).png" alt="login-icon" style="height: 7rem"/>
            </div>
            <div class="text-center fs-1 fw-bold"></div>
              <% if (session.getAttribute("bloqueado") != null && (boolean) session.getAttribute("bloqueado")) { %>
            <div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
                <strong>Cuenta bloqueada!</strong> Has alcanzado el máximo de intentos.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <% } else { %>
            <form action="lc" method="post">
                <div class="input-group mt-4">
                    <div class="input-group-text bg-indigo">
                        <img src="assets/images/username-icon.svg" alt="username-icon" style="height: 1rem"/>
                    </div>
                    <input class="form-control bg-light" type="text" name="username" placeholder="Username"/>
                </div>
                <div class="input-group mt-1">
                    <div class="input-group-text bg-indigo">
                        <img src="assets/images/password-icon.svg" alt="password-icon" style="height: 1rem"/>
                    </div>
                    <input class="form-control bg-light" type="password" name="clave" placeholder="Password"/>
                </div>
                <div class="d-flex justify-content-around mt-1">
                    <div class="d-flex align-items-center gap-1">
                        <input class="form-check-input" type="checkbox"/>
                        <div class="pt-1 text-indigo" style="font-size: 0.9rem">Remember me</div>
                    </div>
                    <div class="pt-1">
                        <a href="#" class="text-decoration-none text-indigo fw-semibold fst-italic" style="font-size: 0.9rem">Forgot your password?</a>
                    </div>
                </div>
                <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn bg-indigo text-white">Ingresar</button>
                </div>
            </form>
            <div class="d-flex gap-1 justify-content-center mt-1">
                <div>Don't have an account?</div>
                <a href="#" class="text-decoration-none text-indigo fw-semibold">Register</a>
            </div>
            <div class="p-3">
                <div class="border-bottom text-center" style="height: 0.9rem">
                    <span class="bg-white px-3">or</span>
                </div>
            </div>   
            <% } %>
              <% if (session.getAttribute("bloqueado") != null && (boolean) session.getAttribute("bloqueado")) { %>
            <div class="d-flex justify-content-center mt-3">
    <a href="lc?action=reset" class="btn btn-link text-decoration-none text-white">
        Restablecer intentos
    </a>
</div>
        <% } %>
        </div>
    </body>
</html>
