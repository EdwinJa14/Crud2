
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public DefaultTableModel ListarDatos()
{
    /*Conexion*/
    DefaultTableModel TablaModelo= new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
    /*modelo Tabla*/
    TablaModelo.addColumn("ID");
      TablaModelo.addColumn("Apellido");
        TablaModelo.addColumn("Nombre");
          TablaModelo.addColumn("Telefono");
    
    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from Empleados");  
       
        while(result.next())
        {
            TablaModelo.addRow(new Object[]{result.getInt("Codigo"),
            result.getString("Apellidos"),
            result.getString("Nombre"),
              result.getString("Telefono")});
        }
        
        return TablaModelo;
    
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
        return TablaModelo;
    }
}


public void Actualizar(int codigo, String Apellidos, String Nombre, String telefono)
{
        try
        {
        
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update Empleados set Apellidos ="+"'"+Apellidos+"',Nombre="+"'"+
                Nombre+"',Telefono="+"'"+telefono+"' where Codigo="+"'"+codigo+"'");
        JOptionPane.showMessageDialog(null, "Dato Actualizado...");
      
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}
public void Guardar (int Codigo, String Apellidos, String Nombre, String Telefono){
    try{
      
       
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update Empleados set Apellidos ="+"'"+Apellidos+"',Nombre="+"'"+Nombre+"',Telefono="+
                "'"+Telefono+"' where Codigo="+"'"+Codigo+"'");
    }catch(SQLException ex)
    {
       JOptionPane.showMessageDialog(null, "No Se Pudo Guardar"); 
    }
    }

}

