package pe.edu.upeu.oracle.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import pe.edu.upeu.oracle.dao.EstudianteDao;
import pe.edu.upeu.oracle.daoImpl.EstudianteDaoImpl;
import pe.edu.upeu.oracle.entity.Estudiante;


//para la conexion del backend con el frontend
                @WebServlet("/EstudianteController")
public class EstudianteController extends HttpServlet {
    private EstudianteDao estDao = new EstudianteDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listarEstudiantes(request, response);
                break;
            case "create":
                crearEstudiante(request, response);
                break;
            case "edit":
                editarEstudiante(request, response);
                break;
            case "update":
                actualizarEstudiante(request, response);
                break;
            case "delete":
                eliminarEstudiante(request, response);
                break;
            default:
                listarEstudiantes(request, response);
        }
    }

protected void listarEstudiantes(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    List<Estudiante> estudiantes = estDao.readAllEstudiante();
    String json = new Gson().toJson(estudiantes);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}


protected void crearEstudiante(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Estudiante est = new Estudiante();
    est.setNombre(request.getParameter("nombre"));
    est.setApellido(request.getParameter("apellido"));
    est.setCorreo(request.getParameter("correo"));
    est.setTelefono(Integer.parseInt(request.getParameter("telefono")));
    estDao.createEstudiante(est);
    response.setStatus(HttpServletResponse.SC_CREATED);
}

    protected void editarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Estudiante est = estDao.readEstudiante(id);
        String json = new Gson().toJson(est);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
protected void actualizarEstudiante(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Estudiante est = new Estudiante();
    est.setIdestudiante(Integer.parseInt(request.getParameter("idestudiante"))); 
    est.setNombre(request.getParameter("nombre"));
    est.setApellido(request.getParameter("apellido"));
     est.setCorreo(request.getParameter("correo"));
    est.setTelefono(Integer.parseInt(request.getParameter("telefono")));
    estDao.updateEstudiante(est);
    response.setStatus(HttpServletResponse.SC_OK);
}

    protected void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        estDao.deleteEstudiante(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
