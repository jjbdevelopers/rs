/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.modelo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sinergiao
 */
public class UtilMSG {

    public static void addErrorMsg(final String mensaje) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addWarningMsg(final String mensaje) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", mensaje);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMsg(final String mensaje) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", mensaje);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}
