package pe.edu.upeu.oracle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Empleado {
    private int idempleado;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String sexo;
}
