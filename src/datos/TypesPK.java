/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author krudin
 */
@Embeddable
public class TypesPK implements Serializable {

    public TypesPK() {
    }



    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypesPK)) {
            return false;
        }
        TypesPK other = (TypesPK) object;
        return true;
    }

    @Override
    public String toString() {
        return "datos.typesPK";
    }
    
}
