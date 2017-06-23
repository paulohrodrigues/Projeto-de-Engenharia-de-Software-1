package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Prova;
import models.Questaoaberta;
import models.Questaofechada;
import models.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-23T11:42:34")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile CollectionAttribute<Questao, Prova> provaCollection;
    public static volatile CollectionAttribute<Questao, Questaoaberta> questaoabertaCollection;
    public static volatile SingularAttribute<Questao, String> enunciado;
    public static volatile CollectionAttribute<Questao, Questaofechada> questaofechadaCollection;
    public static volatile SingularAttribute<Questao, Integer> id;
    public static volatile SingularAttribute<Questao, Usuario> usuarioId;

}