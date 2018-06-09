/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import utilidades.modelo.UtilLog;
import utilidades.modelo.UtilPF;

/**
 *
 * @author Sinergia
 */
@ManagedBean(name = "uiSesion")
public class UISesion {

    public void apagarServidor() {
        this.ejecutarComando("init 0");
        String mensaje = "Se envío la petición de apagado";
        Date fechaActual = new Date();
        if (fechaActual.getHours() < 12) {
            mensaje += ", Feliz día. ";
        }
        if (fechaActual.getHours() > 12 && fechaActual.getHours() < 18) {
            mensaje += ", Feliz Tarde. ";
        }
        if (fechaActual.getHours() > 18) {
            mensaje += ", Feliz Noche. ";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, " - Apagando AGNI -", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public void ejecutarComando(String comando) {
        String s = null;
        try {
            Process p = Runtime.getRuntime().exec(comando);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // Leemos la salida del comando
            System.out.println(comando);
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            UtilLog.generarLog(this.getClass(), ex);
            ex.printStackTrace();
        }
    }

    public String cerrarSesionTest() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ((HttpSession) externalContext.getSession(true)).invalidate();
        return ("/test.xhtml?faces-redirect=true");
    }

    public void mensajeDonar() {
        UtilPF.addSuccessMsg("Ayudanos a Mejorar", "Ayudanos a adquirir nuevos test, da tu aporte <br/><br/> <ul type = circle><br/><li>BTC - 3E43Vh3MABRgRqszxVDE8oJ5xF15mBDx4r</li><br/></ul>");
    }
}
