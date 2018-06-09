/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juliano
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByCodExamen", query = "SELECT e FROM Examen e WHERE e.codExamen = :codExamen"),
    @NamedQuery(name = "Examen.findByDescripcipn", query = "SELECT e FROM Examen e WHERE e.descripcipn = :descripcipn")})
public class Examen implements Serializable {

    private boolean mostrarRespuesta;
    private boolean privado;
    private ExamenDetalle preguntaSeleccionada;

    /**
     * @return the examenDetalles
     */
    public List<ExamenDetalle> getExamenDetalles() {
        return examenDetalles;
    }

    /**
     * @param examenDetalles the examenDetalles to set
     */
    public void setExamenDetalles(List<ExamenDetalle> examenDetalles) {
        this.examenDetalles = examenDetalles;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_examen")
    private String codExamen;
    @Column(name = "descripcion")
    private String descripcion;

    private List<ExamenDetalle> examenDetalles;

    public Examen() {
        preguntaSeleccionada = new ExamenDetalle();
        mostrarRespuesta = false;
    }

    public Examen(String codExamen) {
        this.codExamen = codExamen;
    }

    public Examen(String codExamen, String descripcion, boolean privado) {
        this.codExamen = codExamen;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    public String getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(String codExamen) {
        this.codExamen = codExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcipn) {
        this.descripcion = descripcipn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codExamen != null ? codExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.codExamen == null && other.codExamen != null) || (this.codExamen != null && !this.codExamen.equals(other.codExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.modelo.Examen[ codExamen=" + codExamen + " ]";
    }

    public boolean isMostrarRespuesta() {
        return mostrarRespuesta;
    }

    public void setMostrarRespuesta(boolean mostrarRespuesta) {
        this.mostrarRespuesta = mostrarRespuesta;
    }

    public ExamenDetalle getPreguntaSeleccionada() {
        return preguntaSeleccionada;
    }

    public void setPreguntaSeleccionada(ExamenDetalle preguntaSeleccionada) {
        this.preguntaSeleccionada = preguntaSeleccionada;
    }

    /**
     * @return the privado
     */
    public boolean isPrivado() {
        return privado;
    }

    /**
     * @param privado the privado to set
     */
    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

}
