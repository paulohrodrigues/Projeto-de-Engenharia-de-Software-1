/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paulo Henrique
 */
@Entity
@Table(name = "questaoaberta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questaoaberta.findAll", query = "SELECT q FROM Questaoaberta q")
    , @NamedQuery(name = "Questaoaberta.findById", query = "SELECT q FROM Questaoaberta q WHERE q.id = :id")
    , @NamedQuery(name = "Questaoaberta.findByRespostaguia", query = "SELECT q FROM Questaoaberta q WHERE q.respostaguia = :respostaguia")})
public class Questaoaberta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "respostaguia")
    private String respostaguia;
    @JoinColumn(name = "questao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Questao questaoId;

    public Questaoaberta() {
    }

    public Questaoaberta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespostaguia() {
        return respostaguia;
    }

    public void setRespostaguia(String respostaguia) {
        this.respostaguia = respostaguia;
    }

    public Questao getQuestaoId() {
        return questaoId;
    }

    public void setQuestaoId(Questao questaoId) {
        this.questaoId = questaoId;
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
        if (!(object instanceof Questaoaberta)) {
            return false;
        }
        Questaoaberta other = (Questaoaberta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Questaoaberta[ id=" + id + " ]";
    }
    
}
