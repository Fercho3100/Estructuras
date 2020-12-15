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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author krudin
 */
@Entity
@Table(name = "affiliatedes")
@NamedQueries({
    @NamedQuery(name = "Affiliatedes.findAll", query = "SELECT a FROM Affiliatedes a"),
    @NamedQuery(name = "Affiliatedes.findByIdAffiliatedes", query = "SELECT a FROM Affiliatedes a WHERE a.idAffiliatedes = :idAffiliatedes"),
    @NamedQuery(name = "Affiliatedes.findByUserCode", query = "SELECT a FROM Affiliatedes a WHERE a.userCode = :userCode"),
    @NamedQuery(name = "Affiliatedes.findByName", query = "SELECT a FROM Affiliatedes a WHERE a.name = :name"),
    @NamedQuery(name = "Affiliatedes.findByLastName", query = "SELECT a FROM Affiliatedes a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Affiliatedes.findByRol", query = "SELECT a FROM Affiliatedes a WHERE a.rol = :rol"),
    @NamedQuery(name = "Affiliatedes.findByGrossAmount", query = "SELECT a FROM Affiliatedes a WHERE a.grossAmount = :grossAmount"),
    @NamedQuery(name = "Affiliatedes.findByDateWork", query = "SELECT a FROM Affiliatedes a WHERE a.dateWork = :dateWork"),
    @NamedQuery(name = "Affiliatedes.findByDateToAsso", query = "SELECT a FROM Affiliatedes a WHERE a.dateToAsso = :dateToAsso"),
    @NamedQuery(name = "Affiliatedes.findByAdmin", query = "SELECT a FROM Affiliatedes a WHERE a.admin = :admin"),
    @NamedQuery(name = "Affiliatedes.findByPassword", query = "SELECT a FROM Affiliatedes a WHERE a.password = :password")})
public class Affiliatedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_affiliatedes")
    private Integer idAffiliatedes;
    @Basic(optional = false)
    @Column(name = "user_code")
    private int userCode;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "rol")
    private String rol;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gross_amount")
    private Double grossAmount;
    @Column(name = "date_work")
    private String dateWork;
    @Basic(optional = false)
    @Column(name = "date_to_asso")
    private String dateToAsso;
    @Basic(optional = false)
    @Column(name = "admin")
    private boolean admin;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAffiliatedes")
    private Collection<Transactions> transactionsCollection;

    public Affiliatedes() {
    }

    public Affiliatedes(Integer idAffiliatedes) {
        this.idAffiliatedes = idAffiliatedes;
    }

    public Affiliatedes(Integer idAffiliatedes, int userCode, String name, String lastName, String rol, double grossAmount, String dateWork, String dateToAsso, boolean admin, String password) {
        this.idAffiliatedes = idAffiliatedes;
        this.userCode = userCode;
        this.name = name;
        this.lastName = lastName;
        this.rol = rol;
        this.grossAmount = grossAmount;
        this.dateWork = dateWork;
        this.dateToAsso = dateToAsso;
        this.admin = admin;
        this.password = password;
    }

    public Integer getIdAffiliatedes() {
        return idAffiliatedes;
    }

    public void setIdAffiliatedes(Integer idAffiliatedes) {
        this.idAffiliatedes = idAffiliatedes;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getDateWork() {
        return dateWork;
    }

    public void setDateWork(String dateWork) {
        this.dateWork = dateWork;
    }

    public String getDateToAsso() {
        return dateToAsso;
    }

    public void setDateToAsso(String dateToAsso) {
        this.dateToAsso = dateToAsso;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAffiliatedes != null ? idAffiliatedes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affiliatedes)) {
            return false;
        }
        Affiliatedes other = (Affiliatedes) object;
        if ((this.idAffiliatedes == null && other.idAffiliatedes != null) || (this.idAffiliatedes != null && !this.idAffiliatedes.equals(other.idAffiliatedes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Affiliatedes[ idAffiliatedes=" + idAffiliatedes + " ]";
    }
    
}
