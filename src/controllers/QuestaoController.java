package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import models.Disciplina;
import models.Prova;
import models.Questao;
import models.Questaoaberta;

public class QuestaoController extends Controller{

	private String enunciado;
        protected String respostaGuia;
        

        public boolean cadastrar() {
            try{
                this.inicialize();

                models.Questao q = new models.Questao();
                q.setEnunciado(this.getEnunciado());
                q.setUsuarioId(AutenticacaoController.getInstance().getUsuario());
                Questaoaberta d = new Questaoaberta();
                d.setRespostaguia(respostaGuia);
                d.setQuestaoId(q);
                this.add(q);
                this.add(d);
                this.save();
                return true;
            }catch(Exception e ){
                return false;
            }
        }

	public void atualizar() {

	}
        
        public List<Questao> buscar(String tipo,ArrayList<String> keys,ArrayList<String> values) {
            
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
           
          List<Questao>  l = (List<Questao>) (Object) find(tipo, Questao.class, parametros, val);
            ArrayList<Questao>  listaFinal = new ArrayList<>();
            for(Questao ll : l){
                if(ll.getUsuarioId().getId()==AutenticacaoController.getInstance().getUsuario().getId()){
                     listaFinal.add(ll);
                }
            }
            return listaFinal;
	}

	public void deletar(int id) {
            //em.clear();
            inicialize();
            
            Questao objeto = em.find(Questao.class,id);
            em.remove(objeto);
            save();
          
	}
        

    /**
     * @return the enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * @param enunciado the enunciado to set
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

}
