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
@Table(name = "permisos")
@NamedQueries({@NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"), @NamedQuery(name = "Permisos.findById", query = "SELECT p FROM Permisos p WHERE p.id = :id"), @NamedQuery(name = "Permisos.findByNombre", query = "SELECT p FROM Permisos p WHERE p.nombre = :nombre"), @NamedQuery(name = "Permisos.findByDescripcion", query = "SELECT p FROM Permisos p WHERE p.descripcion = :descripcion")})
public class Permisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisosId")
    private List<RolesHasPermisos> rolesHasPermisosCollection;

    public Permisos() {
    }

    public Permisos(Integer id) {
        this.id = id;
    }

    public Permisos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<RolesHasPermisos> getRolesHasPermisosCollection() {
        return rolesHasPermisosCollection;
    }

    public void setRolesHasPermisosCollection(List<RolesHasPermisos> rolesHasPermisosCollection) {
        this.rolesHasPermisosCollection = rolesHasPermisosCollection;
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
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.Permisos[id=" + id + "]";
    }

}
