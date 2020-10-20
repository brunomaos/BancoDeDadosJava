
package control;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;


/**
 *
 * @author bruno.schneider
 */
public class FerramentasLoginDAO {
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        Connection conexao = null;
        Connection con = ConnectFactory.getConnection();
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String instrucaoSQL = "Select * from log";
   
        public void creat(User u){
        
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO log (name , senha)VALUES(?,?)");
            stmt.setString(1, u.name);
            stmt.setString(2, u.senha);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "cadastor salvo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null ,"erro ao cadastrar" + ex);
        }finally{
            ConnectFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
        
    }
        
    public String getNameUser() {
            String name = null ;
            try {
                Class.forName(DRIVER);
                conexao = ConnectFactory.getConnection();
                st = conexao.createStatement();
                rs = st.executeQuery(instrucaoSQL);
                rs.next();
                name = rs.getString(2);
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FerramentasLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectFactory.closeConnection((com.mysql.jdbc.Connection) conexao, (PreparedStatement) st, rs);
            }
            return name;
    }
    
    public String getSenha(){
            String senha ="";
            try {
                Class.forName(DRIVER);
                conexao = ConnectFactory.getConnection();
                st = conexao.createStatement();
                rs = st.executeQuery(instrucaoSQL);
                rs.next();
                senha = rs.getString(3);
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FerramentasLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectFactory.closeConnection((com.mysql.jdbc.Connection) conexao, (PreparedStatement) st, rs);
            }
            return senha;
    }
    public void deletarTodosOsDados(){
            try {
                conexao = ConnectFactory.getConnection();
                st = conexao.createStatement();
                st.execute("truncate table log;");
            } catch (SQLException ex) {
                Logger.getLogger(FerramentasLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectFactory.closeConnection((com.mysql.jdbc.Connection) conexao, (PreparedStatement) st, rs);
            }
        
    }
    
    public void update(String name , String senha){
            try {
                String Mname = "update log set name = " +name;
                String mSenha = "update log set  =" + senha;
                conexao = ConnectFactory.getConnection();
                st = conexao.createStatement();
                st.executeUpdate("update log set name = BrunoMaus");
                st.executeUpdate("update log set senha = Gostoso");
            } catch (SQLException ex) {
                Logger.getLogger(FerramentasLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectFactory.closeConnection((com.mysql.jdbc.Connection) conexao, (PreparedStatement) st);
            }
        
    }
}
