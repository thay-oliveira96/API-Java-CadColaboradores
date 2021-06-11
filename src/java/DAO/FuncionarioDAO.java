/*
Nome:Thaynan Rodrigues de Oliveira      RGM: 11191102746
Nome: Vinicius Gonzales Egidio          RGM: 11191101856
Materia: Sistema da Informação          Turma: 5SIB
Materia: Sistemas Distribuidos e Padrões de Projetos Orientado a Objeto
 */
package DAO;
import Model.Funcionario;
import util.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nicolas
 */
public class FuncionarioDAO {
    
        
    public void cadastrar(Funcionario f) throws ClassNotFoundException, SQLException{

        Connection con = Conexao.getConexao(); 


        PreparedStatement comando = con.prepareStatement("insert into colaborador (nome, rg, endereco, telefone, departamento) values (?,?,?,?,?)");
        comando.setString(1, f.getNome() );
        comando.setString(2,f.getRg());
        comando.setString(3,f.getEndereco());
        comando.setString(4, f.getTelefone());
        comando.setString(5, f.getDepartamento());
        

        comando.execute();

        con.close();
    }
    
    public void remover(Funcionario f) throws ClassNotFoundException, SQLException{

        Connection con = Conexao.getConexao(); 


        PreparedStatement comando = con.prepareStatement("delete from colaborador where id=?");
        comando.setInt(1, f.getId());
        
        
        comando.execute();
        
        con.close();
    }
    
    public Funcionario consultarById(Funcionario f)throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("select id, nome, rg, endereco, telefone, departamento from colaborador where id = ?");
        comando.setInt(1,f.getId());
        
        ResultSet resultado = comando.executeQuery();
        Funcionario funcionario = new Funcionario();
        if(resultado.next()){
            funcionario.setId(resultado.getInt("id"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setRg(resultado.getString("rg"));
            funcionario.setEndereco(resultado.getString("endereco"));
            funcionario.setTelefone(resultado.getString("telefone"));
            funcionario.setDepartamento(resultado.getString("departamento"));
        }
        
        return funcionario;
        
    }
    
    public List<Funcionario> ConsultarTodos()throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
        
        //PreparedStatement comando = con.prepareStatement("select * from colaborador");
        PreparedStatement comando = con.prepareStatement("select id, nome, rg, endereco, telefone, departamento from colaborador order by id asc");
        
        
        ResultSet resultado = comando.executeQuery();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        while(resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setId(resultado.getInt("id"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setRg(resultado.getString("rg"));
            funcionario.setEndereco(resultado.getString("endereco"));
            funcionario.setTelefone(resultado.getString("telefone"));
            funcionario.setDepartamento(resultado.getString("departamento"));
            listaFuncionario.add(funcionario);
        }
        
        
        
        return listaFuncionario;
    }
    
    public List<Funcionario> pesquisar(Funcionario f)throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("select id, nome, rg, endereco, telefone, departamento from colaborador where titulo like ? order by id asc");
        comando.setString(1, f.getPesq());
        
        ResultSet resultado = comando.executeQuery();
        List listaFuncionario = new ArrayList();
        while(resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setId(resultado.getInt("id"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setRg(resultado.getString("rg"));
            funcionario.setEndereco(resultado.getString("endereco"));
            funcionario.setTelefone(resultado.getString("telefone"));
            funcionario.setDepartamento(resultado.getString("departamento"));
            listaFuncionario.add(funcionario);
            
        }
        
        
        
        return listaFuncionario;
    }
    
    public void alterar(Funcionario f) throws ClassNotFoundException, SQLException{

        try (Connection con = Conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("update colaborador set nome = ?, rg = ?, endereco = ?, telefone = ?, departamento = ? where id = ?");
            comando.setString(1, f.getNome() );
            comando.setString(2,f.getRg());
            comando.setString(3,f.getEndereco() );
            comando.setString(4, f.getTelefone());
            comando.setString(5, f.getDepartamento());
            comando.setInt(6,f.getId());
            
            comando.execute();
        }
    }
    
    
    
    public List<Funcionario> consultarTodos() throws ClassNotFoundException, SQLException {
        //Carregar Driver  e criar conexao
        Connection con = Conexao.getConexao();

        //contruir string sql bem formada e vinculada com a conexao
        String sql = "select * from colaborador";
        PreparedStatement comando = con.prepareStatement(sql);

        //executar e tratar resultados
        ResultSet resultado = comando.executeQuery();
        
        
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        while (resultado.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(resultado.getInt("id"));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setRg(resultado.getString("rg"));
            funcionario.setEndereco(resultado.getString("endereco"));
            funcionario.setTelefone(resultado.getString("telefone"));
            funcionario.setDepartamento(resultado.getString("departamento"));
            listaFuncionario.add(funcionario);
        }

        //Fecha conexao
        con.close();
        return listaFuncionario;
    }
}