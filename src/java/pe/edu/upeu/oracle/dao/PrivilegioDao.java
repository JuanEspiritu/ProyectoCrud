
package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.Privilegio;

/**
 *
 * @author Docente
 */
public interface PrivilegioDao {
    public int createPrivilegio(Privilegio pri);
    public int updatePrivilegio(Privilegio pri);
    public int deletePrivilegio(int id);
    public Privilegio readPrivilegio(int id);
    public List<Privilegio> readAllPrivilegio();
    public boolean buscarPrivilegio(String nombre);
}
