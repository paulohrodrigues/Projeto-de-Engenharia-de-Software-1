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
        
        LoginCadastro lc = new LoginCadastro();
        lc.setVisible(true);
        lc.setResizable(false);
        
    }
    
}
