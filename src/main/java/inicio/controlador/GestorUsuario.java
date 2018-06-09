 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.controlador;


import general.controlador.Gestor;
import general.modelo.Establecimiento;
import inicio.bd.UsuarioDAO;
import inicio.modelo.Rol;
import inicio.modelo.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Sinergia
 */
public class GestorUsuario extends Gestor {

    public GestorUsuario() throws Exception {
        super();
    }

//    public boolean validarUsuario(String usuario, String clave) throws Exception {
//        try {
//            this.abrirConexion();
//            return new UsuarioDAO(this.conexion).validarUsuario(usuario, clave);
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public ArrayList<Usuario> cargarListaUsuarios() throws Exception {
//        try {
//            this.abrirConexion();
//            return new UsuarioDAO(this.conexion).cargarListaUsuarios();
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public List<Usuario> cargarListaUsuariosEstablecimiento(Establecimiento establecimiento) throws Exception {
//        try {
//            this.abrirConexion();
//            return new UsuarioDAO(this.conexion).cargarListaUsuariosEstablecimiento(establecimiento);
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public Usuario cargarDatosUsuario(Establecimiento establecimiento, Usuario usuario, final String filtro) throws Exception {
//        try {
//            this.abrirConexion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            usuario = usuarioDAO.cargarDatosUsuario(usuario, filtro);
//            usuario = usuarioDAO.cargarRolUsuario(establecimiento, usuario);
//            return usuario;
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public Usuario cargarDatosUsuario(Usuario usuario, final String filtro) throws Exception {
//        try {
//            this.abrirConexion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            usuario = usuarioDAO.cargarDatosUsuario(usuario, filtro);
//            return usuario;
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public Collection<? extends String> autoCompletaUsuario(Establecimiento establecimiento, String query) throws Exception {
//        try {
//            this.abrirConexion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            return usuarioDAO.autoCompletaUsuario(establecimiento, query);
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public void almacenarUsuario(Establecimiento establecimiento, Usuario usuario) throws Exception {
//        try {
//            this.abrirConexion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            int registrosActualizados = usuarioDAO.actualizarUsuario(establecimiento, usuario);
//            if (registrosActualizados == 0) {
//                usuario.setActivo(true);
//                usuarioDAO.insertarUsuario(establecimiento, usuario);
//            }
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public List<Rol> cargarRoles() throws Exception {
//        try {
//            this.abrirConexion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            return usuarioDAO.cargarRoles();
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public void almacenarEstablecimientosUsuario(Usuario usuario) throws Exception {
//        try {
//            this.abrirConexion();
//            this.inicioTransaccion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            usuarioDAO.eliminarRolesUsuario(usuario);
//            usuarioDAO.eliminarEstablecimientosUsuario(usuario);
//            for (Establecimiento e : usuario.getListaEstablecimientos()) {
////                if (!usuarioDAO.existeEstablecimientoUsuario(e, usuario)) {
//                usuarioDAO.agregarEstablecimientosUsuario(e, usuario);
////                }
//            }
//            this.finTransaccion();
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public void almacenarRolUsuario(Establecimiento establecimiento, Usuario usuario) throws Exception {
//        try {
//            this.abrirConexion();
//            this.inicioTransaccion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//
//            for (Establecimiento e : usuario.getListaEstablecimientos()) {
//                usuarioDAO.eliminarRolUsuario(e, usuario);
//                usuarioDAO.agregarRolUsuario(e, usuario);
//            }
//
//            this.finTransaccion();
//        } finally {
//            this.cerrarConexion();
//        }
//    }
//
//    public boolean existeDocumentoUsuario(Usuario usuario) throws Exception {
//        try {
//            this.abrirConexion();
//            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//            return usuarioDAO.existeDocumentoUsuario(usuario);
//        } finally {
//            this.cerrarConexion();
//        }
//    }

    public boolean usuarioAutorizadoExamen(String email, String codExamen) throws Exception {
        try {
            this.abrirConexion();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            return usuarioDAO.usuarioAutorizadoExamen(email,codExamen);
        } finally {
            this.cerrarConexion();
        }
    }
}
