package fpt.ad09.blood_management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    int idUser;

    @Column(name = "username", length = 50, nullable = false)
    String username;

    @Column(name = "password", length = 50, nullable = false)
    String password;

    @Column(name = "id_role", nullable = false)
    int idRole;

    @Column(name = "enabled", nullable = false)
    int enabled;


    public User() {
        super();
    }
    public User(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.idRole = user.getIdRole();
    }
    public User(int idUser, String username, String password, int idRole, int enabled) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.idRole = idRole;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idRole=" + idRole +
                ", enabled=" + enabled +
                '}';
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}

