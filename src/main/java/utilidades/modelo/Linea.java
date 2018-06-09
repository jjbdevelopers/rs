/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.modelo;

import inicio.modelo.Administrador;
import inicio.modelo.Usuario;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sinergiao
 */
@ManagedBean
@SessionScoped
public class Linea {

    private Administrador administrador;
    private Usuario empleado;
    private String numero;
    private String numeroAnterior;
    private int minutosIncial;
    private int minutosFinal;
    private int minutosVendido;
    private float valor;
    private int minutosPlan;
    private Date fechaCorte;
    private Date fechaCierre;
    private boolean activo;
    
    private List<Linea> listaLineas;

    /**
     * @return the empleado
     */
    public Usuario getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the minutosIncial
     */
    public int getMinutosIncial() {
        return minutosIncial;
    }

    /**
     * @param minutosIncial the minutosIncial to set
     */
    public void setMinutosIncial(int minutosIncial) {
        this.minutosIncial = minutosIncial;
    }

    /**
     * @return the minutosFinal
     */
    public int getMinutosFinal() {
        return minutosFinal;
    }

    /**
     * @param minutosFinal the minutosFinal to set
     */
    public void setMinutosFinal(int minutosFinal) {
        this.minutosFinal = minutosFinal;
    }

    /**
     * @return the minutosVendido
     */
    public int getMinutosVendido() {
        return minutosVendido;
    }

    /**
     * @param minutosVendido the minutosVendido to set
     */
    public void setMinutosVendido(int minutosVendido) {
        this.minutosVendido = minutosVendido;
    }

    /**
     * @return the minutosPlan
     */
    public int getMinutosPlan() {
        return minutosPlan;
    }

    /**
     * @param minutosPlan the minutosPlan to set
     */
    public void setMinutosPlan(int minutosPlan) {
        this.minutosPlan = minutosPlan;
    }

    /**
     * @return the fechaCorte
     */
    public Date getFechaCorte() {
        return fechaCorte;
    }

    /**
     * @param fechaCorte the fechaCorte to set
     */
    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the fechaCierre
     */
    public Date getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param fechaCierre the fechaCierre to set
     */
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the listaLineas
     */
    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    /**
     * @param listaLineas the listaLineas to set
     */
    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    /**
     * @return the numeroAnterior
     */
    public String getNumeroAnterior() {
        return numeroAnterior;
    }

    /**
     * @param numeroAnterior the numeroAnterior to set
     */
    public void setNumeroAnterior(String numeroAnterior) {
        this.numeroAnterior = numeroAnterior;
    }
}
