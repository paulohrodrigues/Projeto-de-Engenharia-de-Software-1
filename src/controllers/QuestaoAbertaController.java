package controllers;

import models.Disciplina;
import models.Questaoaberta;
public class QuestaoAbertaController extends QuestaoController {


	public QuestaoAbertaController(String respostaGuia,String enunciado) {
            this.respostaGuia=respostaGuia;
            super.setEnunciado(enunciado);
	}
    
      /**
     * @return the respostaGuia
     */
    public String getRespostaGuia() {
        return respostaGuia;
    }

    /**
     * @param respostaGuia the respostaGuia to set
     */
    public void setRespostaGuia(String respostaGuia) {
        this.respostaGuia = respostaGuia;
    }
    
    
}
