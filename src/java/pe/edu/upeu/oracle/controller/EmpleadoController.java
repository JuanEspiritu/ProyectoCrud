package pe.edu.upeu.oracle.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import pe.edu.upeu.oracle.dao.EmpleadoDao;
import pe.edu.upeu.oracle.daoImpl.EmpleadoDaoImpl;
import pe.edu.upeu.oracle.entity.Empleado;

@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {
    private EmpleadoDao empDao = new EmpleadoDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listarEmpleados(request, response);
                break;
            case "create":
                crearEmpleado(request, response);
                break;
            case "edit":
                editarEmpleado(request, response);
                break;
            case "update":
                actualizarEmpleado(request, response);
                break;
            case "delete":
                eliminarEmpleado(request, response);
                break;
            default:
                listarEmpleados(request, response);
        }
    }

    protected void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleados = empDao.readAllEmpleado();
        String json = new Gson().toJson(empleados);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void crearEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado emp = new Empleado();
        emp.setNombres(request.getParameter("nombres"));
        emp.setApellidos(request.getParameter("apellidos"));
        emp.setCorreo(request.getParameter("correo"));
        emp.setTelefono(request.getParameter("telefono"));
        emp.setSexo(request.getParameter("sexo"));
        empDao.createEmpleado(emp);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    protected void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado emp = empDao.readEmpleado(id);
        String json = new Gson().toJson(emp);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado emp = new Empleado();
        emp.setIdempleado(Integer.parseInt(request.getParameter("idempleado")));
        emp.setNombres(request.getParameter("nombres"));
        emp.setApellidos(request.getParameter("apellidos"));
        emp.setCorreo(request.getParameter("correo"));
        emp.setTelefono(request.getParameter("telefono"));
        emp.setSexo(request.getParameter("sexo"));
        empDao.updateEmpleado(emp);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        empDao.deleteEmpleado(id);
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
