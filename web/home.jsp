<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>

<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("username") == null) {
%>

<jsp:forward page="index.jsp">
    <jsp:param name="error" value="Ud. debe autenticarse...!"/>
</jsp:forward>

<%
} else {
    user = (String) sesion.getAttribute("username");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="assets/images/Captura de pantalla 2024-07-04 031225.png" type="image/x-icon">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/style.css"/>

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&family=Work+Sans:wght@300;400;500;600;700&display=swap');

            body {
                font-family: 'Work Sans', sans-serif;
                background-color: #007bff; /* Mismo color azul para botón */

            }

            .text-indigo {
                color: var(--bs-indigo);
            }

            .bg-indigo {
                background-color: var(--bs-indigo);
            }

            .cursor-pointer {
                cursor: pointer;
            }

            .fw-semibold {
                font-weight: 600;
            }

            .fs-7 {
                font-size: .875rem;
            }
        </style>
        <!---------------------------------------------------------------------------- start: Sidebar -->

    </head>
    <body>
        <div class="sidebar position-fixed top-0 bottom-0 bg-white border-end">
            <div class="d-flex align-items-center p-3">
                <a href="#" class="sidebar-logo text-uppercase fw-bold text-decoration-none text-indigo fs-4">UPEU</a>
                <i class="sidebar-toggle ri-arrow-left-circle-line ms-auto fs-5 d-none d-md-block"></i>
            </div>
            <ul class="sidebar-menu p-3 m-0 mb-0">
                <li class="sidebar-menu-item active">
                    <a href="#">
                        <i class="ri-dashboard-line sidebar-menu-item-icon"></i>
                        CRUD
                    </a>
                </li>
                <li class="sidebar-menu-divider mt-3 mb-1 text-uppercase">Custom</li>
                <li class="sidebar-menu-item has-dropdown">
                    <a href="#">
                        <i class="ri-pages-line sidebar-menu-item-icon"></i>
                        Alumnos
                        <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
                    </a>
                    <ul class="sidebar-dropdown-menu">
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Solicitar carta 
                            </a>
                        </li>
                        <li class="sidebar-dropdown-menu-item has-dropdown">
                            <a href="#">
                                Registrar carta
                                <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
                            </a>
                            <ul class="sidebar-dropdown-menu">       
                            </ul>
                        </li>
                        <li class="sidebar-dropdown-menu-item has-dropdown">
                            <a href="#">
                                Archivos
                                <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
                            </a>

                        </li>

                    </ul>
                </li>


                <li class="sidebar-menu-item has-dropdown">
                    <a href="#">
                        <i class="ri-user-line sidebar-menu-item-icon"></i>
                        PPP
                        <i class="ri-arrow-down-s-line sidebar-menu-item-accordion ms-auto"></i>
                    </a>
                    <ul class="sidebar-dropdown-menu">
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Login
                            </a>
                        </li>
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Registration
                            </a>
                        </li>
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Reset Password
                            </a>
                        </li>
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Change Password
                            </a>
                        </li>
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Confirm Password
                            </a>
                        </li>
                        <li class="sidebar-dropdown-menu-item">
                            <a href="#">
                                Deactivate Account
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="sidebar-overlay"></div>


        <!-- start: MENUHEADER------------------------------------------------------------------------------ -->
        <main class="bg-light">
            <div class="p-2">
                <!-- start: Navbar -->
                <nav class="px-3 py-2 bg-white rounded shadow-sm">
                    <i class="ri-menu-line sidebar-toggle me-3 d-block d-md-none"></i>
                    <h5 class="fw-bold mb-0 me-auto">REGISTRO</h5>
                    <div class="dropdown me-3 d-none d-sm-block">
                        <div class="cursor-pointer dropdown-toggle navbar-link" data-bs-toggle="dropdown"
                             aria-expanded="false">
                            <i class="ri-notification-line"></i>
                        </div>
                        <div class="dropdown-menu fx-dropdown-menu">
                            <h5 class="p-3 bg-indigo text-light">Notification</h5>
                            <div class="list-group list-group-flush">
                                <a href="#"
                                   class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                                    <div class="me-auto">
                                        <div class="fw-semibold">nueva solicitud de ppp</div>
                                        <span class="fs-7">Alumno:Elia</span>
                                    </div>
                                    <span class="badge bg-primary rounded-pill">1</span>
                                </a>
                                <a href="#"
                                   class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
                                    <div class="me-auto">
                                        <div class="fw-semibold">Convenio Aceptado</div>
                                        <span class="fs-7">Empresa Paycha</span>
                                    </div>
                                    <span class="badge bg-primary rounded-pill">1</span>
                                </a>
                            </div>
                        </div>
                    </div>


                    <div class="dropdown">
                        <div class="d-flex align-items-center cursor-pointer dropdown-toggle" data-bs-toggle="dropdown"
                             aria-expanded="false">

                            <span class="me-2 d-none d-sm-block fw-bold">
                                <%=user%>                              
                            </span>
                            <c:if test="${sexo.trim() == 'Masculino'}">
                                <img class="navbar-profile-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/800px-User_icon_2.svg.png" alt="Image">
                            </c:if>
                            <c:if test="${sexo.trim() == 'Femenino'}">
                                <img class="navbar-profile-image" src="assets/images/user_dama.png" alt="Image">
                            </c:if>
                        </div>
                        <!-------------------------- end: gestion role ---------------------------->

                        <!-------------------------- end: roles ---------------------------->

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item fw-bold" href="#">${rol}</a></li>
                            <li><a class="dropdown-item" href="logout">Logout</a></li>
                        </ul>
                    </div>
                </nav>
                            
                           
                            
                            
                            
                <!----------------------------------------------- end: Sidebar --------------------------------------------------->

                <!--  -----------------------------CRUD ESTUDIANTE  --------aqui ----------------------------------- -->

                <!-- Modal Agregar Estudiante -->
                <div class="modal fade" id="agregarEstudianteModal" tabindex="-1" aria-labelledby="agregarEstudianteModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="agregarEstudianteModalLabel">Agregar Estudiante</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form id="agregarEstudianteForm">
                                    
                                    <div class="mb-3">
                                        <label for="nombre" class="form-label">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="apellido" class="form-label">Apellido</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="correo" class="form-label">Correo</label>
                                        <input type="text" class="form-control" id="correo" name="correo" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="telefono" class="form-label">Telefono</label>
                                        <input type="text" class="form-control" id="telefono" name="telefono" required>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                <button type="button" class="btn btn-primary" onclick="agregarEstudiante()">Agregar</button>
                            </div>
                        </div>
                    </div>
                </div>



                <!--  -----------------------------CRUD ESTUDIANTE  --------aqui hacer crud----------------------------------- -->
                <!-- Modal Editar Estudiante -->
                <div class="modal fade" id="editarEstudianteModal" tabindex="-1" aria-labelledby="editarEstudianteModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="editarEstudianteModalLabel">Editar Estudiante</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form id="editarEstudianteForm">
                                    <input type="hidden" id="edit_idestudiante" name="idestudiante">
                                    <div class="mb-3">
                                        <label for="edit_nombre" class="form-label">Nombre</label>
                                        <input type="text" class="form-control" id="edit_nombre" name="nombre" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="edit_apellido" class="form-label">Apellido</label>
                                        <input type="text" class="form-control" id="edit_apellido" name="apellido" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="edit_correo" class="form-label">Correo</label>
                                        <input type="text" class="form-control" id="edit_correo" name="correo" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="edit_telefono" class="form-label">Telefono</label>
                                        <input type="text" class="form-control" id="edit_telefono" name="telefono" required>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                <button type="button" class="btn btn-primary" onclick="actualizarEstudiante()">Actualizar</button>
                            </div>
                        </div>
                    </div>
                </div>





                <!--  -----------------------------CRUD ESTUDIANTE  --------aqui hacer crud----------------------------------- -->

                <div class="container mt-4">
                    <button class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#agregarEstudianteModal">Agregar Estudiante</button>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                            </tr>
                        </thead>
                        <tbody id="estudiantes-list">
                        </tbody>
                    </table>
                </div>

                <!--  -----------------------------CRUD ESTUDIANTE  --------aqui hacer crud----------------------------------- -->


</main> 


                <!-- start: JS -->
                <script src="assets/js/jquery.min.js"></script>
                <script src="assets/js/bootstrap.bundle.min.js"></script>
                <!------------redireccion----------------->
                <script src="assets/js/script.js"></script>
                <script src="assets/js/estudiante.js"></script> 
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
                <script src="assets/js/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js" integrity="sha512-sW/w8s4RWTdFFSduOTGtk4isV1+190E/GghVffMA9XczdJ2MDzSzLEubKAs5h0wzgSJOQTRYyaz73L3d6RtJSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
                <script src="assets/js/bootstrap.bundle.min.js"></script>
                <!------------redireccion-----------------> 
                <script src="assets/js/script.js"></script>
                <script src="assets/js/estudiante.js"></script>

                </body>
                </html>
                <%}%>