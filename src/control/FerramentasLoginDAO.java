
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
        String instrucaoSQL = "select name , senha from aluno";
   
    public void creat(User u){
        
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO aluno(numMatricula,name,senha\n" +
            ",cpf ,curso,turma, modulo, email, telefone)VALUES(?,?,?,?,?,?,?,?,?)");
            
            stmt.setInt(1, u.getNumMatricula());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getCpf());
            stmt.setString(5, u.getCurso());
            stmt.setInt(6, u.getTurma());
            stmt.setInt(7, u.getModulo());
            stmt.setString(8, u.getEmail());
            stmt.setInt(9, u.getTelefone());
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "cadastor salvo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null ,"erro ao cadastrar" + ex);
        }finally{
            ConnectFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
        
    }
        
    public boolean getLogin(String nome , String senha) {
            boolean name = false ;
            try {
                Class.forName(DRIVER);
                conexao = ConnectFactory.getConnection();
                st = conexao.createStatement();
                rs = st.executeQuery(instrucaoSQL);
                while(rs.next()){
                    if(nome.equals(rs.getString(1)) && senha.equals(rs.getString(2))){
                        name = true;
                    }
                }
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FerramentasLoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return name;
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
