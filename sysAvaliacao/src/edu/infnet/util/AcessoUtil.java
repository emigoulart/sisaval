package edu.infnet.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.infnet.model.Usuario;

public class AcessoUtil {

    public static String logIn(String defaultViewId, Usuario usuario) {

        String viewId = defaultViewId;
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            session.setAttribute(ControleAcesso.JSF_SECURITY_KEY, "147369");
            session.setAttribute(ControleAcesso.LOGGED_USER, usuario.getLogin());
            session.setAttribute(ControleAcesso.ROLE, usuario.getTipoUsuario());
            String s = (String)session.getAttribute(ControleAcesso.VIEWID_KEY);
            if (s != null) {
                viewId = s;
            }
        }
        return viewId;
    }

    public static boolean isLoggedIn() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            String s = (String)session.getAttribute(ControleAcesso.JSF_SECURITY_KEY);
            if (s != null && s.equals("147369")) {
                return true;
            }
        }
        return false;
    }

    public static String userLogged() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            String s = (String)session.getAttribute(ControleAcesso.LOGGED_USER);
            return s;
        }
        return null;
    }

    public static void logOut() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            session.removeAttribute(ControleAcesso.JSF_SECURITY_KEY);
            session.removeAttribute(ControleAcesso.LOGGED_USER);
            session.removeAttribute(ControleAcesso.ROLE);
            //ctx.getViewRoot().setViewId("/index.xhtml");
        }
    }
}
