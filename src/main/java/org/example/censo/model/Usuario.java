package org.example.censo.model;

import lombok.Getter;
import lombok.Setter;
import org.example.censo.validators.UsuarioValidars;
import org.openxava.annotations.PropertyValidator;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name="Usuario.findByUser",query="select e " +
                "from Usuario e where  e.usuario = ?1 and e.password = ?2"),
        @NamedQuery(name="Usuario.findByUsuario",query="select e from Usuario e where e.usuario like ?1")
})
public class Usuario extends Identificable{

    @PropertyValidator(value= UsuarioValidars.class)
    private String usuario;

    private String password;
}
