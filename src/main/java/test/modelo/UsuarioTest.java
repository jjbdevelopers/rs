/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modelo;

import inicio.modelo.Sesion;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import test.controlador.GestorExamen;
import test.vista.UIUsuario;
import utilidades.modelo.UtilJSF;
import utilidades.modelo.UtilMSG;

/**
 *
 * @author Sinergiao
 */
@Entity
@Table(name = "usuario_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTest.findAll", query = "SELECT u FROM UsuarioTest u"),
    @NamedQuery(name = "UsuarioTest.findByEmail", query = "SELECT u FROM UsuarioTest u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioTest.findByCodExamen", query = "SELECT u FROM UsuarioTest u WHERE u.codExamen = :codExamen"),
    @NamedQuery(name = "UsuarioTest.findByCodPregunta", query = "SELECT u FROM UsuarioTest u WHERE u.codPregunta = :codPregunta"),
    @NamedQuery(name = "UsuarioTest.findByRespuesta", query = "SELECT u FROM UsuarioTest u WHERE u.respuesta = :respuesta")})
public class UsuarioTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "cod_examen")
    private String codExamen;
    @Basic(optional = false)
    @Column(name = "cod_pregunta")
    private int codPregunta;
    @Column(name = "respuesta")
    private String respuesta;

    public UsuarioTest() {
    }

    public UsuarioTest(String email) {
        this.email = email;
    }

    public UsuarioTest(String email, String codExamen, int codPregunta) {
        this.email = email;
        this.codExamen = codExamen;
        this.codPregunta = codPregunta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        try {
            GestorExamen gestorExamen = new GestorExamen();
            this.respuesta = respuesta;
            this.email = ((Sesion) UtilJSF.getBean("sesion")).getTester().getEmail();
            if (gestorExamen.actualizarUsuarioTest(this) == 0) {
                gestorExamen.guardarUsuarioTest(this);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
            UtilMSG.addErrorMsg(ex.getMessage());
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTest)) {
            return false;
        }
        UsuarioTest other = (UsuarioTest) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.modelo.UsuarioTest[ email=" + email + " ]";
    }

}
