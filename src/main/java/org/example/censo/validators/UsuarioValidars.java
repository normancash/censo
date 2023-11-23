package org.example.censo.validators;

import org.example.censo.model.Usuario;
import org.example.censo.service.IDAO;
import org.example.censo.service.ImplDAO;
import org.openxava.util.Messages;
import org.openxava.validators.IPropertyValidator;

import java.util.List;

public class UsuarioValidars implements IPropertyValidator {
    @Override
    public void validate(Messages messages, Object o, String s, String s1) throws Exception {
        IDAO dao = new ImplDAO();
        List<Usuario> lista = dao.get("Usuario.findByUsuario", Usuario.class,String.valueOf(o));
        if (lista != null && lista.size() > 0) {
            messages.add("El nombre del usuario ya existe");
        }
    }
}
