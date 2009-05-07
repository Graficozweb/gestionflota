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
@Table(name = "roles")
@NamedQueries({@NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"), @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id"), @NamedQuery(name = "Roles.findByNombre", query = "SELECT r FROM Roles r WHERE r.nombre = :nombre"), @NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion")})
public class Roles implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolesId")
    private List<UsuarioHasRoles> usuarioHasRolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolesId")
    private List<RolesHasPermisos> rolesHasPermisosCollection;

    public Roles() {
    }

    public Roles(Integer id) {
        this.id = id;
    }

    public Roles(Integer id, String nombre) {
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

    public List<UsuarioHasRoles> getUsuarioHasRolesCollection() {
        return usuarioHasRolesCollection;
    }

    public void setUsuarioHasRolesCollection(List<UsuarioHasRoles> usuarioHasRolesCollection) {
        this.usuarioHasRolesCollection = usuarioHasRolesCollection;
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
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.Roles[id=" + id + "]";
    }

}
