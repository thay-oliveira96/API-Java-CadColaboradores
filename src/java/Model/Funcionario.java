/*

Nome:Thaynan Rodrigues de Oliveira      RGM: 11191102746
Nome: Vinicius Gonzales Egidio          RGM: 11191101856
Materia: Sistema da Informação          Turma: 5SIB
Materia: Sistemas Distribuidos e Padrões de Projetos Orientado a Objeto

 */
package Model;

/**
 *
 * @author Thaynan
 */
public class Funcionario {
    private int id;
    private String pesq;
    private String nome;
    private String rg;
    private String endereco;
    private String telefone;
    private String departamento;

    public Funcionario() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String getPesq() {
        return pesq;
    }

    public void setPesq(String pesq) {
        this.pesq = pesq;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    public String getTelefone() {
        return telefone;
    }

   
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String getDepartamento() {
        return departamento;
    }

   
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
