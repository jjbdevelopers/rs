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
public class ExamenDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_examen")
    private String codExamen;
    @Basic(optional = false)
    @Column(name = "cod_pregunta")
    private int codPregunta;

    public ExamenDetallePK() {
    }

    public ExamenDetallePK(String codExamen, int codPregunta) {
        this.codExamen = codExamen;
        this.codPregunta = codPregunta;
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
        hash += (int) codPregunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenDetallePK)) {
            return false;
        }
        ExamenDetallePK other = (ExamenDetallePK) object;
        if (this.codExamen != other.codExamen) {
            return false;
        }
        if (this.codPregunta != other.codPregunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.modelo.ExamenDetallePK[ codExamen=" + codExamen + ", codPregunta=" + codPregunta + " ]";
    }
    
}
