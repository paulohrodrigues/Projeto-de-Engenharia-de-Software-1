/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Disciplina;
import models.Usuario;

/**
 *
 * @author Paulo Henrique
 */
public class Controller {
    
    protected EntityManager em;
    protected EntityManagerFactory emf;

     public Controller() {
        inicialize();
    }
    public void inicialize(){
        emf=Persistence.createEntityManagerFactory("ProjetoPU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void add(Serializable o){
        em.persist(o);
        
    }
    public void save(){
        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }
   
    
    public List<Object> find(String busca,Class classe,List<String> parametros,List values){
        TypedQuery lista = em.createNamedQuery(busca,classe);
        
        int i=0;
        for(String parametro : parametros){
            try{
                lista = lista.setParameter(parametro,values.get(i));
            }catch(IllegalArgumentException e){
                Integer valor  = Integer.parseInt(values.get(i).toString());
                lista=lista.setParameter(parametro,valor);
            }
            i++;
        }
        
        return lista.getResultList();
    }
    
    
}