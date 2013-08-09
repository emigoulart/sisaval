package edu.infnet.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class ControleAcesso implements PhaseListener {
	/* Baseado em http://www.deslatech.com.br/?q=node/7 */
	private static final long serialVersionUID = -781294566130715727L;
	
    public static final String JSF_SECURITY_KEY = "__jsfsecurity__";
    public static final String VIEWID_KEY = "__viewId";
    public static final String LOGGED_USER = "__login__";
    public static final String ROLE = "__roles";
	 
	private static String[] protectedPaths = null;

	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void beforePhase(PhaseEvent event) {
		FacesContext ctx = event.getFacesContext();
        String viewId = ctx.getViewRoot().getViewId();
        
        for (String s : getProtectedPaths(ctx)) {
    			
        	String[] p = s.split("=");
        	if (viewId.indexOf(p[0]) > -1) {

        		HttpSession httpSession = (HttpSession)ctx.getExternalContext().getSession(true);
        		if (httpSession == null || httpSession.getAttribute(JSF_SECURITY_KEY) == null) {

        			//if ( httpSession != null)
        			httpSession.setAttribute(VIEWID_KEY, viewId);
        			
        			ctx.getApplication().getNavigationHandler().handleNavigation(ctx, null, ("/paginas/login/paginaLogin.xhtml" ));
        			ctx.addMessage(null, new FacesMessage("A página solicitada requer que o usuário esteja autenticado."));
        			 
        		} else {

        			String roles = (String)httpSession.getAttribute(ROLE);
        			 if (roles != null && roles.indexOf(p[1]) == -1) {
             			 // nao carrega a pagina solicitada...
        				 ctx.getApplication().getNavigationHandler().handleNavigation(ctx, null, "/paginas/login/default.xhtml");
        				 ctx.addMessage(null, new FacesMessage("Página solicitada não está autorizada."));
        			 }
        			 
        		}
        		break;
        		
        	}
        	
        }
        
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
    private String[] getProtectedPaths(FacesContext ctx) {

        if (protectedPaths == null) {
            //logger.config("loading jsfsecurity.protected ...");
            String s = ctx.getExternalContext().getInitParameter("jsfsecurity.protected");
            if (s != null) {
                protectedPaths = s.split(",");
            }
        }
        return protectedPaths;
    }
	

}
