/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sinergiao
 */
@Entity
@Table(name = "examen_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenDetalle.findAll", query = "SELECT e FROM ExamenDetalle e"),
    @NamedQuery(name = "ExamenDetalle.findByCodExamen", query = "SELECT e FROM ExamenDetalle e WHERE e.examenDetallePK.codExamen = :codExamen"),
    @NamedQuery(name = "ExamenDetalle.findByCodPregunta", query = "SELECT e FROM ExamenDetalle e WHERE e.examenDetallePK.codPregunta = :codPregunta"),
    @NamedQuery(name = "ExamenDetalle.findByRespuesta", query = "SELECT e FROM ExamenDetalle e WHERE e.respuesta = :respuesta"),
    @NamedQuery(name = "ExamenDetalle.findByTipoRespuesta", query = "SELECT e FROM ExamenDetalle e WHERE e.tipoRespuesta = :tipoRespuesta")})
public class ExamenDetalle implements Serializable {

    /**
     * @return the usuarioTest
     */
    public UsuarioTest getUsuarioTest() {
        return usuarioTest;
    }

    /**
     * @param usuarioTest the usuarioTest to set
     */
    public void setUsuarioTest(UsuarioTest usuarioTest) {
        this.usuarioTest = usuarioTest;
    }

    /**
     * @return the respuestaSeleccionadaMultiple
     */
    public String[] getRespuestaSeleccionadaMultiple() {
        return respuestaSeleccionadaMultiple;
    }

    /**
     * @param respuestaSeleccionadaMultiple the respuestaSeleccionadaMultiple to set
     */
    public void setRespuestaSeleccionadaMultiple(String[] respuestaSeleccionadaMultiple) {
        String respuestaSeleccionada = "";
        if (respuestaSeleccionadaMultiple != null) {
            respuestaSeleccionada = "";
            for (String r : respuestaSeleccionadaMultiple) {
                respuestaSeleccionada += r;
            }
        }
        System.out.println("rm=>" + respuestaSeleccionada);
        this.usuarioTest.setRespuesta(respuestaSeleccionada);
        this.respuestaSeleccionadaMultiple = respuestaSeleccionadaMultiple;
    }

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenDetallePK examenDetallePK;
    @Column(name = "respuesta")
    private String respuesta;
    @Column(name = "tipo_respuesta")
    private String tipoRespuesta;
    @Column(name = "tipo_respuesta")
    private Boolean mostrarRespuesta;
    private String comentario;

    private String[] respuestaSeleccionadaMultiple;
    private UsuarioTest usuarioTest;

    public ExamenDetalle() {
        this.usuarioTest = new UsuarioTest();
        this.mostrarRespuesta = false;
    }

    public ExamenDetalle(ExamenDetallePK examenDetallePK) {
        this.examenDetallePK = examenDetallePK;
        this.usuarioTest = new UsuarioTest(null, this.examenDetallePK.getCodExamen(), this.examenDetallePK.getCodPregunta());
    }

    public ExamenDetalle(String codExamen, int codPregunta, String respuesta, String tipoRespuesta, String comentario) {
        this.examenDetallePK = new ExamenDetallePK(codExamen, codPregunta);
        this.respuesta = respuesta;
        this.tipoRespuesta = tipoRespuesta;
        this.usuarioTest = new UsuarioTest(null, codExamen, codPregunta);
        this.comentario = comentario;
    }

    public ExamenDetallePK getExamenDetallePK() {
        return examenDetallePK;
    }

    public void setExamenDetallePK(ExamenDetallePK examenDetallePK) {
        this.examenDetallePK = examenDetallePK;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(String tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenDetallePK != null ? examenDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenDetalle)) {
            return false;
        }
        ExamenDetalle other = (ExamenDetalle) object;
        if ((this.examenDetallePK == null && other.examenDetallePK != null) || (this.examenDetallePK != null && !this.examenDetallePK.equals(other.examenDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.modelo.ExamenDetalle[ examenDetallePK=" + examenDetallePK + " ]";
    }

    public Boolean getMostrarRespuesta() {
        return mostrarRespuesta;
    }

    public void setMostrarRespuesta(Boolean mostrarRespuesta) {
        this.mostrarRespuesta = mostrarRespuesta;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
