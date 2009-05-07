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
@Table(name = "modelo_de_mantenimiento")
@NamedQueries({@NamedQuery(name = "ModeloDeMantenimiento.findAll", query = "SELECT m FROM ModeloDeMantenimiento m"), @NamedQuery(name = "ModeloDeMantenimiento.findById", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.id = :id"), @NamedQuery(name = "ModeloDeMantenimiento.findByNombre", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.nombre = :nombre"), @NamedQuery(name = "ModeloDeMantenimiento.findByDescripcion", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.descripcion = :descripcion"), @NamedQuery(name = "ModeloDeMantenimiento.findByMarca", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.marca = :marca"), @NamedQuery(name = "ModeloDeMantenimiento.findByModelo", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.modelo = :modelo"), @NamedQuery(name = "ModeloDeMantenimiento.findByAnhio", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.anhio = :anhio"), @NamedQuery(name = "ModeloDeMantenimiento.findByKilometrajes", query = "SELECT m FROM ModeloDeMantenimiento m WHERE m.kilometrajes = :kilometrajes")})
public class ModeloDeMantenimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "anhio")
    @Temporal(TemporalType.DATE)
    private Date anhio;
    @Column(name = "kilometrajes")
    private Integer kilometrajes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloDeMantenimientoId")
    private List<OrdenDeMantenimiento> ordenDeMantenimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloDeMantenimientoId")
    private List<ModeloDeMantenimientoHasMantenimientoPreventivo> modeloDeMantenimientoHasMantenimientoPreventivoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloDeMantenimientoId")
    private List<Vehiculo> vehiculoCollection;

    public ModeloDeMantenimiento() {
    }

    public ModeloDeMantenimiento(Integer id) {
        this.id = id;
    }

    public ModeloDeMantenimiento(Integer id, String marca, String modelo, Date anhio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anhio = anhio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAnhio() {
        return anhio;
    }

    public void setAnhio(Date anhio) {
        this.anhio = anhio;
    }

    public Integer getKilometrajes() {
        return kilometrajes;
    }

    public void setKilometrajes(Integer kilometrajes) {
        this.kilometrajes = kilometrajes;
    }

    public List<OrdenDeMantenimiento> getOrdenDeMantenimientoCollection() {
        return ordenDeMantenimientoCollection;
    }

    public void setOrdenDeMantenimientoCollection(List<OrdenDeMantenimiento> ordenDeMantenimientoCollection) {
        this.ordenDeMantenimientoCollection = ordenDeMantenimientoCollection;
    }

    public List<ModeloDeMantenimientoHasMantenimientoPreventivo> getModeloDeMantenimientoHasMantenimientoPreventivoCollection() {
        return modeloDeMantenimientoHasMantenimientoPreventivoCollection;
    }

    public void setModeloDeMantenimientoHasMantenimientoPreventivoCollection(List<ModeloDeMantenimientoHasMantenimientoPreventivo> modeloDeMantenimientoHasMantenimientoPreventivoCollection) {
        this.modeloDeMantenimientoHasMantenimientoPreventivoCollection = modeloDeMantenimientoHasMantenimientoPreventivoCollection;
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
        if (!(object instanceof ModeloDeMantenimiento)) {
            return false;
        }
        ModeloDeMantenimiento other = (ModeloDeMantenimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.ModeloDeMantenimiento[id=" + id + "]";
    }

}
