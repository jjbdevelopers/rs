/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.modelo;

import general.modelo.Establecimiento;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sinergia
 */
@ManagedBean
@SessionScoped

public class Usuario implements Cloneable {

    public static String ROL_ADMINISTRADOR = "ADMINISTRADOR";
    public static String ROL_SUPER = "SUPER";
    public static final String FILTRO_USUARIO = "USUARIO";
    public static final String FILTRO_DOCUMENTO = "DOCUMENTO";

    protected boolean activo;

    protected String documentoUsuario = "";
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String clave;
    private String claveMd5;
    protected String correo;
    protected Rol rol;
    private String empresa = "1";
    private Date fechaRetiro;
    private Establecimiento establecimiento;
    private List<Establecimiento> listaEstablecimientos;

    public Usuario() {
        this.establecimiento = new Establecimiento();
        this.rol = new Rol();
    }

    /**
     * @return the documentoUsuario
     */
    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    /**
     * @param documentoUsuario the documentoUsuario to set
     */
    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the fechaRetiro
     */
    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    /**
     * @param fechaRetiro the fechaRetiro to set
     */
    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
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
     * @return the listaEstablecimientos
     */
    public List<Establecimiento> getListaEstablecimientos() {
        return listaEstablecimientos;
    }

    /**
     * @param listaEstablecimientos the listaEstablecimientos to set
     */
    public void setListaEstablecimientos(List<Establecimiento> listaEstablecimientos) {
        this.listaEstablecimientos = listaEstablecimientos;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            // No deberia ocurrir
        }
        return clone;
    }

    /**
     * @return the claveMd5
     */
    public String getClaveMd5() {
        return claveMd5;
    }

    /**
     * @param claveMd5 the claveMd5 to set
     */
    public void setClaveMd5(String claveMd5) {
        this.claveMd5 = claveMd5;
    }
}
