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
@Table(name = "usuario_has_roles")
@NamedQueries({@NamedQuery(name = "UsuarioHasRoles.findAll", query = "SELECT u FROM UsuarioHasRoles u"), @NamedQuery(name = "UsuarioHasRoles.findById", query = "SELECT u FROM UsuarioHasRoles u WHERE u.id = :id")})
public class UsuarioHasRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles rolesId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public UsuarioHasRoles() {
    }

    public UsuarioHasRoles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getRolesId() {
        return rolesId;
    }

    public void setRolesId(Roles rolesId) {
        this.rolesId = rolesId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof UsuarioHasRoles)) {
            return false;
        }
        UsuarioHasRoles other = (UsuarioHasRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.flota.UsuarioHasRoles[id=" + id + "]";
    }

}
