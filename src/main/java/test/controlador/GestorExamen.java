/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.controlador;

import general.controlador.Gestor;
import java.util.List;
import test.dao.ExamenDAO;
import test.modelo.Examen;
import test.modelo.ExamenDetalle;
import test.modelo.Usuario;
import test.modelo.UsuarioTest;
import test.modelo.UsuarioTestResultado;

/**
 *
 * @author juliano
 */
public class GestorExamen extends Gestor {

    public GestorExamen() throws Exception {
        super();
    }

    public List<Examen> cargarListaExamen() throws Exception {
        try {
            abrirConexion();
            return new ExamenDAO(conexion).cargarListaExamen();
        } finally {
            cerrarConexion();
        }

    }

    public List<ExamenDetalle> cargarExamenDetalles(Examen e) throws Exception {
        try {
            abrirConexion();
            return new ExamenDAO(conexion).cargarExamenDetalles(e);
        } finally {
            cerrarConexion();
        }
    }

    public void guardarUsuarioTest(UsuarioTest usuarioTest) throws Exception {
        try {
            abrirConexion();
            new ExamenDAO(conexion).guardarUsuarioTest(usuarioTest);
        } finally {
            cerrarConexion();
        }
    }

    public int actualizarUsuarioTest(UsuarioTest usuarioTest) throws Exception {
        try {
            abrirConexion();
            return new ExamenDAO(conexion).actualizarUsuarioTest(usuarioTest);
        } finally {
            cerrarConexion();
        }
    }

    public void terminarTest(Usuario usuario, Examen examen) throws Exception {
        try {
            abrirConexion();
            this.inicioTransaccion();

            ExamenDAO examenDAO = new ExamenDAO(conexion);
            examenDAO.terminarTest(usuario, examen);

            this.finTransaccion();
        } catch (Exception e) {
            this.devolverTransaccion();
            throw e;
        } finally {
            cerrarConexion();
        }
    }

    public List<UsuarioTestResultado> cargarUsuarioTestResultado(Usuario usuario) throws Exception {
        try {
            abrirConexion();
            return new ExamenDAO(conexion).cargarUsuarioTestResultado(usuario);
        } finally {
            cerrarConexion();
        }
    }

}
