package org.example.censo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name="Usuario.findByUser",query="select e " +
                "from Usuario e where  e.usuario = ?1 and e.password = ?2")
})
public class Usuario extends Identificable{

    private String usuario;

    private String password;
}
