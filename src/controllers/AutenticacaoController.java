package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Usuario;

public class AutenticacaoController extends Controller{

	private String loginUsuario;
	private static AutenticacaoController autenticacao;
	private String senha;
	private Usuario usuario=null;
	public AutenticacaoController(){
		
	}
	public static AutenticacaoController getInstance(){
		if(autenticacao==null){
			autenticacao=new AutenticacaoController();
		}
		return autenticacao;
	}
	
	public boolean login(String loginUsuario, String senha) {
            
//           UsuarioController u = new UsuarioController(loginUsuario,null,null,senha);
           //List<Usuario>  l = u.busca("Usuario.findByLoginSenha");
           
           ArrayList<String> parametros = new ArrayList<>();
           parametros.add("login");
           parametros.add("senha");
           ArrayList values = new ArrayList();
           values.add(loginUsuario);
           values.add(senha);
          
           List<Object>  l = find("Usuario.findByLoginSenha", Usuario.class, parametros, values);
           
//           for(Usuario ll : l){
//               System.out.println(ll.getQuestaoCollection());
//           }
           if(l.size()<=0){
               System.out.println("Não logou");
               return false;
           }else{
               this.usuario = (Usuario) l.get(0);
               return true;
           }
           
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void sair() {
		this.usuario=null;
	}

}
