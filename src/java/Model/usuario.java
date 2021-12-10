/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author crist
 */
public class usuario {
    private int idUsuario;
    private int idRolFk;
    private String password;
    private String correoUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String tipoDocUsuario;
    private String numDocUsuario;
    private String telefonoUsuario;
    private String nomRol;
    

    public usuario() {       
    }

    public usuario(int idUsuario, int idRolFk, String password, String correoUsuario, String nombreUsuario, String apellidoUsuario, String tipoDocUsuario, String numDocUsuario, String telefonoUsuario) {
        this.idUsuario = idUsuario;
        this.idRolFk = idRolFk;
        this.password = password;
        this.correoUsuario = correoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.tipoDocUsuario = tipoDocUsuario;
        this.numDocUsuario = numDocUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(int idRolFk) {
        this.idRolFk = idRolFk;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getTipoDocUsuario() {
        return tipoDocUsuario;
    }

    public void setTipoDocUsuario(String tipoDocUsuario) {
        this.tipoDocUsuario = tipoDocUsuario;
    }

    public String getNumDocUsuario() {
        return numDocUsuario;
    }

    public void setNumDocUsuario(String numDocUsuario) {
        this.numDocUsuario = numDocUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }



    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }
    
    
    
}
