/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Davixc
 */
public class Alumno {

 
    private  String noC;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String grupo;
    private String licenciatura;
    private String semestre;
    private String promedio;
    private String fecha_ingreso;
    
       public Alumno(String noC, String nombre, String apellidoP, String apellidoM, String grupo,String licenciatura, String semestre, String promedio, String fecha_ingreso) {
        this.noC = noC;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.grupo = grupo;  
        this.licenciatura = licenciatura;
        this.semestre = semestre;
        this.promedio = promedio;
        this.fecha_ingreso = fecha_ingreso;
    }
    
   public Alumno() {
        this.noC =null;
        this.nombre = null;
        this.apellidoP = null;
        this.apellidoM = null;
        this.grupo = null;
        this.licenciatura = null;
        this.semestre = null;
        this.promedio= null;
        this.fecha_ingreso = null;
        
        
    }

    public String getNoC() {
        return noC;
    }

    public void setNoC(String noC) {
        this.noC = noC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "noC=" + noC + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", grupo=" + grupo + ", licenciatura=" + licenciatura + ", semestre=" + semestre + ", promedio=" + promedio + ", fecha_ingreso=" + fecha_ingreso + '}';
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
}
