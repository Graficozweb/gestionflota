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
@Table(name = "mantenimiento_preventivo_has_insumos")
@NamedQueries({@NamedQuery(name = "MantenimientoPreventivoHasInsumos.findAll", query = "SELECT m FROM MantenimientoPreventivoHasInsumos m"), @NamedQuery(name = "MantenimientoPreventivoHasInsumos.findById", query = "SELECT m FROM MantenimientoPreventivoHasInsumos m WHERE m.id = :id")})
public class MantenimientoPreventivoHasInsumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "insumos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Insumos insumosId;
    @JoinColumn(name = "mantenimiento_preventivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MantenimientoPreventivo mantenimientoPreventivoId;

    public MantenimientoPreventivoHasInsumos() {
    }

    public MantenimientoPreventivoHasInsumos(Integer id) {
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

    public MantenimientoPreventivo getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public void setMantenimientoPreventivoId(MantenimientoPreventivo mantenimientoPreventivoId) {
        this.mantenimientoPreventivoId = mantenimientoPreventivoId;
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
        if (!(object instanceof MantenimientoPreventivoHasInsumos)) {
            return false;
        }
        MantenimientoPreventivoHasInsumos other = (MantenimientoPreventivoHasInsumos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.MantenimientoPreventivoHasInsumos[id=" + id + "]";
    }

}
