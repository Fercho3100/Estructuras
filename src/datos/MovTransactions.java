/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author krudin
 */
@Entity
@Table(name = "mov_transactions")
@NamedQueries({
    @NamedQuery(name = "MovTransactions.findAll", query = "SELECT m FROM MovTransactions m"),
    @NamedQuery(name = "MovTransactions.findByIdMov", query = "SELECT m FROM MovTransactions m WHERE m.idMov = :idMov"),
    @NamedQuery(name = "MovTransactions.findByInterest", query = "SELECT m FROM MovTransactions m WHERE m.interest = :interest"),
    @NamedQuery(name = "MovTransactions.findByTotal", query = "SELECT m FROM MovTransactions m WHERE m.total = :total"),
    @NamedQuery(name = "MovTransactions.findByAtDate", query = "SELECT m FROM MovTransactions m WHERE m.atDate = :atDate")})
public class MovTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovTransactionsPK movTransactionsPK;
    @Basic(optional = false)
    @Column(name = "id_mov")
    private int idMov;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interest")
    private Double interest;
    @Column(name = "total")
    private Integer total;
    @Basic(optional = false)
    @Column(name = "at_date")
    private String atDate;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private Types idType;

    public MovTransactions() {
    }

    public MovTransactions(MovTransactionsPK movTransactionsPK) {
        this.movTransactionsPK = movTransactionsPK;
    }

    public MovTransactions(MovTransactionsPK movTransactionsPK, int idMov, String atDate) {
        this.movTransactionsPK = movTransactionsPK;
        this.idMov = idMov;
        this.atDate = atDate;
    }

    public MovTransactionsPK getMovTransactionsPK() {
        return movTransactionsPK;
    }

    public void setMovTransactionsPK(MovTransactionsPK movTransactionsPK) {
        this.movTransactionsPK = movTransactionsPK;
    }

    public int getIdMov() {
        return idMov;
    }

    public void setIdMov(int idMov) {
        this.idMov = idMov;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getAtDate() {
        return atDate;
    }

    public void setAtDate(String atDate) {
        this.atDate = atDate;
    }

    public Types getIdType() {
        return idType;
    }

    public void setIdType(Types idType) {
        this.idType = idType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movTransactionsPK != null ? movTransactionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovTransactions)) {
            return false;
        }
        MovTransactions other = (MovTransactions) object;
        if ((this.movTransactionsPK == null && other.movTransactionsPK != null) || (this.movTransactionsPK != null && !this.movTransactionsPK.equals(other.movTransactionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.MovTransactions[ movTransactionsPK=" + movTransactionsPK + " ]";
    }
    
}
