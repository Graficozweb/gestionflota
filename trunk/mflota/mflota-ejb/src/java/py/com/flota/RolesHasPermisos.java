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
@Table(name = "roles_has_permisos")
@NamedQueries({@NamedQuery(name = "RolesHasPermisos.findAll", query = "SELECT r FROM RolesHasPermisos r"), @NamedQuery(name = "RolesHasPermisos.findById", query = "SELECT r FROM RolesHasPermisos r WHERE r.id = :id")})
public class RolesHasPermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "permisos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Permisos permisosId;
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles rolesId;

    public RolesHasPermisos() {
    }

    public RolesHasPermisos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Permisos getPermisosId() {
        return permisosId;
    }

    public void setPermisosId(Permisos permisosId) {
        this.permisosId = permisosId;
    }

    public Roles getRolesId() {
        return rolesId;
    }

    public void setRolesId(Roles rolesId) {
        this.rolesId = rolesId;
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
        if (!(object instanceof RolesHasPermisos)) {
            return false;
        }
        RolesHasPermisos other = (RolesHasPermisos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.RolesHasPermisos[id=" + id + "]";
    }

}
