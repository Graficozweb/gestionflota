/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.flota;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aditardo
 */
@Entity
@Table(name = "orden_de_mantenimiento")
@NamedQueries({@NamedQuery(name = "OrdenDeMantenimiento.findAll", query = "SELECT o FROM OrdenDeMantenimiento o"), @NamedQuery(name = "OrdenDeMantenimiento.findById", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.id = :id"), @NamedQuery(name = "OrdenDeMantenimiento.findByVehiculoTipoCombustibleId", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.vehiculoTipoCombustibleId = :vehiculoTipoCombustibleId"), @NamedQuery(name = "OrdenDeMantenimiento.findByVehiculoTipoVehiculoId", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.vehiculoTipoVehiculoId = :vehiculoTipoVehiculoId"), @NamedQuery(name = "OrdenDeMantenimiento.findByVehiculoModeloDeMantenimientoId", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.vehiculoModeloDeMantenimientoId = :vehiculoModeloDeMantenimientoId"), @NamedQuery(name = "OrdenDeMantenimiento.findByDescripcion", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.descripcion = :descripcion"), @NamedQuery(name = "OrdenDeMantenimiento.findByCosto", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.costo = :costo"), @NamedQuery(name = "OrdenDeMantenimiento.findByFecha", query = "SELECT o FROM OrdenDeMantenimiento o WHERE o.fecha = :fecha")})
public class OrdenDeMantenimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "vehiculo_tipo_combustible_id")
    private int vehiculoTipoCombustibleId;
    @Basic(optional = false)
    @Column(name = "vehiculo_tipo_vehiculo_id")
    private int vehiculoTipoVehiculoId;
    @Basic(optional = false)
    @Column(name = "vehiculo_modelo_de_mantenimiento_id")
    private int vehiculoModeloDeMantenimientoId;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "costo")
    private int costo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "modelo_de_mantenimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ModeloDeMantenimiento modeloDeMantenimientoId;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenDeMantenimientoId")
    private List<DetallesDeOrden> detallesDeOrdenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenDeMantenimientoDeMantenimientoId")
    private List<DetallesDeOrdenHasInsumos> detallesDeOrdenHasInsumosCollection;

    public OrdenDeMantenimiento() {
    }

    public OrdenDeMantenimiento(Integer id) {
        this.id = id;
    }

    public OrdenDeMantenimiento(Integer id, int vehiculoTipoCombustibleId, int vehiculoTipoVehiculoId, int vehiculoModeloDeMantenimientoId, int costo) {
        this.id = id;
        this.vehiculoTipoCombustibleId = vehiculoTipoCombustibleId;
        this.vehiculoTipoVehiculoId = vehiculoTipoVehiculoId;
        this.vehiculoModeloDeMantenimientoId = vehiculoModeloDeMantenimientoId;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVehiculoTipoCombustibleId() {
        return vehiculoTipoCombustibleId;
    }

    public void setVehiculoTipoCombustibleId(int vehiculoTipoCombustibleId) {
        this.vehiculoTipoCombustibleId = vehiculoTipoCombustibleId;
    }

    public int getVehiculoTipoVehiculoId() {
        return vehiculoTipoVehiculoId;
    }

    public void setVehiculoTipoVehiculoId(int vehiculoTipoVehiculoId) {
        this.vehiculoTipoVehiculoId = vehiculoTipoVehiculoId;
    }

    public int getVehiculoModeloDeMantenimientoId() {
        return vehiculoModeloDeMantenimientoId;
    }

    public void setVehiculoModeloDeMantenimientoId(int vehiculoModeloDeMantenimientoId) {
        this.vehiculoModeloDeMantenimientoId = vehiculoModeloDeMantenimientoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ModeloDeMantenimiento getModeloDeMantenimientoId() {
        return modeloDeMantenimientoId;
    }

    public void setModeloDeMantenimientoId(ModeloDeMantenimiento modeloDeMantenimientoId) {
        this.modeloDeMantenimientoId = modeloDeMantenimientoId;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public List<DetallesDeOrden> getDetallesDeOrdenCollection() {
        return detallesDeOrdenCollection;
    }

    public void setDetallesDeOrdenCollection(List<DetallesDeOrden> detallesDeOrdenCollection) {
        this.detallesDeOrdenCollection = detallesDeOrdenCollection;
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
        if (!(object instanceof OrdenDeMantenimiento)) {
            return false;
        }
        OrdenDeMantenimiento other = (OrdenDeMantenimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.OrdenDeMantenimiento[id=" + id + "]";
    }

}
