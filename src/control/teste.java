
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno.schneider
 */
public class teste {
    
   
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String USER = "root";
    private static final String PASS = "vertrigo";
    String aa= "";
    Connection conexao = null;
    Statement st = null;
    ResultSet rs = null;
    
    public static void main(String[] args) {
        String aa= "";
        Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            st = conexao.createStatement();
            rs = st.executeQuery("Select * from log");
            
            while(rs.next()){
                System.out.println("----------------------");
                System.out.println("Name ;" + rs.getString(2));
                System.out.println("senha ;" + rs.getString(3));
                aa = rs.getString(2);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
