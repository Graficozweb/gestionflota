/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.flota;

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

/**
 *
 * @author Aditardo
 */
@Entity
@Table(name = "detalles_de_orden_has_insumos")
@NamedQueries({@NamedQuery(name = "DetallesDeOrdenHasInsumos.findAll", query = "SELECT d FROM DetallesDeOrdenHasInsumos d"), @NamedQuery(name = "DetallesDeOrdenHasInsumos.findById", query = "SELECT d FROM DetallesDeOrdenHasInsumos d WHERE d.id = :id")})
public class DetallesDeOrdenHasInsumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "insumos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Insumos insumosId;
    @JoinColumn(name = "orden_de_mantenimiento_de_mantenimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrdenDeMantenimiento ordenDeMantenimientoDeMantenimientoId;

    public DetallesDeOrdenHasInsumos() {
    }

    public DetallesDeOrdenHasInsumos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Insumos getInsumosId() {
        return insumosId;
    }

    public void setInsumosId(Insumos insumosId) {
        this.insumosId = insumosId;
    }

    public OrdenDeMantenimiento getOrdenDeMantenimientoDeMantenimientoId() {
        return ordenDeMantenimientoDeMantenimientoId;
    }

    public void setOrdenDeMantenimientoDeMantenimientoId(OrdenDeMantenimiento ordenDeMantenimientoDeMantenimientoId) {
        this.ordenDeMantenimientoDeMantenimientoId = ordenDeMantenimientoDeMantenimientoId;
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
        if (!(object instanceof DetallesDeOrdenHasInsumos)) {
            return false;
        }
        DetallesDeOrdenHasInsumos other = (DetallesDeOrdenHasInsumos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.DetallesDeOrdenHasInsumos[id=" + id + "]";
    }

}
