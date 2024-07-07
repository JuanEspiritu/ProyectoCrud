package pe.edu.upeu.oracle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class Estudiante {
    private int idestudiante;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
}
    