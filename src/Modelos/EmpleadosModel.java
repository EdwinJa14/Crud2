package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public DefaultTableModel ListarDatos()
{
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
        TablaModelo.addColumn("idEmpleados");
        TablaModelo.addColumn("Apellidos");
        TablaModelo.addColumn("Nombres");
        TablaModelo.addColumn("Telefono");


    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from EMPLEADOS ");
        
        
            while(result.next())
            {
                TablaModelo.addRow(new Object[]{result.getInt("codigo"),
                result.getString("apellidos"),
                result.getString("nombre"),
                result.getString("telefono")});
            }
        return TablaModelo;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
    }
    return TablaModelo;
}

public void Actualizar(int codigo, String Apellidos, String Nombre, String telefono)
{
        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement sentencia = MyConexion.createStatement();
            sentencia.executeQuery("Update EMPLEADOS set APELLIDOS="+
                    "'"+Apellidos+"',NOMBRE="+"'"+Nombre+"',TELEFONO="+"'"+telefono+
                    "' where CODIGO="+"'"+codigo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}
public void Guardar(int codigo, String Apellidos, String Nombres, String Telefono)
{
    try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement sentencia = MyConexion.createStatement();
            sentencia.executeQuery("Insert into EMPLEADOS values("+"'"+codigo+"',"+
                    "'"+Apellidos+"',"+"'"+Nombres+"',"+"'"+Telefono+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  
}

public void Eliminar(int codigo, String Apellidos, String Nombres, String Telefono)
{
    try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement sentencia = MyConexion.createStatement();
            sentencia.executeQuery("delete from EMPLEADOS where codigo="+"'"+codigo+"'");

        }
            catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar..."+ex.getMessage());
        }  
}

public DefaultTableModel ListConsulta(String consulta)
{
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
        
        TablaModelo.addColumn("Apellidos");
        TablaModelo.addColumn("Nombres");
        TablaModelo.addColumn("Telefono");
        TablaModelo.addColumn("idEmpleado");


    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery(consulta);
        
        
            while(result.next())
            {
                
                TablaModelo.addRow(new Object[]{result.getInt("codigo"),
                result.getString("apellidos"),
                result.getString("nombre"),
                result.getString("telefono")});
            }
        return TablaModelo;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
    }
    return TablaModelo;
}

}