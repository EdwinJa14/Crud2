
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public ResultSet ListarDatos()
{
    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from empleadoss");  
       return result;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
        return result;
    }
}


public void Actualizar(int codigo, String Apellidos, String Nombre, String telefono)
{
        try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update empleadoss set Apellidos ="+"'"+Apellidos+"',Nombre="+"'"+Nombre+"',telefono="+"'"+telefono+"' where idEmpleado="+"'"+codigo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}
public void Guardar (int Codigo, String Apellidos, String Nombre, String Telefono){
      Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update empleadoss set Apellidos ="+"'"+Apellidos+"',Nombre="+"'"+Nombre+"',telefono="+"'"+Telefono+"' where idEmpleado="+"'"+Codigo+"'");
}

}
