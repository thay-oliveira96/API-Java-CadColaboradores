/*
Nome:Thaynan Rodrigues de Oliveira      RGM: 11191102746
Nome: Vinicius Gonzales Egidio          RGM: 11191101856
Materia: Sistema da Informação          Turma: 5SIB
Materia: Sistemas Distribuidos e Padrões de Projetos Orientado a Objeto
 */
package ws;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Thaynan
 */
@Path("generic")
public class WSFuncionario {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSFuncionario
     */
    public WSFuncionario() {
    }

    /**
     * Retrieves representation of an instance of ws.WSFuncionario
     * @return an instance of java.lang.String
     */
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/funcionario/get/{id}")
    public String getFuncionario(@PathParam("id")int id) throws ClassNotFoundException{
        Funcionario f = new Funcionario();
        f.setId(id);
        
        FuncionarioDAO fdao = new FuncionarioDAO();
        
        try {
            f = fdao.consultarById(f);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WSFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson g = new Gson();
        return g.toJson(f);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/funcionario")
    public String ConsultarTodos() {
        List<Funcionario> lfuncionario = new ArrayList<Funcionario>();

        FuncionarioDAO fdao = new FuncionarioDAO();

        try {
            lfuncionario = fdao.ConsultarTodos();
        } catch (ClassNotFoundException ex) {
            System.out.println("ECNF..: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ESQL..: " + ex.getMessage());
        }
        
        Gson g = new Gson();
        return g.toJson(lfuncionario);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/funcionario/cadastrar")
    public void cadastrar(String content) {
        Gson g = new Gson();
        Funcionario func = (Funcionario) g.fromJson(content, Funcionario.class);
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            fdao.cadastrar(func);
        } catch (ClassNotFoundException ex) {
            System.out.println("ECNF..: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ESQL..: " + ex.getMessage());
        }
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/funcionario/alterar")
    public void alterar(String content) {
        Gson g = new Gson();
        Funcionario func = (Funcionario) g.fromJson(content, Funcionario.class);
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            fdao.alterar(func);
        } catch (ClassNotFoundException ex) {
            System.out.println("ECNF..: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ESQL..: " + ex.getMessage());
        }
    }
    
    
    
    @DELETE
    @Path("/funcionario/deletar/{id}")
    public void deletarFunc(@PathParam("id") int id) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);

        FuncionarioDAO fdao = new FuncionarioDAO();

        try {
            fdao.remover(funcionario);
        } catch (ClassNotFoundException ex) {
            System.out.println("ECNF..: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ESQL..: " + ex.getMessage());
        }
    }
    
}
