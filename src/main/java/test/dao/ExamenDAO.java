/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import conexion.Consulta;
import general.modelo.Establecimiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import test.modelo.Examen;
import test.modelo.ExamenDetalle;
import test.modelo.ExamenDetallePK;
import test.modelo.Usuario;
import test.modelo.UsuarioTest;
import test.modelo.UsuarioTestResultado;

/**
 *
 * @author juliano
 */
public class ExamenDAO {

    public ExamenDAO(Connection conexion) {
        this.conexion = conexion;
    }

    private Connection conexion;

    public List<Examen> cargarListaExamen() throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        List<Examen> examens = new ArrayList<>();
        try {
            consulta = new Consulta(conexion);
            StringBuilder sql = new StringBuilder(
                    "SELECT cod_examen, descripcion, privado"
                    + " FROM test.examen"
            );
            rs = consulta.ejecutar(sql);
            while (rs.next()) {
                examens.add(new Examen(rs.getString("cod_examen"), rs.getString("descripcion"), rs.getBoolean("privado")));
            }
            return examens;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public List<ExamenDetalle> cargarExamenDetalles(Examen e) throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        List<ExamenDetalle> examenDetalles = new ArrayList<>();
        try {
            consulta = new Consulta(conexion);
            StringBuilder sql = new StringBuilder(
                    "SELECT cod_examen, cod_pregunta, respuesta, tipo_respuesta, comentario"
                    + " FROM test.examen_detalle"
                    + " WHERE cod_examen='" + e.getCodExamen() + "' ORDER BY cod_pregunta"
            );
            rs = consulta.ejecutar(sql);
            while (rs.next()) {
                examenDetalles.add(new ExamenDetalle(rs.getString("cod_examen"), rs.getInt("cod_pregunta"), rs.getString("respuesta"), rs.getString("tipo_respuesta"), rs.getString("comentario")));
            }
            return examenDetalles;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public void guardarUsuarioTest(UsuarioTest usuarioTest) throws SQLException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(conexion);
            StringBuilder sql = new StringBuilder(
                    "INSERT INTO test.usuario_test("
                    + " email, cod_examen, cod_pregunta, respuesta)"
                    + " VALUES ('" + usuarioTest.getEmail() + "', '" + usuarioTest.getCodExamen() + "', " + usuarioTest.getCodPregunta() + ", '" + usuarioTest.getRespuesta() + "')"
            );
            consulta.actualizar(sql);

        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public int actualizarUsuarioTest(UsuarioTest usuarioTest) throws SQLException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(conexion);
            StringBuilder sql = new StringBuilder(
                    "UPDATE test.usuario_test"
                    + " SET respuesta='" + usuarioTest.getRespuesta() + "'"
                    + " WHERE email='" + usuarioTest.getEmail() + "' AND cod_examen='" + usuarioTest.getCodExamen() + "' AND cod_pregunta=" + usuarioTest.getCodPregunta()
            );
            return consulta.actualizar(sql);
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public void terminarTest(Usuario usuario, Examen examen) throws SQLException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(conexion);
            StringBuilder sql = new StringBuilder(
                    "INSERT INTO test.usuario_test_resultado"
                    + " SELECT '" + usuario.getEmail() + "' as email, (SELECT COALESCE(MAX(cod_intento)+1,1) FROM test.usuario_test_resultado WHERE email='" + usuario.getEmail() + "') as cod_intento,"
                    + " ED.cod_examen, ED.cod_pregunta, COALESCE(UT.respuesta,'N'), ED.respuesta, ED.respuesta = COALESCE(UT.respuesta,'N')"
                    + " FROM test.examen_detalle ED"
                    + " LEFT JOIN test.usuario_test UT ON (UT.cod_examen=ED.cod_examen AND UT.cod_pregunta=ED.cod_pregunta AND UT.email='" + usuario.getEmail() + "')"
                    + " WHERE ED.cod_examen='" + examen.getCodExamen() + "'"
            );
            consulta.actualizar(sql);
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

    public List<UsuarioTestResultado> cargarUsuarioTestResultado(Usuario usuario) throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        List<UsuarioTestResultado> usuarioTestResultados = new ArrayList<>();
        try {
            consulta = new Consulta(conexion);
            StringBuilder sql = new StringBuilder(
                    "WITH ultimo_test AS ("
                    + " SELECT email, MAX(cod_intento) AS cod_intento"
                    + " FROM test.usuario_test_resultado"
                    + " WHERE email='" + usuario.getEmail() + "'"
                    + " GROUP BY 1"
                    + " )"
                    + " SELECT UTR.email, UTR.cod_intento, UTR.cod_examen, UTR.cod_pregunta, UTR.respuesta, UTR.respuesta_correcta, UTR.aprueba FROM test.usuario_test_resultado UTR,ultimo_test where UTR.email= ultimo_test.email AND UTR.cod_intento=ultimo_test.cod_intento"
                    + " ORDER BY UTR.cod_intento, UTR.cod_pregunta"
            );
            rs = consulta.ejecutar(sql);
            while (rs.next()) {
                usuarioTestResultados.add(new UsuarioTestResultado(rs.getString("email"), rs.getInt("cod_intento"), rs.getString("cod_examen"), rs.getInt("cod_pregunta"), rs.getString("respuesta"),
                        rs.getString("respuesta_correcta"), rs.getBoolean("aprueba")));
            }
            return usuarioTestResultados;
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
