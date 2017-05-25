/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class CampanaRecurso {

    String id_campana;
    String id_recurso;
    String c_cantidad;
    String c_costo_unitario;

    public CampanaRecurso(String id_campana, String id_recurso, String c_cantidad, String c_costo_unitario) {
        this.id_campana = id_campana;
        this.id_recurso = id_recurso;
        this.c_cantidad = c_cantidad;
        this.c_costo_unitario = c_costo_unitario;
    }

    public String getId_campana() {
        return id_campana;
    }

    public void setId_campana(String id_campana) {
        this.id_campana = id_campana;
    }

    public String getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(String id_recurso) {
        this.id_recurso = id_recurso;
    }

    public String getC_cantidad() {
        return c_cantidad;
    }

    public void setC_cantidad(String c_cantidad) {
        this.c_cantidad = c_cantidad;
    }

    public String getC_costo_unitario() {
        return c_costo_unitario;
    }

    public void setC_costo_unitario(String c_costo_unitario) {
        this.c_costo_unitario = c_costo_unitario;
    }

    public void insertar() {
        String consultaSQL = "insert into t_campana_recurso (id_campana,id_recurso,c_cantidad,c_costo_unitario) values ";
        consultaSQL += "('" + this.id_campana + "','" + this.id_recurso + "','" + this.c_cantidad + "','" + this.c_costo_unitario + "')";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();
    }

    public void eliminar() {
        String consultaSQL = "DELETE FROM t_campana_recurso where id_campana='" + this.id_campana + "' and id_recurso='" + this.id_recurso + "';";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();
    }

    public static CampanaRecurso buscarPorCodigo(String campana, String recurso) {
        String consultaSQL = "select id_campana,id_recurso,c_cantidad,c_costo_unitario from t_campana_recurso where id_campana=" + campana + " and id_recurso=" + recurso + ";";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<CampanaRecurso> listaDeCampanaRecurso = new ArrayList<CampanaRecurso>();
        try {
            while (rs.next()) {
                listaDeCampanaRecurso.add(new CampanaRecurso(rs.getString("id_campana"),
                        rs.getString("id_recurso"),
                        rs.getString("c_cantidad"),
                        rs.getString("c_costo_unitario")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(consultaSQL);
        helper.cerrarConeccion();
        helper.cerrarConeccion();
        return listaDeCampanaRecurso.get(0);
    }

    public static List<CampanaRecurso> buscarCampanas( String recurso) {
        String consultaSQL = "select id_campana,id_recurso,c_cantidad,c_costo_unitario from t_campana_recurso where id_recurso=" + recurso + ";";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<CampanaRecurso> listaDeCampanaRecurso = new ArrayList<CampanaRecurso>();
        try {
            while (rs.next()) {
                listaDeCampanaRecurso.add(new CampanaRecurso(rs.getString("id_campana"),
                        rs.getString("id_recurso"),
                        rs.getString("c_cantidad"),
                        rs.getString("c_costo_unitario")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(consultaSQL);
        helper.cerrarConeccion();
        helper.cerrarConeccion();
        return listaDeCampanaRecurso;
    }
}
