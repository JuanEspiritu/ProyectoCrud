package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.Estudiante;
// definen los metodos 


public interface EstudianteDao {
    public int createEstudiante(Estudiante est);
    public int updateEstudiante(Estudiante est);
    public int deleteEstudiante(String id);
    public Estudiante readEstudiante(String id);
    public List<Estudiante> readAllEstudiante();
}

/*La interfaz EstudianteDao define los métodos básicos para realizar 
operaciones CRUD (Create, Read, Update, Delete) en una entidad Estudiante. 
Las implementaciones de esta interfaz deben proporcionar el código específico 
para interactuar con la base de datos y realizar estas operaciones.
*/