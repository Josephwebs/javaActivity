/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorpromocional;

/**
 *
 * @author José Alcantara
 */
public class Cliente {
    private String rutCliente;
    private String nombre; 
    private String apellido; 
    private String direccionDespacho; 
    private String codigosCupones;

    public Cliente(String rutCliente, String nombre, String apellido, String direccionDespacho, String codigosCupones) {
        this.rutCliente = rutCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionDespacho = direccionDespacho;
        this.codigosCupones = codigosCupones;
    }

    public Cliente() {
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccionDespacho() {
        return direccionDespacho;
    }

    public void setDireccionDespacho(String direccionDespacho) {
        this.direccionDespacho = direccionDespacho;
    }

    public String getCodigosCupones() {
        return codigosCupones;
    }

    public void setCodigosCupones(String codigosCupones) {
        this.codigosCupones = codigosCupones;
    }
    
}
