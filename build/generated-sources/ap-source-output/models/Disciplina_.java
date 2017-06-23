package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Prova;
import models.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-22T22:24:16")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile SingularAttribute<Disciplina, String> codigo;
    public static volatile CollectionAttribute<Disciplina, Prova> provaCollection;
    public static volatile SingularAttribute<Disciplina, String> nome;
    public static volatile SingularAttribute<Disciplina, Integer> id;
    public static volatile SingularAttribute<Disciplina, Usuario> usuarioId;

}