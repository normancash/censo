package org.example.censo.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Coordinates;
import org.openxava.annotations.Stereotype;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Persona extends Identificable {

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    public enum SEXO{MASCULINO,FEMENINO};
    private SEXO sexo;
    @Coordinates
    @Column(length = 50)
    @Stereotype("COORDENADAS")
    private String coordenadas;

}
