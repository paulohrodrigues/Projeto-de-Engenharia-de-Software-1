package controllers;

import java.util.ArrayList;
import models.Questaoaberta;
import models.Questaofechada;

public class QuestaoFechadaController extends QuestaoController {

	private String correta;
	
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;


	public QuestaoFechadaController(
			String enunciado,
			String correta, 
			String alternativaA,
			String alternativaB,
			String alternativaC,
			String alternativaD
	) {
		
		this.correta=correta;
		this.alternativaA=alternativaA;
		this.alternativaB=alternativaB;
		this.alternativaC=alternativaC;
		this.alternativaD=alternativaD;
                super.setEnunciado(enunciado);
	}

    @Override
    public boolean cadastrar() {
        try{
            this.inicialize();

            models.Questao q = new models.Questao();
            q.setEnunciado(this.getEnunciado());
            q.setUsuarioId(AutenticacaoController.getInstance().getUsuario());
            
            Questaofechada d = new Questaofechada();
            d.setA(alternativaA);
            d.setB(alternativaB);
            d.setC(alternativaC);
            d.setD(alternativaD);
            d.setAlternativacerta(correta);
            d.setQuestaoId(q);
            this.add(q);
            this.add(d);
            this.save();
            return true;
        }catch(Exception e ){
            return false;
        }
    }

}
