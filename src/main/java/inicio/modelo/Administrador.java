/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.modelo;

/**
 *
 * @author Sinergia
 */
public class Administrador extends Usuario {

    private float capital;

    /**
     * @return the capital
     */
    public float getCapital() {
        return capital;
    }

    /**
     * @param capital the capital to set
     */
    public void setCapital(float capital) {
        this.capital = capital;
    }

    public void setUsuario(Usuario usuario) {
        this.activo = usuario.isActivo();
        this.apellido = usuario.getApellido();
        this.clave = usuario.getClave();
        this.correo = usuario.getCorreo();
        this.documentoUsuario = usuario.getDocumentoUsuario();
        this.nombre = usuario.getNombre();
        this.rol = usuario.getRol();
        this.usuario = usuario.getUsuario();
    }

}
