/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.flota;

import java.io.Serializable;
import java.util.List;
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
 * @author Aditardo
 */
@Entity
@Table(name = "insumos")
@NamedQueries({@NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i"), @NamedQuery(name = "Insumos.findById", query = "SELECT i FROM Insumos i WHERE i.id = :id"), @NamedQuery(name = "Insumos.findByNombre", query = "SELECT i FROM Insumos i WHERE i.nombre = :nombre"), @NamedQuery(name = "Insumos.findByCosto", query = "SELECT i FROM Insumos i WHERE i.costo = :costo"), @NamedQuery(name = "Insumos.findByStock", query = "SELECT i FROM Insumos i WHERE i.stock = :stock"), @NamedQuery(name = "Insumos.findByDetalles", query = "SELECT i FROM Insumos i WHERE i.detalles = :detalles")})
public class Insumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "costo")
    private int costo;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
    @Column(name = "detalles")
    private String detalles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumosId")
    private List<MantenimientoPreventivoHasInsumos> mantenimientoPreventivoHasInsumosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumosId")
    private List<DetallesDeOrdenHasInsumos> detallesDeOrdenHasInsumosCollection;

    public Insumos() {
    }

    public Insumos(Integer id) {
        this.id = id;
    }

    public Insumos(Integer id, String nombre, int costo, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public List<MantenimientoPreventivoHasInsumos> getMantenimientoPreventivoHasInsumosCollection() {
        return mantenimientoPreventivoHasInsumosCollection;
    }

    public void setMantenimientoPreventivoHasInsumosCollection(List<MantenimientoPreventivoHasInsumos> mantenimientoPreventivoHasInsumosCollection) {
        this.mantenimientoPreventivoHasInsumosCollection = mantenimientoPreventivoHasInsumosCollection;
    }

    public List<DetallesDeOrdenHasInsumos> getDetallesDeOrdenHasInsumosCollection() {
        return detallesDeOrdenHasInsumosCollection;
    }

    public void setDetallesDeOrdenHasInsumosCollection(List<DetallesDeOrdenHasInsumos> detallesDeOrdenHasInsumosCollection) {
        this.detallesDeOrdenHasInsumosCollection = detallesDeOrdenHasInsumosCollection;
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
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.Insumos[id=" + id + "]";
    }

}
