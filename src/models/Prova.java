/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paulo Henrique
 */
@Entity
@Table(name = "prova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prova.findAll", query = "SELECT p FROM Prova p")
    , @NamedQuery(name = "Prova.findById", query = "SELECT p FROM Prova p WHERE p.id = :id")
    , @NamedQuery(name = "Prova.findByTitulo", query = "SELECT p FROM Prova p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Prova.findByTituloLike", query = "SELECT p FROM Prova p WHERE p.titulo LIKE :titulo")})
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @JoinTable(name = "prova_has_questao", joinColumns = {
        @JoinColumn(name = "prova_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "questao_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Questao> questaoCollection;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Disciplina disciplinaId;

    public Prova() {
    }

    public Prova(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Collection<Questao> getQuestaoCollection() {
        return questaoCollection;
    }

    public void setQuestaoCollection(Collection<Questao> questaoCollection) {
        this.questaoCollection = questaoCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Disciplina getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Disciplina disciplinaId) {
        this.disciplinaId = disciplinaId;
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
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Prova[ id=" + id + " ]";
    }
    
}
