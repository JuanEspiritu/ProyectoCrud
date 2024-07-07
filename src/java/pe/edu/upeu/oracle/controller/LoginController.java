/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.upeu.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upeu.oracle.dao.UsuarioDao;
import pe.edu.upeu.oracle.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.oracle.dto.UsuariLogin;

/**
 *
 * @author Docente
 */
public class LoginController extends HttpServlet {
    
    private UsuarioDao udao = new UsuarioDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String clave = request.getParameter("clave");
        HttpSession sesion = request.getSession();
        
        Integer intentos = (Integer) sesion.getAttribute("intentos");
        if (intentos == null) {
            intentos = 0;
        }

        List<UsuariLogin> lista = udao.login(username, clave);
        
        if (!udao.login(username, clave).isEmpty()) {
            sesion.setAttribute("username", lista.get(0).getUsername());
            sesion.setAttribute("sexo", lista.get(0).getSexo());
            sesion.setAttribute("rol", lista.get(0).getRol());
            sesion.removeAttribute("intentos");
            sesion.removeAttribute("bloqueado");

     
            String rol = lista.get(0).getRol();
            if ("admin".equalsIgnoreCase(rol)) {
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("home.jsp");
            }
        } else {
            intentos++;
            sesion.setAttribute("intentos", intentos);

            if (intentos >= 3) {
                sesion.setAttribute("bloqueado", true);
            }

            response.sendRedirect("index.jsp");
        }
       
    }   
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("reset".equals(action)) {
        HttpSession session = request.getSession();
        session.removeAttribute("intentos");
        session.removeAttribute("bloqueado");
        
        response.sendRedirect("index.jsp");
    } else {
        processRequest(request, response);
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Login Controller";
    }
}
     

       