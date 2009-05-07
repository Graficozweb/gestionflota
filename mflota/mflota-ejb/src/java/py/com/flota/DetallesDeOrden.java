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
@Table(name = "detalles_de_orden")
@NamedQueries({@NamedQuery(name = "DetallesDeOrden.findAll", query = "SELECT d FROM DetallesDeOrden d"), @NamedQuery(name = "DetallesDeOrden.findById", query = "SELECT d FROM DetallesDeOrden d WHERE d.id = :id"), @NamedQuery(name = "DetallesDeOrden.findByDetalles", query = "SELECT d FROM DetallesDeOrden d WHERE d.detalles = :detalles"), @NamedQuery(name = "DetallesDeOrden.findByEstado", query = "SELECT d FROM DetallesDeOrden d WHERE d.estado = :estado")})
public class DetallesDeOrden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "detalles")
    private String detalles;
    @Basic(optional = false)
    @Column(name = "estado")
    private char estado;
    @JoinColumn(name = "mantenimiento_preventivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MantenimientoPreventivo mantenimientoPreventivoId;
    @JoinColumn(name = "orden_de_mantenimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrdenDeMantenimiento ordenDeMantenimientoId;

    public DetallesDeOrden() {
    }

    public DetallesDeOrden(Integer id) {
        this.id = id;
    }

    public DetallesDeOrden(Integer id, String detalles, char estado) {
        this.id = id;
        this.detalles = detalles;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public MantenimientoPreventivo getMantenimientoPreventivoId() {
        return mantenimientoPreventivoId;
    }

    public void setMantenimientoPreventivoId(MantenimientoPreventivo mantenimientoPreventivoId) {
        this.mantenimientoPreventivoId = mantenimientoPreventivoId;
    }

    public OrdenDeMantenimiento getOrdenDeMantenimientoId() {
        return ordenDeMantenimientoId;
    }

    public void setOrdenDeMantenimientoId(OrdenDeMantenimiento ordenDeMantenimientoId) {
        this.ordenDeMantenimientoId = ordenDeMantenimientoId;
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
        if (!(object instanceof DetallesDeOrden)) {
            return false;
        }
        DetallesDeOrden other = (DetallesDeOrden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.DetallesDeOrden[id=" + id + "]";
    }

}
