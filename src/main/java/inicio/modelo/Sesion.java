/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.modelo;

import general.modelo.Establecimiento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sinergia
 */
@ManagedBean
@SessionScoped

public class Sesion {
    public static String RUTA_SERVICIO;
    
    private Usuario usuario;
    private Establecimiento establecimiento;
    private test.modelo.Usuario tester;
    private boolean logueado = false;

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

    /**
     * @return the establecimiento
     */
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    /**
     * @param establecimiento the establecimiento to set
     */
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    /**
     * @return the tester
     */
    public test.modelo.Usuario getTester() {
        return tester;
    }

    /**
     * @param tester the tester to set
     */
    public void setTester(test.modelo.Usuario tester) {
        this.tester = tester;
    }

    /**
     * @return the logueado
     */
    public boolean isLogueado() {
        return logueado;
    }

    /**
     * @param logueado the logueado to set
     */
    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

}
