package com.KACP.x00203919;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean comprobacionPrincipal =true;
        do{
            try {
                int resp = Integer.parseInt(JOptionPane.showInputDialog(null, "CALCULO DE SALARIO DE UN EMPLEADO\n1. Calcular salario\n2.Salir\n"));
                if (resp == 1){
                    String nombre = JOptionPane.showInputDialog(null, "Nombre del empleado\n");
                    String puesto = JOptionPane.showInputDialog(null, "Puesto\n");
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario bruto\n"));

                    if (salario < 0)
                        throw new InvalidFormatException("Dato fuera de rango\n");

                    int trabajo = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipo de empleo\n1. Servicio profesional\n2. Plaza fija\n"));

                    if (trabajo == 1) {
                        int contrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Meses del contrato\n"));
                        if (contrato < 0)
                            throw new InvalidFormatException("Dato fuera de rango\n");

                        ServicioProfesional EmpleadoServicio = new ServicioProfesional(nombre, puesto, salario, contrato);
                        double pagoNeto = CalculadoraImpuestos.calcularPago(EmpleadoServicio);
                        JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales() + "\nSalario Neto: " + pagoNeto);
                    } else {
                        if (trabajo == 2) {
                            int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Extencion\n"));
                            if (extension < 0)
                                throw new InvalidFormatException("Dato fuera de rango\n");

                            PlazaFija EmpleadoFijo = new PlazaFija(nombre, puesto, salario, extension);
                            double pagoNeto = CalculadoraImpuestos.calcularPago(EmpleadoFijo);
                            JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales() + "\nSalario Neto: " + pagoNeto);

                        } else
                            throw new InvalidFormatException("Dato fuera de rango\n");
                    }

                }else {
                    if (resp == 2)
                        comprobacionPrincipal = false;
                    else
                        throw new InvalidFormatException("Dato fuera de rango\n");
                }

            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "java.lang.NumberFormatException: Caracter no valido\n");
                comprobacionPrincipal = true;
            } catch (InvalidFormatException e) {
                JOptionPane.showMessageDialog(null, e);
                comprobacionPrincipal = true;
            } catch (java.lang.NullPointerException e) {
                comprobacionPrincipal = true;
            }

        }while (comprobacionPrincipal);

    }
}
