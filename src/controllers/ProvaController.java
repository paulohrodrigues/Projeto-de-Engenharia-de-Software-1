package controllers;

import java.util.ArrayList;

import java.util.List;
import models.Prova;
import models.Questao;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import models.Disciplina;

public class ProvaController extends Controller{

	private String titulo;

	private models.Disciplina disciplina;

	private ArrayList<models.Questao> questoes;
	
	public void Prova(Date dataDeCriacao, String titulo, DisciplinaController disciplina, ArrayList<QuestaoController> questao) {

	}

	public void exportarParaPDF(String id) throws Exception {
            em.clear();
            
            if(id.trim().equals("")){
                throw new Exception();
               // return ;
            }
            try {
                ArrayList<String> keys=new ArrayList();
                keys.add("id");
                ArrayList<String> values=new ArrayList();
                values.add(id);
                
                List<Prova> listaDeProvas = this.buscar("Prova.findById", keys, values);
                if(listaDeProvas.size()<=0){
                    throw new Exception();
                }
                
                Document document = new Document();
                Date d = new Date();
                Calendar cal = new GregorianCalendar();
                cal.setTime(d);
                
                PdfWriter.getInstance(document, new FileOutputStream("./"+id+"_"+cal.getTimeInMillis()+".pdf"));
                document.open();

                // adicionando um parágrafo no documento
                document.add(new Paragraph("UFAL - Prova Gerada Pelo Software Gerenciador de provas GPDocs"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(getTitulo()));
                
                document.add(new Paragraph(listaDeProvas.get(0).getTitulo()));
                document.add(new Paragraph("Professor: "+AutenticacaoController.getInstance().getUsuario().getNome()));
                document.add(new Paragraph("Aluno(a):______________________________________________"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                
                Collection<Questao> questoesLocal = listaDeProvas.get(0).getQuestaoCollection();
                
                int i =0;
                for(Questao q: questoesLocal){
                    i++;
                    //System.out.println(i+")"+q.getEnunciado());
                    document.add(new Paragraph(i+"º) "+q.getEnunciado()));
//                    for(models.Questaoaberta qa: q.getQuestaoabertaCollection()){
//                        //System.out.println(qa.getRespostaguia());
//                    }
                    for(models.Questaofechada qf:q.getQuestaofechadaCollection()){
                        System.out.println("Teste");
                        document.add(new Paragraph("(  ) "+qf.getA()));
                        document.add(new Paragraph("(  ) "+qf.getB()));
                        document.add(new Paragraph("(  ) "+qf.getC()));
                        document.add(new Paragraph("(  ) "+qf.getD()));
                        document.add(new Paragraph(" "));
                    }
                }
                 
                document.close();

                document = new Document();


                PdfWriter.getInstance(document, new FileOutputStream("./"+id+"_"+cal.getTimeInMillis()+"resposta.pdf"));
                document.open();

                // adicionando um parágrafo no documento
                document.add(new Paragraph("UFAL - Prova Gerada Pelo Software Gerenciador de provas GPDocs"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(getTitulo()));

                document.add(new Paragraph(listaDeProvas.get(0).getTitulo()));
                document.add(new Paragraph("Professor: "+AutenticacaoController.getInstance().getUsuario().getNome()));
                document.add(new Paragraph("RESPOSTAS"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));

                Collection<Questao> questoesLocalR = listaDeProvas.get(0).getQuestaoCollection();

                i =0;
                for(Questao q: questoesLocalR){
                    i++;
                    //System.out.println(i+")"+q.getEnunciado());
                    document.add(new Paragraph(i+"º) "+q.getEnunciado()));
                    if(q.getQuestaoabertaCollection().size()>0){
                        for(models.Questaoaberta qa: q.getQuestaoabertaCollection()){
                            //System.out.println();
                            document.add(new Paragraph("R: "+ qa.getRespostaguia()));
                            document.add(new Paragraph(" "));
                        }
                    }
                    q.getQuestaofechadaCollection();
                    for(models.Questaofechada qf:q.getQuestaofechadaCollection()){
                        System.out.println("Teste");
                        document.add(new Paragraph("R: "+qf.getAlternativacerta()));
                        document.add(new Paragraph(" "));
                        break;
                    }
                }

                document.close();
            
            
            
            }catch(DocumentException de) {
                throw new Exception();
            }
            catch(IOException ioe) {
                
                throw new Exception();
            }
            
	}

//	public void exportarParaDOC() {
//
//	}

	public boolean cadastrar() {
            try{
                this.inicialize();
                models.Prova p = new models.Prova();
                models.Disciplina d = getDisciplina();
                ArrayList<models.Questao> ld=getQuestoes();
                p.setTitulo(getTitulo());
                p.setDisciplinaId(d);
                p.setQuestaoCollection((List)ld);
                p.setUsuarioId(AutenticacaoController.getInstance().getUsuario());
                em.persist(p);
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                return false;
            }
	}
        
        
        public void deletar(int id) {
            inicialize();
            Prova objeto = em.find(Prova.class,id);
            em.remove(objeto);
            save();
          
	}
        
        
        public List<Prova> buscar(String tipo,ArrayList<String> keys,ArrayList<String> values) {
            
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
           
           
            List<Prova>  l = (List<Prova>) (Object) find(tipo, Prova.class, parametros, val);
            ArrayList<Prova>  listaFinal = new ArrayList<>();
            for(Prova ll : l){
                if(ll.getUsuarioId().getId()==AutenticacaoController.getInstance().getUsuario().getId()){
                     listaFinal.add(ll);
                }
            }
            return listaFinal;
	}

	public void atualizar() {

	}

	public void deletar() {

	}

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the disciplina
     */
    public models.Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(models.Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the questoes
     */
    public ArrayList<models.Questao> getQuestoes() {
        return questoes;
    }

    /**
     * @param questoes the questoes to set
     */
    public void setQuestoes(ArrayList<models.Questao> questoes) {
        this.questoes = questoes;
    }
}
