package com.KACP.x00203919;

public class PlazaFija extends Empleado{
    private int extension;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extension = extension;
    }

}
