/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.modelo;

import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author juliano
 */
public class UtilPF {

    public static void execute(String evento) {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(evento);
    }
    
     public static void addErrorMsg(final String titulo, final String detalle) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, detalle);
        context.showMessageInDialog(message);
    }

    public static void addSuccessMsg(final String titulo, final String detalle) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, detalle);
        context.showMessageInDialog(message);
    }

    public static void addSupportMsg() {
        UtilPF.addErrorMsg("Error no controlado, intente nuevamente", "Si el problema persiste contactenos para asistirle.");
    }

}
