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
@Table(name = "questaofechada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questaofechada.findAll", query = "SELECT q FROM Questaofechada q")
    , @NamedQuery(name = "Questaofechada.findById", query = "SELECT q FROM Questaofechada q WHERE q.id = :id")
    , @NamedQuery(name = "Questaofechada.findByA", query = "SELECT q FROM Questaofechada q WHERE q.a = :a")
    , @NamedQuery(name = "Questaofechada.findByB", query = "SELECT q FROM Questaofechada q WHERE q.b = :b")
    , @NamedQuery(name = "Questaofechada.findByC", query = "SELECT q FROM Questaofechada q WHERE q.c = :c")
    , @NamedQuery(name = "Questaofechada.findByD", query = "SELECT q FROM Questaofechada q WHERE q.d = :d")
    , @NamedQuery(name = "Questaofechada.findByAlternativacerta", query = "SELECT q FROM Questaofechada q WHERE q.alternativacerta = :alternativacerta")})
public class Questaofechada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "a")
    private String a;
    @Column(name = "b")
    private String b;
    @Column(name = "c")
    private String c;
    @Column(name = "d")
    private String d;
    @Column(name = "alternativacerta")
    private String alternativacerta;
    @JoinColumn(name = "questao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Questao questaoId;

    public Questaofechada() {
    }

    public Questaofechada(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAlternativacerta() {
        return alternativacerta;
    }

    public void setAlternativacerta(String alternativacerta) {
        this.alternativacerta = alternativacerta;
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
        if (!(object instanceof Questaofechada)) {
            return false;
        }
        Questaofechada other = (Questaofechada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Questaofechada[ id=" + id + " ]";
    }
    
}
