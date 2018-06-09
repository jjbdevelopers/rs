/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author juliano
 */
@Embeddable
public class UsuarioTestResultadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "cod_intento")
    private int codIntento;
    @Basic(optional = false)
    @Column(name = "cod_examen")
    private String codExamen;
    @Basic(optional = false)
    @Column(name = "cod_pregunta")
    private int codPregunta;

    public UsuarioTestResultadoPK() {
    }

    public UsuarioTestResultadoPK(String email, int codIntento, String codExamen, int codPregunta) {
        this.email = email;
        this.codIntento = codIntento;
        this.codExamen = codExamen;
        this.codPregunta = codPregunta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodIntento() {
        return codIntento;
    }

    public void setCodIntento(int codIntento) {
        this.codIntento = codIntento;
    }

    public String getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(String codExamen) {
        this.codExamen = codExamen;
    }

    public int getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(int codPregunta) {
        this.codPregunta = codPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        hash += (int) codIntento;
        hash += (codExamen != null ? codExamen.hashCode() : 0);
        hash += (int) codPregunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTestResultadoPK)) {
            return false;
        }
        UsuarioTestResultadoPK other = (UsuarioTestResultadoPK) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        if (this.codIntento != other.codIntento) {
            return false;
        }
        if ((this.codExamen == null && other.codExamen != null) || (this.codExamen != null && !this.codExamen.equals(other.codExamen))) {
            return false;
        }
        if (this.codPregunta != other.codPregunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.modelo.UsuarioTestResultadoPK[ email=" + email + ", codIntento=" + codIntento + ", codExamen=" + codExamen + ", codPregunta=" + codPregunta + " ]";
    }
    
}
