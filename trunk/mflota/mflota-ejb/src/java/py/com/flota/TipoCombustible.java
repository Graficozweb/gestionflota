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
@Table(name = "tipo_combustible")
@NamedQueries({@NamedQuery(name = "TipoCombustible.findAll", query = "SELECT t FROM TipoCombustible t"), @NamedQuery(name = "TipoCombustible.findById", query = "SELECT t FROM TipoCombustible t WHERE t.id = :id"), @NamedQuery(name = "TipoCombustible.findByTipo", query = "SELECT t FROM TipoCombustible t WHERE t.tipo = :tipo"), @NamedQuery(name = "TipoCombustible.findByDetalles", query = "SELECT t FROM TipoCombustible t WHERE t.detalles = :detalles")})
public class TipoCombustible implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "detalles")
    private String detalles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCombustibleId")
    private List<Vehiculo> vehiculoCollection;

    public TipoCombustible() {
    }

    public TipoCombustible(Integer id) {
        this.id = id;
    }

    public TipoCombustible(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public List<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(List<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
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
        if (!(object instanceof TipoCombustible)) {
            return false;
        }
        TipoCombustible other = (TipoCombustible) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.TipoCombustible[id=" + id + "]";
    }

}
