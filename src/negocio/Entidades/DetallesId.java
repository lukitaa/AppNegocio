package negocio.Entidades;
// Generated 15/10/2014 10:44:15 by Hibernate Tools 4.3.1



/**
 * DetallesId generated by hbm2java
 */
public class DetallesId  implements java.io.Serializable {


     private int idDetalle;
     private int idProducto;
     private int idCompra;

    public DetallesId() {
    }

    public DetallesId(int idDetalle, int idProducto, int idCompra) {
       this.idDetalle = idDetalle;
       this.idProducto = idProducto;
       this.idCompra = idCompra;
    }
   
    public int getIdDetalle() {
        return this.idDetalle;
    }
    
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public int getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetallesId) ) return false;
		 DetallesId castOther = ( DetallesId ) other; 
         
		 return (this.getIdDetalle()==castOther.getIdDetalle())
 && (this.getIdProducto()==castOther.getIdProducto())
 && (this.getIdCompra()==castOther.getIdCompra());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdDetalle();
         result = 37 * result + this.getIdProducto();
         result = 37 * result + this.getIdCompra();
         return result;
   }   


}


