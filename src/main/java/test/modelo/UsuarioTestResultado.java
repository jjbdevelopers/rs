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
 * @author juliano
 */
@Entity
@Table(name = "usuario_test_resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTestResultado.findAll", query = "SELECT u FROM UsuarioTestResultado u"),
    @NamedQuery(name = "UsuarioTestResultado.findByEmail", query = "SELECT u FROM UsuarioTestResultado u WHERE u.usuarioTestResultadoPK.email = :email"),
    @NamedQuery(name = "UsuarioTestResultado.findByCodIntento", query = "SELECT u FROM UsuarioTestResultado u WHERE u.usuarioTestResultadoPK.codIntento = :codIntento"),
    @NamedQuery(name = "UsuarioTestResultado.findByCodExamen", query = "SELECT u FROM UsuarioTestResultado u WHERE u.usuarioTestResultadoPK.codExamen = :codExamen"),
    @NamedQuery(name = "UsuarioTestResultado.findByCodPregunta", query = "SELECT u FROM UsuarioTestResultado u WHERE u.usuarioTestResultadoPK.codPregunta = :codPregunta"),
    @NamedQuery(name = "UsuarioTestResultado.findByRespuesta", query = "SELECT u FROM UsuarioTestResultado u WHERE u.respuesta = :respuesta"),
    @NamedQuery(name = "UsuarioTestResultado.findByRespuestaCorrecta", query = "SELECT u FROM UsuarioTestResultado u WHERE u.respuestaCorrecta = :respuestaCorrecta"),
    @NamedQuery(name = "UsuarioTestResultado.findByAprueba", query = "SELECT u FROM UsuarioTestResultado u WHERE u.aprueba = :aprueba")})
public class UsuarioTestResultado implements Serializable {

    /**
     * @return the style
     */
    public String getStyle() {
        if (!aprueba) {
            style = "border-color: red; border-style: solid;";
        }
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @return the apruebaInt
     */
    public Integer getApruebaInt() {
        if (aprueba) {
            apruebaInt = 1;
        } else {
            apruebaInt = 2;
        }
        return apruebaInt;
    }

    /**
     * @param apruebaInt the apruebaInt to set
     */
    public void setApruebaInt(Integer apruebaInt) {
        if (aprueba) {
            apruebaInt = 1;
        } else {
            apruebaInt = 2;
        }
        this.apruebaInt = apruebaInt;
    }

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioTestResultadoPK usuarioTestResultadoPK;
    @Column(name = "respuesta")
    private String respuesta;
    @Column(name = "respuesta_correcta")
    private String respuestaCorrecta;
    @Column(name = "aprueba")
    private Boolean aprueba;

    private Integer apruebaInt;
    private String style;

    public UsuarioTestResultado() {
    }

    public UsuarioTestResultado(UsuarioTestResultadoPK usuarioTestResultadoPK) {
        this.usuarioTestResultadoPK = usuarioTestResultadoPK;
    }

    public UsuarioTestResultado(String email, int codIntento, String codExamen, int codPregunta, String respuesta, String respuestaCorrecta, Boolean aprueba) {
        this.usuarioTestResultadoPK = new UsuarioTestResultadoPK(email, codIntento, codExamen, codPregunta);
        this.respuesta = respuesta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.aprueba = aprueba;
    }

    public UsuarioTestResultadoPK getUsuarioTestResultadoPK() {
        return usuarioTestResultadoPK;
    }

    public void setUsuarioTestResultadoPK(UsuarioTestResultadoPK usuarioTestResultadoPK) {
        this.usuarioTestResultadoPK = usuarioTestResultadoPK;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Boolean getAprueba() {
        return aprueba;
    }

    public void setAprueba(Boolean aprueba) {
        this.aprueba = aprueba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioTestResultadoPK != null ? usuarioTestResultadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTestResultado)) {
            return false;
        }
        UsuarioTestResultado other = (UsuarioTestResultado) object;
        if ((this.usuarioTestResultadoPK == null && other.usuarioTestResultadoPK != null) || (this.usuarioTestResultadoPK != null && !this.usuarioTestResultadoPK.equals(other.usuarioTestResultadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.modelo.UsuarioTestResultado[ usuarioTestResultadoPK=" + usuarioTestResultadoPK + " ]";
    }

}
