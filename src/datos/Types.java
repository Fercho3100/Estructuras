/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author krudin
 */
@Entity
@Table(name = "types")
@NamedQueries({
    @NamedQuery(name = "Types.findAll", query = "SELECT t FROM Types t"),
    @NamedQuery(name = "Types.findByIdType", query = "SELECT t FROM Types t WHERE t.idType = :idType"),
    @NamedQuery(name = "Types.findByName", query = "SELECT t FROM Types t WHERE t.name = :name")})
public class Types implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TypesPK typesPK;
    @Basic(optional = false)
    @Column(name = "id_type")
    private int idType;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType")
    private Collection<MovTransactions> movTransactionsCollection;

    public Types() {
    }

    public Types(TypesPK typesPK) {
        this.typesPK = typesPK;
    }

    public Types(TypesPK typesPK, int idType, String name) {
        this.typesPK = typesPK;
        this.idType = idType;
        this.name = name;
    }

    public TypesPK getTypesPK() {
        return typesPK;
    }

    public void setTypesPK(TypesPK typesPK) {
        this.typesPK = typesPK;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<MovTransactions> getMovTransactionsCollection() {
        return movTransactionsCollection;
    }

    public void setMovTransactionsCollection(Collection<MovTransactions> movTransactionsCollection) {
        this.movTransactionsCollection = movTransactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typesPK != null ? typesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Types)) {
            return false;
        }
        Types other = (Types) object;
        if ((this.typesPK == null && other.typesPK != null) || (this.typesPK != null && !this.typesPK.equals(other.typesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Types[ typesPK=" + typesPK + " ]";
    }
    
}
