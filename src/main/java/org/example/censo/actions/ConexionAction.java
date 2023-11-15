package org.example.censo.actions;

import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import org.openxava.util.Is;

public class ConexionAction extends ForwardToOriginalURIBaseAction {

    public void execute() throws Exception {
        if (getErrors().contains()) return;
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");
        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }
        /*if (!SignInHelper.isAuthorized(getRequest(), userName, password, getErrors())) {
            return;
        }
        SignInHelper.signIn(getRequest(), userName);*/
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }

}