/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.flota;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aditardo
 */
@Entity
@Table(name = "registro_de_vehiculo")
@NamedQueries({@NamedQuery(name = "RegistroDeVehiculo.findAll", query = "SELECT r FROM RegistroDeVehiculo r"), @NamedQuery(name = "RegistroDeVehiculo.findById", query = "SELECT r FROM RegistroDeVehiculo r WHERE r.id = :id"), @NamedQuery(name = "RegistroDeVehiculo.findByFecha", query = "SELECT r FROM RegistroDeVehiculo r WHERE r.fecha = :fecha"), @NamedQuery(name = "RegistroDeVehiculo.findByConductor", query = "SELECT r FROM RegistroDeVehiculo r WHERE r.conductor = :conductor"), @NamedQuery(name = "RegistroDeVehiculo.findByRegistroKilometraje", query = "SELECT r FROM RegistroDeVehiculo r WHERE r.registroKilometraje = :registroKilometraje"), @NamedQuery(name = "RegistroDeVehiculo.findByMovimiento", query = "SELECT r FROM RegistroDeVehiculo r WHERE r.movimiento = :movimiento")})
public class RegistroDeVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "conductor")
    private String conductor;
    @Basic(optional = false)
    @Column(name = "registro_kilometraje")
    private int registroKilometraje;
    @Column(name = "movimiento")
    private Character movimiento;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoId;

    public RegistroDeVehiculo() {
    }

    public RegistroDeVehiculo(Integer id) {
        this.id = id;
    }

    public RegistroDeVehiculo(Integer id, Date fecha, String conductor, int registroKilometraje) {
        this.id = id;
        this.fecha = fecha;
        this.conductor = conductor;
        this.registroKilometraje = registroKilometraje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public int getRegistroKilometraje() {
        return registroKilometraje;
    }

    public void setRegistroKilometraje(int registroKilometraje) {
        this.registroKilometraje = registroKilometraje;
    }

    public Character getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Character movimiento) {
        this.movimiento = movimiento;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
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
        if (!(object instanceof RegistroDeVehiculo)) {
            return false;
        }
        RegistroDeVehiculo other = (RegistroDeVehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.RegistroDeVehiculo[id=" + id + "]";
    }

}
