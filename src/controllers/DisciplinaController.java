package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Disciplina;
import models.Questao;
import models.Usuario;

public class DisciplinaController extends Controller{

	private String nome;

	private String codigo;

        public DisciplinaController() {

        }

	public boolean cadastrar() {
            try{
                this.inicialize();
                Disciplina d = new Disciplina();
                d.setCodigo(getCodigo());
                d.setNome(getNome());
                d.setUsuarioId(AutenticacaoController.getInstance().getUsuario());
                this.add(d);
                this.save();
                return true;
            }catch(Exception e ){
		return false;
            }
	}


	public void deletar(int id) {
            
          
            
            Disciplina objeto = em.find(Disciplina.class,id);
            em.remove(objeto);
            em.getTransaction().commit();

            
	}

        public List<Disciplina> buascar(String tipo,ArrayList<String> keys,ArrayList<String> values) {
            
           ArrayList<String> parametros = new ArrayList<>();
           if(keys!=null){
            keys.forEach((key) -> {
                parametros.add(key);
            });
            
           }
           
           ArrayList<String>  val = new ArrayList<>();
           if(values!=null){
            values.forEach((value) -> {
                val.add(value);
            });
            
           }
//           parametros.add("idUsuario");
//           val.add("5");
           
            List<Disciplina>  l = (List<Disciplina>) (Object) find(tipo, Disciplina.class, parametros, val);
            ArrayList<Disciplina>  listaFinal = new ArrayList<>();
            for(Disciplina ll : l){
                if(ll.getUsuarioId().getId()==AutenticacaoController.getInstance().getUsuario().getId()){
                     listaFinal.add(ll);
                }
            }
            return listaFinal;
	}
        
        
	public DisciplinaController(String nome, String codigo) {
		this.nome=nome;
		this.codigo=codigo;
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
