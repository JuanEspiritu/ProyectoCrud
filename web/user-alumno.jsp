<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
    HttpSession sesion = request.getSession();
    String user = (String) sesion.getAttribute("username");
    if (user == null || !"elias".equals(user)) {
        response.sendRedirect("index.jsp?error=Ud. debe autenticarse como Elias para acceder a esta página.");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Otra Página</title>
    <link rel="shortcut icon" href="assets/images/pagina.png" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body>
    <div class="container mt-5">
        <h1>Bienvenido, <%= user %></h1>
        <p>"elias".</p>
    </div>
</body>
</html>
