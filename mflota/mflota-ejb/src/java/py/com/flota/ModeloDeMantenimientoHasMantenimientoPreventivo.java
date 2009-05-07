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
@Table(name = "modelo_de_mantenimiento_has_mantenimiento_preventivo")
@NamedQueries({@NamedQuery(name = "ModeloDeMantenimientoHasMantenimientoPreventivo.findAll", query = "SELECT m FROM ModeloDeMantenimientoHasMantenimientoPreventivo m"), @NamedQuery(name = "ModeloDeMantenimientoHasMantenimientoPreventivo.findById", query = "SELECT m FROM ModeloDeMantenimientoHasMantenimientoPreventivo m WHERE m.id = :id")})
public class ModeloDeMantenimientoHasMantenimientoPreventivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "mantenimiento_preventivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MantenimientoPreventivo mantenimientoPreventivoId;
    @JoinColumn(name = "modelo_de_mantenimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ModeloDeMantenimiento modeloDeMantenimientoId;

    public ModeloDeMantenimientoHasMantenimientoPreventivo() {
    }

    public ModeloDeMantenimientoHasMantenimientoPreventivo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MantenimientoPreventivo getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public void setMantenimientoPreventivoId(MantenimientoPreventivo mantenimientoPreventivoId) {
        this.mantenimientoPreventivoId = mantenimientoPreventivoId;
    }

    public ModeloDeMantenimiento getModeloDeMantenimientoId() {
        return modeloDeMantenimientoId;
    }

    public void setModeloDeMantenimientoId(ModeloDeMantenimiento modeloDeMantenimientoId) {
        this.modeloDeMantenimientoId = modeloDeMantenimientoId;
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
        if (!(object instanceof ModeloDeMantenimientoHasMantenimientoPreventivo)) {
            return false;
        }
        ModeloDeMantenimientoHasMantenimientoPreventivo other = (ModeloDeMantenimientoHasMantenimientoPreventivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.ModeloDeMantenimientoHasMantenimientoPreventivo[id=" + id + "]";
    }

}
