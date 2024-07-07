
package pe.edu.upeu.oracle.test;

import com.google.gson.Gson;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.RolDao;
import pe.edu.upeu.oracle.dao.UsuarioDao;
import pe.edu.upeu.oracle.daoImpl.RolDaoImpl;
import pe.edu.upeu.oracle.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.oracle.entity.Rol;


public class Test {
static RolDao rdao = new RolDaoImpl();
static UsuarioDao udao = new UsuarioDaoImpl();
static Gson g = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("no conectado");
        }
        System.out.println(g.toJson(udao.login("dreyna", "1234567")));
    }
    
}
