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
@Table(name = "mantenimiento_preventivo")
@NamedQueries({@NamedQuery(name = "MantenimientoPreventivo.findAll", query = "SELECT m FROM MantenimientoPreventivo m"), @NamedQuery(name = "MantenimientoPreventivo.findById", query = "SELECT m FROM MantenimientoPreventivo m WHERE m.id = :id"), @NamedQuery(name = "MantenimientoPreventivo.findByDescripcion", query = "SELECT m FROM MantenimientoPreventivo m WHERE m.descripcion = :descripcion"), @NamedQuery(name = "MantenimientoPreventivo.findByKmDeEjecucion", query = "SELECT m FROM MantenimientoPreventivo m WHERE m.kmDeEjecucion = :kmDeEjecucion"), @NamedQuery(name = "MantenimientoPreventivo.findByCostoManoObra", query = "SELECT m FROM MantenimientoPreventivo m WHERE m.costoManoObra = :costoManoObra")})
public class MantenimientoPreventivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "km_de_ejecucion")
    private int kmDeEjecucion;
    @Basic(optional = false)
    @Column(name = "costo_mano_obra")
    private int costoManoObra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientoPreventivoId")
    private List<DetallesDeOrden> detallesDeOrdenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientoPreventivoId")
    private List<MantenimientoPreventivoHasInsumos> mantenimientoPreventivoHasInsumosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientoPreventivoId")
    private List<ModeloDeMantenimientoHasMantenimientoPreventivo> modeloDeMantenimientoHasMantenimientoPreventivoCollection;

    public MantenimientoPreventivo() {
    }

    public MantenimientoPreventivo(Integer id) {
        this.id = id;
    }

    public MantenimientoPreventivo(Integer id, String descripcion, int kmDeEjecucion, int costoManoObra) {
        this.id = id;
        this.descripcion = descripcion;
        this.kmDeEjecucion = kmDeEjecucion;
        this.costoManoObra = costoManoObra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getKmDeEjecucion() {
        return kmDeEjecucion;
    }

    public void setKmDeEjecucion(int kmDeEjecucion) {
        this.kmDeEjecucion = kmDeEjecucion;
    }

    public int getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(int costoManoObra) {
        this.costoManoObra = costoManoObra;
    }

    public List<DetallesDeOrden> getDetallesDeOrdenCollection() {
        return detallesDeOrdenCollection;
    }

    public void setDetallesDeOrdenCollection(List<DetallesDeOrden> detallesDeOrdenCollection) {
        this.detallesDeOrdenCollection = detallesDeOrdenCollection;
    }

    public List<MantenimientoPreventivoHasInsumos> getMantenimientoPreventivoHasInsumosCollection() {
        return mantenimientoPreventivoHasInsumosCollection;
    }

    public void setMantenimientoPreventivoHasInsumosCollection(List<MantenimientoPreventivoHasInsumos> mantenimientoPreventivoHasInsumosCollection) {
        this.mantenimientoPreventivoHasInsumosCollection = mantenimientoPreventivoHasInsumosCollection;
    }

    public List<ModeloDeMantenimientoHasMantenimientoPreventivo> getModeloDeMantenimientoHasMantenimientoPreventivoCollection() {
        return modeloDeMantenimientoHasMantenimientoPreventivoCollection;
    }

    public void setModeloDeMantenimientoHasMantenimientoPreventivoCollection(List<ModeloDeMantenimientoHasMantenimientoPreventivo> modeloDeMantenimientoHasMantenimientoPreventivoCollection) {
        this.modeloDeMantenimientoHasMantenimientoPreventivoCollection = modeloDeMantenimientoHasMantenimientoPreventivoCollection;
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
        if (!(object instanceof MantenimientoPreventivo)) {
            return false;
        }
        MantenimientoPreventivo other = (MantenimientoPreventivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.MantenimientoPreventivo[id=" + id + "]";
    }

}
