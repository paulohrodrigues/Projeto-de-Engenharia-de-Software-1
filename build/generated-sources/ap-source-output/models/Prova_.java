package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Disciplina;
import models.Questao;
import models.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-22T22:24:16")
@StaticMetamodel(Prova.class)
public class Prova_ { 

    public static volatile SingularAttribute<Prova, Disciplina> disciplinaId;
    public static volatile SingularAttribute<Prova, String> titulo;
    public static volatile CollectionAttribute<Prova, Questao> questaoCollection;
    public static volatile SingularAttribute<Prova, Integer> id;
    public static volatile SingularAttribute<Prova, Usuario> usuarioId;

}