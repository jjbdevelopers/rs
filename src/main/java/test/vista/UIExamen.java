/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.vista;

import inicio.controlador.GestorUsuario;
import inicio.modelo.Sesion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import test.controlador.GestorExamen;
import test.modelo.Examen;
import test.modelo.UsuarioTestResultado;
import utilidades.modelo.UtilJSF;
import utilidades.modelo.UtilPF;

/**
 *
 * @author Sinergiao
 */
@ManagedBean(name = "uiExamen")
@SessionScoped
public class UIExamen {

    /**
     * @return the examenList
     */
    public List<Examen> getExamenList() {
        return examenList;
    }

    /**
     * @param examenList the examenList to set
     */
    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    private List<Examen> examenList;

    public UIExamen() {
        try {
            GestorExamen gestorExamen = new GestorExamen();
            examenList = gestorExamen.cargarListaExamen();
        } catch (Exception ex) {
            Logger.getLogger(UIExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String iniciarTest() {
        try {
            UIUsuario uiUsuario = (UIUsuario) UtilJSF.getBean("uiUsuario");
            Examen e = (Examen) UtilJSF.getBean("examen");
            GestorExamen gestorExamen = new GestorExamen();
            GestorUsuario gestorUsuario = new GestorUsuario();
            if (e.isPrivado()) {
                Sesion s = (Sesion) UtilJSF.getBean("sesion");
                if (!gestorUsuario.usuarioAutorizadoExamen(s.getTester().getEmail(), e.getCodExamen())) {
                    UtilPF.addSuccessMsg("Ayudanos a Mejorar", "Este TEST es cerrado, para adquirirlo debes enviar 30 (US) dolares  en BTC - ETH a las siguientes direcciones<br/><br/> <ul type = circle><br/><li>BTC - 3E43Vh3MABRgRqszxVDE8oJ5xF15mBDx4r</li><br/></ul>"
                            + "<br/><br/>Luego envias un correo con el soporte de pago a sinergia.cor@gmail.com, donde indiques el codigo del examen que deseas habilitar."
                            + "<br/><br/>Se habilitará el correo de donde envies el comprobante, si se descubre que compartes tu correo a otros usuarios se te inactivara tu cuenta."
                            + "<br/><br/>Tu aporte ayudara a desarrollar test a otros usuarios.");
                    return null;
                }
            }
            e.setExamenDetalles(gestorExamen.cargarExamenDetalles(e));
            uiUsuario.setExamen(e);
            UtilJSF.setBean("uiUsuario", uiUsuario, UtilJSF.SESSION_SCOPE);
            return ("/test/testear.xhtml?faces-redirect=false");
        } catch (Exception ex) {
            Logger.getLogger(UIExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String terminarTest() {
        try {
            UIUsuario uiUsuario = (UIUsuario) UtilJSF.getBean("uiUsuario");
            Sesion sesion = (Sesion) UtilJSF.getBean("sesion");
            GestorExamen gestorExamen = new GestorExamen();
            gestorExamen.terminarTest(sesion.getTester(), uiUsuario.getExamen());
            uiUsuario.setExamen(new Examen());
            uiUsuario.setUsuarioTestResultadoList(gestorExamen.cargarUsuarioTestResultado(sesion.getTester()));

            UtilJSF.setBean("uiUsuario", uiUsuario, UtilJSF.SESSION_SCOPE);

            return ("/test/resultado.xhtml?faces-redirect=false");
        } catch (Exception ex) {
            Logger.getLogger(UIExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String volverMenu() {
        return ("/test/principal.xhtml?faces-redirect=false");
    }

    public String verTest() {
        try {
            UIUsuario uiUsuario = (UIUsuario) UtilJSF.getBean("uiUsuario");
            Sesion sesion = (Sesion) UtilJSF.getBean("sesion");
            GestorExamen gestorExamen = new GestorExamen();
            uiUsuario.setUsuarioTestResultadoList(gestorExamen.cargarUsuarioTestResultado(sesion.getTester()));
            UtilJSF.setBean("uiUsuario", uiUsuario, UtilJSF.SESSION_SCOPE);
            return ("/test/resultado.xhtml?faces-redirect=false");
        } catch (Exception ex) {
            Logger.getLogger(UIExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
