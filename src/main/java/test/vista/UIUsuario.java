/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.vista;

import com.sun.jersey.api.representation.Form;
import inicio.modelo.Sesion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import test.modelo.Examen;
import test.modelo.ExamenDetalle;
import test.modelo.Usuario;
import test.modelo.UsuarioTestResultado;
import utilidades.modelo.UtilCorreo;
import utilidades.modelo.UtilJSF;
import utilidades.modelo.UtilMSG;
import utilidades.modelo.UtilRest;

/**
 *
 * @author juliano
 */
@ManagedBean(name = "uiUsuario")
@SessionScoped
public class UIUsuario {

    /**
     * @return the usuarioTestResultadoList
     */
    public List<UsuarioTestResultado> getUsuarioTestResultadoList() {
        return usuarioTestResultadoList;
    }

    /**
     * @param usuarioTestResultadoList the usuarioTestResultadoList to set
     */
    public void setUsuarioTestResultadoList(List<UsuarioTestResultado> usuarioTestResultadoList) {
        this.usuarioTestResultadoList = usuarioTestResultadoList;
    }

    /**
     * @return the usuarioTestResultado
     */
    public UsuarioTestResultado getUsuarioTestResultado() {
        return usuarioTestResultado;
    }

    /**
     * @param usuarioTestResultado the usuarioTestResultado to set
     */
    public void setUsuarioTestResultado(UsuarioTestResultado usuarioTestResultado) {
        this.usuarioTestResultado = usuarioTestResultado;
    }

    /**
     * @return the examen
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     * @param examen the examen to set
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrarSesion() {
        Sesion sesion = new Sesion();
        if (usuario != null && usuario.getEmail() != null) {
            usuario.setEmail(usuario.getEmail().toLowerCase().trim());
        }
        if (UtilCorreo.validarCorreo(usuario.getEmail())) {
            try {
                StringBuilder m = new StringBuilder(
                        "Hola " + usuario.getEmail() + ",<br/>te deseamos suerte en tu proceso de certificación. <br/><br/>"
                        + "Ayudanos a mejorar donando. <br/><br/>"
                        + "<font face='Trebuchet MS, Arial, Helvetica, sans-serif' style='font-size:16px'>BTC - 3E43Vh3MABRgRqszxVDE8oJ5xF15mBDx4r</font> <br><br/>"
                        + "<br/>Toda ayuda por minima que sea ayuda a mejorar y publicar nuevos test."
                );
//                Form f = new Form();
//                f.putSingle("nombre", usuario.getEmail());
//                f.putSingle("correo", usuario.getEmail());
//                f.putSingle("telefono", null);
//                f.putSingle("mensaje", m);
//                f.putSingle("asunto", "Te deseamos buena suerte!");

//                UtilRest.post("http://rsapp-rsapp.a3c1.starter-us-west-1.openshiftapps.com/webresources/generic/post/correoAsunto", f);
//                UtilCorreo.enviarCorreo(usuario.getEmail(), usuario.getEmail(), null, m, "Te deseamos buena suerte!");
//                UtilRest.post("http://localhost:8081/ips/webresources/generic/post/correoAsunto", f);
                usuario.setEmail(usuario.getEmail().toLowerCase().trim());
                sesion.setTester(usuario);
                sesion.setLogueado(true);
                UtilJSF.setBean("sesion", sesion, UtilJSF.SESSION_SCOPE);
                UtilJSF.setBean("uiExamen", new UIExamen(), UtilJSF.SESSION_SCOPE);
//                UtilPF.addSuccessMsg("Ayudanos a Mejorar", "Ayudanos a adquirir nuevos test, dona en BTC 1D1WLz6qyb9gb5ewuc1mh737UmoLkKdtDd");
                return ("/test/principal.xhtml?faces-redirect=true");
            } catch (Exception ex) {
                UtilMSG.addWarningMsg("No fue posible enviar un correo al ingresado, por favor validalo e intenta de nuevo.");
                Logger.getLogger(UIUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            UtilMSG.addErrorMsg("Ingresa un correo valido.");
        }
        return null;
    }

    public String total() {
        if (usuarioTestResultadoList != null) {
            return String.valueOf(usuarioTestResultadoList.size());
        }
        return "0";
    }

    public String correctas() {
        int i = 0;
        for (UsuarioTestResultado utr : usuarioTestResultadoList) {
            if (utr.getAprueba()) {
                i++;
            }
        }
        return String.valueOf(i);
    }

    public String incorrectas() {
        int i = 0;
        for (UsuarioTestResultado utr : usuarioTestResultadoList) {
            if (!utr.getAprueba()) {
                i++;
            }
        }
        return String.valueOf(i);
    }

    public String porcentaje() {
        String total = total();
        String c = correctas();
        float p = (Float.valueOf(c) / Float.valueOf(total)) * 100;
        return String.valueOf(p) + "%";
    }

    private Usuario usuario;
    private Examen examen;
    private UsuarioTestResultado usuarioTestResultado;
    private List<UsuarioTestResultado> usuarioTestResultadoList;

    public UIUsuario() {
        this.usuario = new Usuario();
    }

}
