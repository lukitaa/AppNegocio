/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Forms;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author usuario
 */
@Embeddable
public class ProductosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IdProducto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "IdProveedor")
    private int idProveedor;

    public ProductosPK() {
    }

    public ProductosPK(int idProducto, int idProveedor) {
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idProveedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosPK)) {
            return false;
        }
        ProductosPK other = (ProductosPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idProveedor != other.idProveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Forms.ProductosPK[ idProducto=" + idProducto + ", idProveedor=" + idProveedor + " ]";
    }
    
}
