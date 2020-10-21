package model;

/**
 *
 * @author bruno.schneider
 */
public class User {
    private String name;
    private String senha;
    private int cpf;
    private int numMatricula;
    private String curso;
    private int turma;
    private int modulo;
    private String email;
    private int telefone;

    public User(String name, String senha, int cpf,
            int numMatricula, String curso, int turma,
            int modulo, String email, int telefone) {
        this.name = name;
        this.senha = senha;
        this.cpf = cpf;
        this.numMatricula = numMatricula;
        this.curso = curso;
        this.turma = turma;
        this.modulo = modulo;
        this.email = email;
        this.telefone = telefone;
    }

    public String getName() {
        return name;
    }

    public String getSenha() {
        return senha;
    }

    public int getCpf() {
        return cpf;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public int getTurma() {
        return turma;
    }

    public int getModulo() {
        return modulo;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefone() {
        return telefone;
    }

    
    
    
}
