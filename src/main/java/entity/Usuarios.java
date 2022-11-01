package entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Usuarios")
@Getter
@Setter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true, nullable = false)
    private int idUsuario;

    @Column
    private String docUsuario;

    @Column
    private String nombreUsuario;

    @Column
    private String emailUsuario;

    @Column
    private String Contraseña;

    @Column
    private String estadoUsuario;

    @Column
    private Date created_at;

    @Column
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name="idRol", referencedColumnName = "idRol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="idDoc", referencedColumnName = "idDoc")
    private Tipo_doc tipo_Doc;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDocUsuario() {
        return docUsuario;
    }

    public void setDocUsuario(String docUsuario) {
        this.docUsuario = docUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Tipo_doc getTipo_Doc() {
        return tipo_Doc;
    }

    public void setTipo_Doc(Tipo_doc tipo_Doc) {
        this.tipo_Doc = tipo_Doc;
    }

    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Usuarios(int idUsuario, String docUsuario, String nombreUsuario, String emailUsuario, String contraseña,
                    String estadoUsuario, Date created_at, Date updated_at, Rol rol, Tipo_doc tipo_Doc) {
        super();
        this.idUsuario = idUsuario;
        this.docUsuario = docUsuario;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        Contraseña = contraseña;
        this.estadoUsuario = estadoUsuario;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.rol = rol;
        this.tipo_Doc = tipo_Doc;
    }



}
