/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;

/**
 *
 * @author Davixc
 */
public interface Interface {
    public List<Alumno> recuperarTodas(Connection conexion) throws SQLException;
      public DefaultTableModel buscarPer(String buscar) ;
          public void eliminar(Connection conexion, Alumno alumno) throws SQLException;
           public void guardar(Connection conexion, Alumno alumnos);
           public void modificar(Connection conexion, Alumno alumnos);
           public DefaultTableModel buscarLicenciatura(String buscar);
                  public DefaultTableModel buscarSemestre(String buscar);
                          public DefaultTableModel buscarFecha(String buscar);
  

    
}
