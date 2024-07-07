
package pe.edu.upeu.oracle.daoImpl;

import java.util.List;
import pe.edu.upeu.oracle.dao.RolDao;
import pe.edu.upeu.oracle.entity.Rol;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.upeu.oracle.config.Conexion;
/**
 *
 * @author Docente
 */
public class RolDaoImpl implements RolDao {
private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public int createRol(Rol rol) {
        String SQL= "INSERT INTO rol (nombre,estado) VALUES(?,1)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getRol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int updateRol(Rol rol) {
        String SQL= "UPDATE rol SET nombre=?, estado=? WHERE idrol=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getRol());
            ps.setInt(2, rol.getEstado());
            ps.setInt(3, rol.getIdrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public int deleteRol(int id) {
        String SQL= "DELETE FROM WHERE idrol=?";
        String SQL1= "UPDATE rol SET estado=0 WHERE idrol=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL1);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
    }

    @Override
    public Rol readRol(int id) {
        Rol rol =new Rol(); 
        String SQL= "SELECT *FROM rol WHERE idrol=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                rol.setIdrol(rs.getInt("idrol"));
                rol.setRol(rs.getString("rol"));
                rol.setEstado(rs.getInt("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return rol;
    }

    @Override
    public List<Rol> readAllRol() {
        List<Rol> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM rol";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol rol =new Rol(); 
                rol.setIdrol(rs.getInt("idrol"));
                rol.setRol(rs.getString("rol"));
                rol.setEstado(rs.getInt("estado"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return lista;
    }
    
}
