/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.bd;

import conexion.Consulta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Julian
 */
public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

//    public boolean validarUsuario(String usuario, String clave) throws Exception {
//        String claveIngresada;
//        String claveActual;
//        boolean usuarioValido = false;
//        ResultSet rs = null;
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            String sql = "SELECT documento_usuario, nombre, apellido, usuario, clave, activo, correo"
//                    + " FROM usuarios"
//                    + " WHERE usuario='" + usuario.toUpperCase() + "'";
//            rs = consulta.ejecutar(sql);
//            if (rs.next()) {
//                claveActual = rs.getString("clave");
//            } else {
//                throw new Exception("usuarioNoExiste", UtilLog.TW_VALIDACION);
//            }
//            sql = "SELECT md5('" + clave + "') AS claveIngresada";
//            rs = consulta.ejecutar(sql);
//            rs.next();
//            claveIngresada = rs.getString("claveIngresada");
//            if (claveActual.equalsIgnoreCase(claveIngresada)) {
//                usuarioValido = true;
//            } else {
//                throw new Exception("usuarioClaveIncorrecta", UtilLog.TW_VALIDACION);
//            }
//
//            return usuarioValido;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public ArrayList<Usuario> cargarListaUsuarios() throws Exception {
//        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
//        ResultSet rs = null;
//        Consulta consulta = null;
//
//        try {
//            consulta = new Consulta(this.conexion);
//            String sql = "SELECT documento_usuario, nombre, apellido, usuario, clave, activo,"
//                    + " correo"
//                    + " FROM usuarios";
//            rs = consulta.ejecutar(sql);
//            while (rs.next()) {
//                Usuario u = new Usuario();
//                u.setDocumentoUsuario(rs.getString("documento_usuario"));
//                u.setNombre(rs.getString("nombre"));
//                u.setApellido(rs.getString("apellido"));
//                u.setUsuario(rs.getString("usuario"));
//                u.setClave(rs.getString("clave"));
//                u.setActivo(rs.getBoolean("activo"));
//                u.setCorreo(rs.getString("correo"));
//                listaUsuarios.add(u);
//            }
//            return listaUsuarios;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public Usuario cargarDatosUsuario(Usuario usuario, final String filtro) throws SQLException {
//        ResultSet rs = null;
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "SELECT documento_usuario, nombre, apellido, usuario, clave, activo, correo"
//                    + " FROM usuarios"
//            );
//            switch (filtro) {
//                case Usuario.FILTRO_USUARIO:
//                    sql.append(" WHERE usuario='").append(usuario.getUsuario().toUpperCase()).append("'");
//                    break;
//                case Usuario.FILTRO_DOCUMENTO:
//                    sql.append(" WHERE documento_usuario='").append(usuario.getDocumentoUsuario()).append("'");
//                    break;
//                default:
//                    throw new SQLException("Filtro Usuario Invalido.");
//            }
//
//            rs = consulta.ejecutar(sql);
//            if (rs.next()) {
//                usuario.setDocumentoUsuario(rs.getString("documento_usuario"));
//                usuario.setNombre(rs.getString("nombre"));
//                usuario.setApellido(rs.getString("apellido"));
//                usuario.setActivo(rs.getBoolean("activo"));
//                usuario.setCorreo(rs.getString("correo"));
//                usuario.setUsuario(rs.getString("usuario"));
//                usuario.setClave(rs.getString("clave"));
//                usuario.setClaveMd5(rs.getString("clave"));
////                Establecimiento establecimientoUsuario = new Establecimiento(rs.getInt("codigo_establecimiento"));
////                usuario.setEstablecimiento(establecimientoUsuario);
//            }
//            return usuario;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public Usuario cargarRolUsuario(Establecimiento establecimiento, Usuario usuario) throws SQLException {
//        ResultSet rs = null;
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "SELECT RE.codigo_rol, RE.nombre"
//                    + " FROM roles_usuarios RU "
//                    + " JOIN roles RE USING (codigo_rol)"
//                    + " WHERE RU.codigo_establecimiento=" + establecimiento.getCodigo() + " AND documento_usuario = '" + usuario.getDocumentoUsuario() + "'"
//            );
//            rs = consulta.ejecutar(sql);
//            Rol rol = new Rol();
//            if (rs.next()) {
//                rol.setCodigoRol(rs.getInt("codigo_rol"));
//                rol.setNombre(rs.getString("nombre"));
//            }
//            usuario.setRol(rol);
//            return usuario;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public Collection<? extends String> autoCompletaUsuario(Establecimiento establecimiento, String query) throws SQLException {
//        ResultSet rs = null;
//        Consulta consulta = null;
//        List<String> resultados = new ArrayList<>();
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "SELECT documento_usuario, nombre, apellido,"
//                    + " usuario, clave, activo, correo, fecha_ingreso, fecha_retiro"
//                    + " FROM usuarios"
//                    + " WHERE usuario LIKE '%" + query.toUpperCase() + "%'"
//            );
//            rs = consulta.ejecutar(sql);
//            while (rs.next()) {
//                resultados.add(rs.getString("usuario"));
//            }
//            return resultados;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public int actualizarUsuario(Establecimiento establecimiento, Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "UPDATE usuarios"
//                    + " SET documento_usuario='" + usuario.getDocumentoUsuario().trim() + "',"
//                    + " nombre='" + usuario.getNombre().toUpperCase() + "', apellido='" + usuario.getApellido().toUpperCase() + "',"
//                    + " usuario='" + usuario.getUsuario().toUpperCase() + "',"
//                    + " clave=" + (usuario.getClave().equalsIgnoreCase(usuario.getClaveMd5()) ? "'" + usuario.getClaveMd5() + "'" : "md5('" + usuario.getClave() + "')") + ","
//                    + " activo=" + usuario.isActivo() + ", correo='" + usuario.getCorreo() + "', "
//                    + " fecha_retiro=" + UtilFecha.formatoFecha(usuario.getFechaRetiro(), null, UtilFecha.PATRON_FECHA_YYYYMMDD, UtilFecha.CARACTER_COMILLA)
//                    + " WHERE documento_usuario='" + usuario.getDocumentoUsuario() + "'"
//            );
//            return consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public void insertarUsuario(Establecimiento establecimiento, Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "INSERT INTO usuarios(codigo_establecimiento,"
//                    + " documento_usuario, nombre, apellido, "
//                    + " usuario, clave, activo, correo, fecha_ingreso, fecha_retiro)"
//                    + " VALUES (" + establecimiento.getCodigo() + ",'" + usuario.getDocumentoUsuario().trim() + "', '" + usuario.getNombre().toUpperCase() + "',"
//                    + "  '" + usuario.getApellido().toUpperCase() + "', '" + usuario.getUsuario().toUpperCase() + "',"
//                    + " MD5('" + usuario.getClave() + "')," + usuario.isActivo() + ",'" + usuario.getCorreo() + "',"
//                    + " current_date," + UtilFecha.formatoFecha(usuario.getFechaRetiro(), null, UtilFecha.PATRON_FECHA_YYYYMMDD, UtilFecha.CARACTER_COMILLA) + ")"
//            );
//            consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public List<Rol> cargarRoles() throws SQLException {
//
//        ResultSet rs = null;
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            List<Rol> listaRoles = new ArrayList<>();
//            StringBuilder sql = new StringBuilder(
//                    "SELECT codigo_rol, nombre"
//                    + " FROM roles"
//            );
//            rs = consulta.ejecutar(sql);
//
//            while (rs.next()) {
//                Rol rol = new Rol();
//                rol.setCodigoRol(rs.getInt("codigo_rol"));
//                rol.setNombre(rs.getString("nombre"));
//                listaRoles.add(rol);
//            }
//
//            return listaRoles;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public void eliminarEstablecimientosUsuario(Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "DELETE FROM rel_usuarios_establecimiento"
//                    + " WHERE documento_usuario='" + usuario.getDocumentoUsuario() + "'"
//            );
//            consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public void agregarEstablecimientosUsuario(Establecimiento establecimiento, Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "INSERT INTO rel_usuarios_establecimiento("
//                    + " codigo_establecimiento, documento_usuario)"
//                    + " VALUES (" + establecimiento.getCodigo() + ", '" + usuario.getDocumentoUsuario() + "')"
//            );
//            consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public void eliminarRolesUsuario(Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "DELETE FROM roles_usuarios"
//                    + " WHERE documento_usuario='" + usuario.getDocumentoUsuario() + "'"
//            );
//            consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public void eliminarRolUsuario(Establecimiento establecimiento, Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "DELETE FROM roles_usuarios"
//                    + " WHERE codigo_establecimiento=" + establecimiento.getCodigo() + " AND documento_usuario='" + usuario.getDocumentoUsuario() + "'"
//            );
//            consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public void agregarRolUsuario(Establecimiento establecimiento, Usuario usuario) throws SQLException {
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "INSERT INTO roles_usuarios("
//                    + " codigo_establecimiento, documento_usuario, codigo_rol)"
//                    + " VALUES (" + establecimiento.getCodigo() + ", '" + usuario.getDocumentoUsuario() + "', " + usuario.getRol().getCodigoRol() + ")"
//            );
//            consulta.actualizar(sql);
//        } finally {
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public List<Usuario> cargarListaUsuariosEstablecimiento(Establecimiento establecimiento) throws SQLException {
//        ResultSet rs = null;
//        Consulta consulta = null;
//        List<Usuario> listaUsuarios = new ArrayList<>();
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "SELECT RUE.codigo_establecimiento, U.documento_usuario, nombre, apellido,"
//                    + " usuario, clave, activo, correo, fecha_ingreso, fecha_retiro"
//                    + " FROM usuarios U"
//                    + " JOIN rel_usuarios_establecimiento RUE USING (documento_usuario)"
//                    + " WHERE RUE.codigo_establecimiento=" + establecimiento.getCodigo()
//            );
//            rs = consulta.ejecutar(sql);
//            while (rs.next()) {
//                Usuario u = new Usuario();
//                u.setDocumentoUsuario(rs.getString("documento_usuario"));
//                u.setNombre(rs.getString("nombre"));
//                u.setApellido(rs.getString("apellido"));
//                u.setUsuario(rs.getString("usuario"));
//                u.setClave(rs.getString("clave"));
//                u.setActivo(rs.getBoolean("activo"));
//                u.setCorreo(rs.getString("correo"));
//                listaUsuarios.add(u);
//            }
//            return listaUsuarios;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public boolean existeDocumentoUsuario(Usuario usuario) throws SQLException {
//        ResultSet rs = null;
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "SELECT count(1) > 0 as existe"
//                    + " FROM usuarios"
//                    + " WHERE documento_usuario='" + usuario.getDocumentoUsuario() + "'"
//            );
//            rs = consulta.ejecutar(sql);
//            rs.next();
//            return rs.getBoolean("existe");
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }
//
//    public boolean existeEstablecimientoUsuario(Establecimiento e, Usuario usuario) throws SQLException {
//        ResultSet rs = null;
//        Consulta consulta = null;
//        try {
//            consulta = new Consulta(this.conexion);
//            StringBuilder sql = new StringBuilder(
//                    "SELECT COUNT(1)>0 AS existe"
//                    + " FROM rel_usuarios_establecimiento"
//                    + " WHERE codigo_establecimiento =" + e.getCodigo() + " AND documento_usuario = '" + usuario.getDocumentoUsuario() + "'"
//            );
//            rs = consulta.ejecutar(sql);
//            rs.next();
//            return rs.getBoolean("existe");
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (consulta != null) {
//                consulta.desconectar();
//            }
//        }
//    }

    public boolean usuarioAutorizadoExamen(String email, String codExamen) throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.conexion);
            StringBuilder sql = new StringBuilder(
                    "SELECT COUNT(1)>0 AS existe"
                    + " FROM test.examen_usuario_autorizado"
                    + " WHERE email='" + email + "' AND cod_examen='" + codExamen + "'"
            );
            rs = consulta.ejecutar(sql);
            rs.next();
            return rs.getBoolean("existe");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }
}
