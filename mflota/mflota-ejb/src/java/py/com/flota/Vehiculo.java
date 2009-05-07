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
@Table(name = "vehiculo")
@NamedQueries({@NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"), @NamedQuery(name = "Vehiculo.findById", query = "SELECT v FROM Vehiculo v WHERE v.id = :id"), @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"), @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"), @NamedQuery(name = "Vehiculo.findByAnhio", query = "SELECT v FROM Vehiculo v WHERE v.anhio = :anhio"), @NamedQuery(name = "Vehiculo.findByNumeroDeMotor", query = "SELECT v FROM Vehiculo v WHERE v.numeroDeMotor = :numeroDeMotor"), @NamedQuery(name = "Vehiculo.findByNumeroDeChasis", query = "SELECT v FROM Vehiculo v WHERE v.numeroDeChasis = :numeroDeChasis"), @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color"), @NamedQuery(name = "Vehiculo.findByNChapa", query = "SELECT v FROM Vehiculo v WHERE v.nChapa = :nChapa"), @NamedQuery(name = "Vehiculo.findByNMovil", query = "SELECT v FROM Vehiculo v WHERE v.nMovil = :nMovil"), @NamedQuery(name = "Vehiculo.findByCilindrada", query = "SELECT v FROM Vehiculo v WHERE v.cilindrada = :cilindrada"), @NamedQuery(name = "Vehiculo.findByCantidadCubiertas", query = "SELECT v FROM Vehiculo v WHERE v.cantidadCubiertas = :cantidadCubiertas"), @NamedQuery(name = "Vehiculo.findByTiposCubiertas", query = "SELECT v FROM Vehiculo v WHERE v.tiposCubiertas = :tiposCubiertas"), @NamedQuery(name = "Vehiculo.findByMedidasCubiertas", query = "SELECT v FROM Vehiculo v WHERE v.medidasCubiertas = :medidasCubiertas")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "anhio")
    @Temporal(TemporalType.DATE)
    private Date anhio;
    @Column(name = "numero_de_motor")
    private Integer numeroDeMotor;
    @Basic(optional = false)
    @Column(name = "numero_de_chasis")
    private int numeroDeChasis;
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "n_chapa")
    private int nChapa;
    @Column(name = "n_movil")
    private Integer nMovil;
    @Column(name = "cilindrada")
    private Integer cilindrada;
    @Column(name = "cantidad_cubiertas")
    private Integer cantidadCubiertas;
    @Column(name = "tipos_cubiertas")
    private String tiposCubiertas;
    @Column(name = "medidas_cubiertas")
    private Integer medidasCubiertas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoId")
    private List<OrdenDeMantenimiento> ordenDeMantenimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoId")
    private List<RegistroDeVehiculo> registroDeVehiculoCollection;
    @JoinColumn(name = "modelo_de_mantenimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ModeloDeMantenimiento modeloDeMantenimientoId;
    @JoinColumn(name = "tipo_combustible_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCombustible tipoCombustibleId;
    @JoinColumn(name = "tipo_vehiculo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoVehiculo tipoVehiculoId;

    public Vehiculo() {
    }

    public Vehiculo(Integer id) {
        this.id = id;
    }

    public Vehiculo(Integer id, String modelo, String marca, Date anhio, int numeroDeChasis, int nChapa) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.anhio = anhio;
        this.numeroDeChasis = numeroDeChasis;
        this.nChapa = nChapa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnhio() {
        return anhio;
    }

    public void setAnhio(Date anhio) {
        this.anhio = anhio;
    }

    public Integer getNumeroDeMotor() {
        return numeroDeMotor;
    }

    public void setNumeroDeMotor(Integer numeroDeMotor) {
        this.numeroDeMotor = numeroDeMotor;
    }

    public int getNumeroDeChasis() {
        return numeroDeChasis;
    }

    public void setNumeroDeChasis(int numeroDeChasis) {
        this.numeroDeChasis = numeroDeChasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNChapa() {
        return nChapa;
    }

    public void setNChapa(int nChapa) {
        this.nChapa = nChapa;
    }

    public Integer getNMovil() {
        return nMovil;
    }

    public void setNMovil(Integer nMovil) {
        this.nMovil = nMovil;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Integer getCantidadCubiertas() {
        return cantidadCubiertas;
    }

    public void setCantidadCubiertas(Integer cantidadCubiertas) {
        this.cantidadCubiertas = cantidadCubiertas;
    }

    public String getTiposCubiertas() {
        return tiposCubiertas;
    }

    public void setTiposCubiertas(String tiposCubiertas) {
        this.tiposCubiertas = tiposCubiertas;
    }

    public Integer getMedidasCubiertas() {
        return medidasCubiertas;
    }

    public void setMedidasCubiertas(Integer medidasCubiertas) {
        this.medidasCubiertas = medidasCubiertas;
    }

    public List<OrdenDeMantenimiento> getOrdenDeMantenimientoCollection() {
        return ordenDeMantenimientoCollection;
    }

    public void setOrdenDeMantenimientoCollection(List<OrdenDeMantenimiento> ordenDeMantenimientoCollection) {
        this.ordenDeMantenimientoCollection = ordenDeMantenimientoCollection;
    }

    public List<RegistroDeVehiculo> getRegistroDeVehiculoCollection() {
        return registroDeVehiculoCollection;
    }

    public void setRegistroDeVehiculoCollection(List<RegistroDeVehiculo> registroDeVehiculoCollection) {
        this.registroDeVehiculoCollection = registroDeVehiculoCollection;
    }

    public ModeloDeMantenimiento getModeloDeMantenimientoId() {
        return modeloDeMantenimientoId;
    }

    public void setModeloDeMantenimientoId(ModeloDeMantenimiento modeloDeMantenimientoId) {
        this.modeloDeMantenimientoId = modeloDeMantenimientoId;
    }

    public TipoCombustible getTipoCombustibleId() {
        return tipoCombustibleId;
    }

    public void setTipoCombustibleId(TipoCombustible tipoCombustibleId) {
        this.tipoCombustibleId = tipoCombustibleId;
    }

    public TipoVehiculo getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(TipoVehiculo tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.Vehiculo[id=" + id + "]";
    }

}
