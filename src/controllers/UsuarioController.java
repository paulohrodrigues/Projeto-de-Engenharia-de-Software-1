package controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Usuario;

public class UsuarioController extends Controller{

	private String login;

	private String senha;

	private String nome;

	private String email;

	private ArrayList<ProvaController> prova;


        
	public UsuarioController(String login, String nome, String email,String senha) {
		this.login=login;
		this.nome=nome;
		this.email=email;
		this.senha=senha;
               
	}
        
        
        public boolean cadastrar() throws SQLException {
            Usuario u = new Usuario();
            u.setEmail(this.email);
            u.setLogin(this.login);
            u.setNome(this.nome);
            u.setSenha(this.senha);
            this.add(u);
            this.save();
            
            return true;
	}

        
        
        
	public void setSenha(String senha) {
		this.senha = senha;
	}

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the prova
     */
    public ArrayList<ProvaController> getProva() {
        return prova;
    }

    /**
     * @param prova the prova to set
     */
    public void setProva(ArrayList<ProvaController> prova) {
        this.prova = prova;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

}
