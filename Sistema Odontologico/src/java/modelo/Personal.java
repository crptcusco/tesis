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
public class Personal {

    private String codigo;
    private String nombre;
    private String apellido;
    private String fecha;
    private String dni;
    private String telefono;
    private String direccion;
    private String tipo;
    private String estado;
    private String contrasena;

    public Personal(String nombre, String apellido, String fecha, String dni, String telefono, String direccion, String tipo, String estado, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
        this.contrasena = contrasena;
    }

    public Personal(String codigo, String nombre, String apellido, String fecha, String dni, String telefono, String direccion, String tipo, String estado, String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
        this.contrasena = contrasena;
    }

    public void inhabilitar() {
        String consultaSQL = "UPDATE `t_personal` SET `c_estado`='I' WHERE `id_personal`=" + this.codigo;
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();
    }

    public void habilitar() {
        String consultaSQL = "UPDATE `t_personal` SET `c_estado`='A' WHERE `id_personal`=" + this.codigo;
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();
    }

    public void insertar() {
        String consultaSQL = "insert into t_personal (c_nombres,c_apellidos,c_fecha_nac,c_dni,"
                + "c_telefono,c_direccion , c_tipo,c_estado,c_contrasena) values ";
        consultaSQL += "('" + this.nombre + "','" + this.apellido + "','" + this.fecha + "','" + this.dni + "','" + this.telefono + "','" + this.direccion + "','" + this.tipo + "','" + this.estado + "','" + this.contrasena + "')";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();

    }

    public void eliminar() {
        String consultaSQL = "DELETE FROM t_personal where id_personal='" + this.codigo + "'";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();

    }

    public void modificar() {
        String consultaSQL = "update t_personal set c_nombres='" + this.nombre
                + "',c_apellidos='" + this.apellido
                + "',c_fecha_nac='" + this.fecha
                + "',c_dni='" + this.dni
                + "',c_telefono='" + this.telefono
                + "',c_direccion='" + this.direccion
                + "',c_tipo='" + this.tipo
                + "',c_estado='" + this.estado
                + "',c_contrasena='" + this.contrasena
                + "' where id_personal='" + this.codigo + "'";

        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
        helper.cerrarConeccion();
    }

    /**
     *
     * @return
     */
    public static List<Personal> buscarTodos() {
        String consultaSQL = "select id_personal,c_nombres,c_apellidos,c_fecha_nac,c_dni,c_telefono,c_direccion,c_tipo,c_estado,c_contrasena from t_personal";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<Personal> listaDePersonal = new ArrayList<Personal>();
        try {
            while (rs.next()) {
                listaDePersonal.add(new Personal(rs.getString("id_personal"),
                        rs.getString("c_nombres"), rs.getString("c_apellidos"),
                        rs.getString("c_fecha_nac"),
                        rs.getString("c_dni"), rs.getString("c_telefono"),
                        rs.getString("c_direccion"), rs.getString("c_tipo"),
                        rs.getString("c_estado"), rs.getString("c_contrasena")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        helper.cerrarConeccion();
        return listaDePersonal;
    }

    public static Personal buscarPorCodigo(String codigo) {
        String consultaSQL = "select id_personal,c_nombres,c_apellidos,c_fecha_nac,c_dni,c_telefono,c_direccion,c_tipo,c_estado,c_contrasena from t_personal where id_personal=" + codigo;
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<Personal> listaDePersonal = new ArrayList<Personal>();
        try {
            while (rs.next()) {
                listaDePersonal.add(new Personal(rs.getString("id_personal"),
                        rs.getString("c_nombres"), rs.getString("c_apellidos"),
                        rs.getString("c_fecha_nac"),
                        rs.getString("c_dni"), rs.getString("c_telefono"),
                        rs.getString("c_direccion"), rs.getString("c_tipo"),
                        rs.getString("c_estado"), rs.getString("c_contrasena")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        helper.cerrarConeccion();
        return listaDePersonal.get(0);
    }

    public static boolean existePorCodigo(String codigo) {

        String consultaSQL = "select id_personal,c_nombres,c_apellidos,c_fecha_nac,c_dni,c_telefono,c_direccion,c_tipo,c_estado,c_contrasena from t_personal where  id_personal=" + codigo;
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        List<Personal> listaDePersonal = new ArrayList<Personal>();
        try {
            while (rs.next()) {
                listaDePersonal.add(new Personal(rs.getString("id_personal"),
                        rs.getString("c_nombres"), rs.getString("c_apellidos"),
                        rs.getString("c_fecha_nac"),
                        rs.getString("c_dni"), rs.getString("c_telefono"),
                        rs.getString("c_direccion"), rs.getString("c_tipo"),
                        rs.getString("c_estado"), rs.getString("c_contrasena")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        helper.cerrarConeccion();
        if (listaDePersonal.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
