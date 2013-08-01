package edu.infnet.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

public class FacesUtil {

	private static final Logger log = Logger.getLogger(FacesUtil.class);

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	public static RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}

	public static void addInfoMessage(String message) {
		log.debug(message);
		getFacesContext().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Sucesso", message));
	}

	public static void addWarningMessage(String message) {
		log.debug(message);
		getFacesContext().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_WARN, "Atenção", message));
	}

	public static void addErrorMessage(String message) {
		log.debug(message);
		getFacesContext().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Erro", message));
	}

	public static void addFatalMessage(String message) {
		log.debug(message);
		getFacesContext().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_FATAL, "Erro crítico", message));
	}

	public static String getParameter(String key) {
		String value = getExternalContext().getRequestParameterMap().get(key);
		log.debug(String.format("key=%s, value=%s", key, value));
		return value;
	}

	public static void requestExecute(String script) {
		log.debug(script);
		getRequestContext().execute(script);
	}

	public static void requestUpdate(String name) {
		log.debug(name);
		getRequestContext().update(name);
	}

	private FacesUtil() {}

}
