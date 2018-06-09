/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.vista;


import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utilidades.modelo.UtilidadesGeneral;

/**
 * Esta clase maneja la internacionalizacion del aplicativo y el control de
 * sesion del usuario
 *
 * @author hectorad
 */
@ManagedBean
@SessionScoped
public class I18nBean {

    private Locale locale = UtilidadesGeneral.LOCALE;
    private String idioma;
    private String[] idiomas = {"Inglés", "English", "Español", "Spanish"};
    private String usuario;
    private String clave;
    
    
    

    /**
     * Creates a new instance of I18nBean
     */
    public I18nBean() {        
    }

    public void cambiarIdioma() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (idioma.equals(idiomas[0]) || idioma.equals(idiomas[1])) {
            locale = Locale.ENGLISH;
            UtilidadesGeneral.LOCALE = locale;
            context.getViewRoot().setLocale(locale);
            if (idioma.equals(idiomas[0])) {
                idioma = idiomas[1];
            }
        } else if (idioma.equals(idiomas[2]) || idioma.equals(idiomas[3])) {
            locale = new Locale(UtilidadesGeneral.DEFAULT_LANGUAGE, UtilidadesGeneral.DEFAULT_COUNTRY);
            UtilidadesGeneral.LOCALE = locale;
            context.getViewRoot().setLocale(locale);
            if (idioma.equals(idiomas[2])) {
                idioma = idiomas[3];
            }
        }
    }

//    public String ingresar() {
//        if (usuario.equalsIgnoreCase("")) {
//            UtilidadesGeneral.adicionarMensajeError("usuarioRequiredMessage_usuario");
//            return "";
//        }
//        if (clave.equalsIgnoreCase("")) {
//            UtilidadesGeneral.adicionarMensajeAlerta("usuarioRequiredMessage_clave");
//            return "";
//        }
//        //se actualiza el cambio de idioma
//        cambiarIdioma();
//        try {
//            usuarioLogueado = usuarioEjb.getUsuarioDao().obtenerUsuario(usuario.toUpperCase());
//            if (usuarioLogueado == null) {
//                UtilidadesSIMA.addErrorMessage("usuarioNoExiste");
//                return "";
//            }
//            //se verifica la contraseña
//            if (!usuarioLogueado.getClave().equalsIgnoreCase(UtilidadesSIMA.obtenerMD5(clave.toUpperCase()))) {
//                UtilidadesSIMA.addErrorMessage("usuarioClaveIncorrecta");
//                return "";
//            }
//            //se verifica que el usuario tenga un rol asignado y que éste sea administrador
//            if (usuarioLogueado.getRolUsuarioList() == null || (usuarioLogueado.getRolUsuarioList() != null && usuarioLogueado.getRolUsuarioList().isEmpty())) {
//                UtilidadesSIMA.addErrorMessage("usuarioNoRol");
//                return "";
//            }
//            if (!usuarioLogueado.getRolUsuarioList().get(0).getRolEspecifico().getNombre().equalsIgnoreCase("ADMINISTRADOR")) {
//                UtilidadesSIMA.addErrorMessage("usuarioNoAdmin");
//                return "";
//            }
//            return "sucess";
//        } catch (Exception ex) {
//            UtilidadesSIMA.addErrorMessage("errorPersistencia");
//            UtilidadesSIMA.generarLog(ex);
//        }
//        return "salir";
//    }

//    public String salir() {
//        locale = new Locale(UtilidadesGeneral.DEFAULT_LANGUAGE, UtilidadesGeneral.DEFAULT_COUNTRY);
//        usuarioLogueado = null;
//        return "salir";
//    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the idiomas
     */
    public String[] getIdiomas() {
        return idiomas;
    }

    /**
     * @param idiomas the idiomas to set
     */
    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale.toString();
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
}
