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
@Table(name = "transactions")
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByIdTransaction", query = "SELECT t FROM Transactions t WHERE t.idTransaction = :idTransaction"),
    @NamedQuery(name = "Transactions.findByTotal", query = "SELECT t FROM Transactions t WHERE t.total = :total"),
    @NamedQuery(name = "Transactions.findByTimeLimit", query = "SELECT t FROM Transactions t WHERE t.timeLimit = :timeLimit"),
    @NamedQuery(name = "Transactions.findByInterest", query = "SELECT t FROM Transactions t WHERE t.interest = :interest"),
    @NamedQuery(name = "Transactions.findByAtDate", query = "SELECT t FROM Transactions t WHERE t.atDate = :atDate")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransactionsPK transactionsPK;
    @Basic(optional = false)
    @Column(name = "id_transaction")
    private int idTransaction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "time_limit")
    private String timeLimit;
    @Column(name = "interest")
    private Double interest;
    @Column(name = "at_date")
    private Integer atDate;
    @JoinColumn(name = "id_affiliatedes", referencedColumnName = "id_affiliatedes")
    @ManyToOne(optional = false)
    private Affiliatedes idAffiliatedes;

    public Transactions() {
    }

    public Transactions(TransactionsPK transactionsPK) {
        this.transactionsPK = transactionsPK;
    }

    public Transactions(TransactionsPK transactionsPK, int idTransaction) {
        this.transactionsPK = transactionsPK;
        this.idTransaction = idTransaction;
    }

    public TransactionsPK getTransactionsPK() {
        return transactionsPK;
    }

    public void setTransactionsPK(TransactionsPK transactionsPK) {
        this.transactionsPK = transactionsPK;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getAtDate() {
        return atDate;
    }

    public void setAtDate(Integer atDate) {
        this.atDate = atDate;
    }

    public Affiliatedes getIdAffiliatedes() {
        return idAffiliatedes;
    }

    public void setIdAffiliatedes(Affiliatedes idAffiliatedes) {
        this.idAffiliatedes = idAffiliatedes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionsPK != null ? transactionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionsPK == null && other.transactionsPK != null) || (this.transactionsPK != null && !this.transactionsPK.equals(other.transactionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Transactions[ transactionsPK=" + transactionsPK + " ]";
    }
    
}
