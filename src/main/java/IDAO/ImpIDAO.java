/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import InterfaceDAO.Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import servicios.Conexion;

/**
 *
 * @author Davixc
 */
public class ImpIDAO implements Interface {

    @Override
    public List<Alumno> recuperarTodas(Connection conexion) throws SQLException {
        List<Alumno> tareas = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT  * FROM alumnouaemex");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                tareas.add(new Alumno(resultado.getString("noC"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidoP"),
                        resultado.getString("apellidoM"),
                        resultado.getString("grupo"),
                        resultado.getString("licenciatura"),
                        resultado.getString("semestre"),
                        resultado.getString("promedio"),
                        resultado.getString("fecha")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return tareas;
    }

    @Override
    public DefaultTableModel buscarPer(String buscar) {
        String[] nombreColum = {"noC", "nombre", " apellidoP", " apellidoM", "grupo", " licenciatura", " semestre", "promedio", " fecha"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColum);
        String sql = "select * from alumnouaemex where noC = " + buscar;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.obtener();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("noC");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellidoP");
                registros[3] = rs.getString("apellidoM");
                registros[4] = rs.getString("grupo");
                registros[5] = rs.getString("licenciatura");
                registros[6] = rs.getString("semestre");
                registros[7] = rs.getString("promedio");
                registros[8] = rs.getString("fecha");
                modelo.addRow(registros);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo;
    }

    @Override
    public void eliminar(Connection conexion, Alumno alumno) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM alumnouaemex  WHERE noC= ?");
            consulta.setString(1, alumno.getNoC());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

  

    @Override
    public void guardar(Connection conexion, Alumno alumnos) {
        PreparedStatement consulta;
        try {
//            if (alumnos.getNoC()) {
            consulta = conexion.prepareStatement("INSERT INTO  alumnouaemex (noC, nombre, apellidoP, apellidoM, grupo, licenciatura, semestre, promedio, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");
            consulta.setString(1, alumnos.getNoC());
            consulta.setString(2, alumnos.getNombre());
            consulta.setString(3, alumnos.getApellidoP());
            consulta.setString(4, alumnos.getApellidoM());
            consulta.setString(5, alumnos.getGrupo());
            consulta.setString(6, alumnos.getLicenciatura());
            consulta.setString(7, alumnos.getSemestre());
            consulta.setString(8, alumnos.getPromedio());
            consulta.setString(9, alumnos.getFecha_ingreso());
            consulta.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Override
    public void modificar(Connection conexion, Alumno alumnos) {
        PreparedStatement consulta;
        try {

            consulta = conexion.prepareStatement("UPDATE alumnouaemex SET  nombre=?, apellidoP=?, apellidoM=?, grupo=?, licenciatura=?, semestre=?, promedio=?, fecha=? WHERE noC=?");

            consulta.setString(1, alumnos.getNombre());
            consulta.setString(2, alumnos.getApellidoP());
            consulta.setString(3, alumnos.getApellidoM());
            consulta.setString(4, alumnos.getGrupo());
            consulta.setString(5, alumnos.getLicenciatura());
            consulta.setString(6, alumnos.getSemestre());
            consulta.setString(7, alumnos.getPromedio());
            consulta.setString(8, alumnos.getFecha_ingreso());
            consulta.setString(9, alumnos.getNoC());
            
            consulta.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
      public DefaultTableModel buscarLicenciatura(String buscar) {
        String[] nombreColum = {"noC", "nombre", " apellidoP", " apellidoM", "grupo", " licenciatura", " semestre", "promedio", " fecha"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColum);
        String sql = "select * from alumnouaemex where licenciatura = '" + buscar+"'";
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.obtener();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("noC");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellidoP");
                registros[3] = rs.getString("apellidoM");
                registros[4] = rs.getString("grupo");
                registros[5] = rs.getString("licenciatura");
                registros[6] = rs.getString("semestre");
                registros[7] = rs.getString("promedio");
                registros[8] = rs.getString("fecha");
                modelo.addRow(registros);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo;
    }
    @Override
       public DefaultTableModel buscarSemestre(String buscar) {
        String[] nombreColum = {"noC", "nombre", " apellidoP", " apellidoM", "grupo", " licenciatura", " semestre", "promedio", " fecha"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColum);
        String sql = "select * from alumnouaemex where semestre = " + buscar;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.obtener();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("noC");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellidoP");
                registros[3] = rs.getString("apellidoM");
                registros[4] = rs.getString("grupo");
                registros[5] = rs.getString("licenciatura");
                registros[6] = rs.getString("semestre");
                registros[7] = rs.getString("promedio");
                registros[8] = rs.getString("fecha");
                modelo.addRow(registros);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo;
    }
    @Override
        public DefaultTableModel buscarFecha(String buscar) {
        String[] nombreColum = {"noC", "nombre", " apellidoP", " apellidoM", "grupo", " licenciatura", " semestre", "promedio", " fecha"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColum);
        String sql = "select * from alumnouaemex where fecha = '" + buscar+"'";
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.obtener();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("noC");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellidoP");
                registros[3] = rs.getString("apellidoM");
                registros[4] = rs.getString("grupo");
                registros[5] = rs.getString("licenciatura");
                registros[6] = rs.getString("semestre");
                registros[7] = rs.getString("promedio");
                registros[8] = rs.getString("fecha");
                modelo.addRow(registros);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo;
    }
}
