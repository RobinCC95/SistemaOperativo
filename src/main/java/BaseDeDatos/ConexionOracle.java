/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ConexionOracle {
    
    private static Connection conn = null;
    private static String login = "ROBIN";    
    private static String password = "0000";
    private static String url = "jdbc:oracle:oci8:@localhost:1521:orcl";
    
    public Statement conn() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando a la bases de datos....");
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            return statement;

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"La exception lanzada es: "+ e.getMessage());
            return null;
        }
    }
    
    public  LinkedList<String> consulUsuarios(String from) 
    {
        try
        {
            Statement st = conn();
            ResultSet resultSet = st.executeQuery(from);

            LinkedList<String> result =  new LinkedList<>();
            while(resultSet.next()){
                for(int i = 1; i <resultSet.getMetaData().getColumnCount(); i++){
                    result.add(resultSet.getString(i));
                }
            }
            return result;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"La exception lanzada es: "+ e.getMessage());    
            return null;
        }       
        
    }
    
    public boolean agregarUsuario(String login, String nombre, String apellido,
            String contrasena, String privilegios)
    {
        try
        {
            Statement st = conn();
            String sql = "insert into usuarios values('"+login+"','"+nombre+"','"+apellido+"','"
                    +contrasena+"','"+privilegios+"')";
            st.execute(sql);
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"La exception lanzada es: "+ e.getMessage());    
            return false;
        }       
        
    }
    
    
    
    
}


