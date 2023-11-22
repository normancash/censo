package org.example.censo.actions;

import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import com.openxava.naviox.impl.SignInHelper;
import org.example.censo.model.Usuario;
import org.example.censo.service.IDAO;
import org.example.censo.service.ImplDAO;
import org.openxava.util.Is;

import java.util.ArrayList;
import java.util.List;

public class ConexionAction extends ForwardToOriginalURIBaseAction {

    public void execute() throws Exception {
        IDAO dao = new ImplDAO();
        if (getErrors().contains()) return;
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");
        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }

        List<Usuario> lista = dao.get("Usuario.findByUser"
                ,Usuario.class,new Object[]{userName,password});
        if (lista == null || lista.size() == 0) {
            addError("unauthorized_user");
            return;
        }
        SignInHelper.signIn(getRequest(), userName);
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }


    /*public void execute() throws Exception {
        SignInHelper.initRequest(getRequest(), getView());
        if (getErrors().contains()) return;
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");
        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }
        if (!SignInHelper.isAuthorized(getRequest(), userName, password, getErrors())) {
            return;
        }
        SignInHelper.signIn(getRequest(), userName);
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }*/



}