/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paulo Henrique
 */
@Entity
@Table(name = "questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q")
    , @NamedQuery(name = "Questao.findById", query = "SELECT q FROM Questao q WHERE q.id = :id")
    , @NamedQuery(name = "Questao.findByEnunciado", query = "SELECT q FROM Questao q WHERE q.enunciado = :enunciado")
    , @NamedQuery(name = "Questao.findByEnunciadoLike", query = "SELECT q FROM Questao q WHERE q.enunciado LIKE :enunciado")})
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "enunciado")
    private String enunciado;
    @ManyToMany(mappedBy = "questaoCollection")
    private Collection<Prova> provaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questaoId")
    private Collection<Questaofechada> questaofechadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questaoId")
    private Collection<Questaoaberta> questaoabertaCollection;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Questao() {
    }

    public Questao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @XmlTransient
    public Collection<Prova> getProvaCollection() {
        return provaCollection;
    }

    public void setProvaCollection(Collection<Prova> provaCollection) {
        this.provaCollection = provaCollection;
    }

    @XmlTransient
    public Collection<Questaofechada> getQuestaofechadaCollection() {
        return questaofechadaCollection;
    }

    public void setQuestaofechadaCollection(Collection<Questaofechada> questaofechadaCollection) {
        this.questaofechadaCollection = questaofechadaCollection;
    }

    @XmlTransient
    public Collection<Questaoaberta> getQuestaoabertaCollection() {
        return questaoabertaCollection;
    }

    public void setQuestaoabertaCollection(Collection<Questaoaberta> questaoabertaCollection) {
        this.questaoabertaCollection = questaoabertaCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Questao[ id=" + id + " ]";
    }
    
}
