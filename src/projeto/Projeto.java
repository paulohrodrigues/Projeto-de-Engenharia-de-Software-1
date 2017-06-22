/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import controllers.AutenticacaoController;
import controllers.QuestaoController;
import controllers.UsuarioController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Disciplina;
import models.Prova;
import models.Questao;
import models.Questaoaberta;
import models.Usuario;
import views.LoginCadastro;

/**
 *
 * @author Paulo Henrique
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
//        EntityManager em;
//        EntityManagerFactory emf;
//        emf=Persistence.createEntityManagerFactory("ProjetoPU");
//        em=emf.createEntityManager();
//        em.getTransaction().begin();
//        
//        models.Prova p =em.find(Prova.class,12);
//        
//        Collection<Questao> lista = p.getQuestaoCollection();
//        Questao a = null;
//        for(Questao q : lista){
//            a=q;
//            break;
//        }
//        System.out.println(a.toString());
//        AutenticacaoController l = AutenticacaoController.getInstance();
//        l.login("login","senha");
//    EntityManager em;
//    EntityManagerFactory emf;
//    emf=Persistence.createEntityManagerFactory("ProjetoPU");
//    em=emf.createEntityManager();
//    em.getTransaction().begin();
//    Disciplina objeto = em.find(Disciplina.class,1);
//    em.remove(objeto);
//    em.getTransaction().commit();
    
    
    
        LoginCadastro lc = new LoginCadastro();
        lc.setVisible(true);
        lc.setResizable(false);
        
        
        
        
//        EntityManager em;
//        EntityManagerFactory emf;
//        emf=Persistence.createEntityManagerFactory("ProjetoPU");
//        em=emf.createEntityManager();
//        em.getTransaction().begin();
//        
//        Usuario u = new Usuario();
//        u.setId(2);
//        
//        
//        
//        
//        
//        Questao q = new Questao();
//        q.setEnunciado("Teste");
//        q.setUsuarioId(u);
//        
//        Questaoaberta qa= new Questaoaberta();
//        qa.setRespostaguia("Essa é a resposta");
//        qa.setQuestaoId(q);
//        
////        ArrayList<Questaoaberta> lq = new ArrayList<>();
////        lq.add(qa);
////        q.setQuestaoabertaCollection(lq);
//        
//        
//        em.persist(q);
//        em.persist(qa);
//        em.getTransaction().commit();
        
        
       // new UsuarioController("login", "Nome", "Email", "Senha").cadastrar();
        
        
    }
    
}
