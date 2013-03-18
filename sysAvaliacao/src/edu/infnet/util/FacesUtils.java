package edu.infnet.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {


	public static void mensInfo(String message) {
		mensagem(message, FacesMessage.SEVERITY_INFO);
	}


	public static void mensErro(String message) {
		mensagem(message, FacesMessage.SEVERITY_ERROR);
	}

	public static void mensagem(String message,
			FacesMessage.Severity severity) {

		FacesContext.getCurrentInstance().
		addMessage(null, new FacesMessage(severity, message, null));
	}

	public static String get(String param) {

		return FacesContext.getCurrentInstance().
				getExternalContext().
				getRequestParameterMap().get(param);
	}

}
