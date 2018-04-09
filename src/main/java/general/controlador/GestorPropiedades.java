/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general.controlador;

import java.util.Properties;

/**
 *
 * @author carlosf
 */
public class GestorPropiedades {

    public Properties cargarPropiedades() throws Exception {
        Properties p = new Properties();
        try {
//            p.setProperty("urlbd", "jdbc:postgresql://127.0.0.1:1432/bdjjb");
//            p.setProperty("urlbd", "jdbc:postgresql://10.1.1.141:5432/localizador");
            p.setProperty("urlbd", "jdbc:postgresql://postgresql.jjb-rs.svc:5432/bdjjb");
            p.setProperty("controlador", "org.postgresql.Driver");
            p.setProperty("usuario", "userXFO");
            p.setProperty("clave", "chutffq8vQ53gt88");
            
        } catch (Exception e) {
            throw e;
        }
        return p;
    }
}
