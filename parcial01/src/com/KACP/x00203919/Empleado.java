package com.KACP.x00203919;

public abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }


}
