package com.example.brend.aplicacionseccion2;

public class Empleado {
    private String uid;
    private String Nombre_emp;
    private String Apellido_emp;
    private String Num_emp;
    private String NSS_emp;
    private String RFC_emp;
    private String CURP_emp;
    private String Nacimiento_emp;

    @Override
    public String toString(){return Num_emp;}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCURP_emp() {
        return CURP_emp;
    }

    public void setCURP_emp(String CURP_emp) {
        this.CURP_emp = CURP_emp;
    }

    public String getNombre_emp() {
        return Nombre_emp;
    }

    public void setNombre_emp(String Nombre_emp) {
        this.Nombre_emp = Nombre_emp;
    }

    public String getApellido_emp() {
        return Apellido_emp;
    }

    public void setApellido_emp(String Apellido_emp) {
        this.Apellido_emp = Apellido_emp;
    }

    public String getNum_emp() {
        return Num_emp;
    }

    public void setNum_emp(String Num_emp) {
        this.Num_emp = Num_emp;
    }

    public String getNSS_emp() {
        return NSS_emp;
    }

    public void setNSS_emp(String NSS_emp) {
        this.NSS_emp = NSS_emp;
    }

    public String getRFC_emp() {
        return RFC_emp;
    }

    public void setRFC_emp(String RFC_emp) {
        this.RFC_emp = RFC_emp;
    }

    public String getNacimiento_emp() {
        return Nacimiento_emp;
    }

    public void setNacimiento_emp(String Nacimiento_emp) {
        this.Nacimiento_emp = Nacimiento_emp;
    }
}
