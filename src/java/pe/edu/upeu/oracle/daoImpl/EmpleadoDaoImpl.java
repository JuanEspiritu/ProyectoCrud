package pe.edu.upeu.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.EmpleadoDao;
import pe.edu.upeu.oracle.entity.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public int createEmpleado(Empleado emp) {
        String SQL = "INSERT INTO empleado (nombres, apellidos, correo, telefono, sexo) VALUES (?, ?, ?, ?, ?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, emp.getNombres());
            ps.setString(2, emp.getApellidos());
            ps.setString(3, emp.getCorreo());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getSexo());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return 0;
    }

    @Override
    public int updateEmpleado(Empleado emp) {
        String SQL = "UPDATE empleado SET nombres = ?, apellidos = ?, correo = ?, telefono = ?, sexo = ? WHERE idempleado = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, emp.getNombres());
            ps.setString(2, emp.getApellidos());
            ps.setString(3, emp.getCorreo());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getSexo());
            ps.setInt(6, emp.getIdempleado());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return 0;
    }

    @Override
    public int deleteEmpleado(int id) {
        String SQL = "DELETE FROM empleado WHERE idempleado = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return 0;
    }

    @Override
    public Empleado readEmpleado(int id) {
        Empleado emp = new Empleado();
        String SQL = "SELECT * FROM empleado WHERE idempleado = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setIdempleado(rs.getInt("idempleado"));
                emp.setNombres(rs.getString("nombres"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setCorreo(rs.getString("correo"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setSexo(rs.getString("sexo"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return emp;
    }

    @Override
    public List<Empleado> readAllEmpleado() {
        List<Empleado> lista = new ArrayList<>();
        String SQL = "SELECT * FROM empleado";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdempleado(rs.getInt("idempleado"));
                emp.setNombres(rs.getString("nombres"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setCorreo(rs.getString("correo"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setSexo(rs.getString("sexo"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public boolean buscarEmpleado(String nombre) {
        String SQL = "SELECT * FROM empleado WHERE nombres = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }
}
