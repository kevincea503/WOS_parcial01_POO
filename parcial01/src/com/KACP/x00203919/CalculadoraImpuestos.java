package com.KACP.x00203919;

public final class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos(){}

    public static double calcularPago(Empleado e){
        double pago =0.0;
        if(e instanceof ServicioProfesional){
            totalRenta = 0.1*e.salario;
            pago = e.salario-totalRenta;

        }else {
            totalAFP = 0.0625 * e.salario;
            totalISSS = 0.03 * e.salario;
            double saldoRestante = e.salario-(totalISSS+totalAFP);
            if(saldoRestante>0 && saldoRestante<=472)
                pago = saldoRestante;
            else{
                if(saldoRestante>472 && saldoRestante<=895.24){
                    totalRenta = 0.1*(saldoRestante-472) +17.67;
                    pago = saldoRestante-totalRenta;
                }else{
                    if(saldoRestante>895.24 && saldoRestante<= 2038.10){
                        totalRenta = 0.2*(saldoRestante-895.24)+60;
                        pago = saldoRestante-totalRenta;
                    }
                    else{
                        if(saldoRestante>2038.10){
                            totalRenta = 0.3*(saldoRestante-2038.10)+ 288.57;
                            pago =saldoRestante-totalRenta;
                        }else
                            System.out.println("Error");
                    }
                }
            }
        }

        return pago;
    }


    public static String mostrarTotales(){
        String descripcion ="Detalle de descuentos:\n -- AFP: " + totalAFP + "\n "+ "-- ISSS: " + totalISSS + "\n " +
                "-- Renta: " + totalRenta + "\n ";
        return descripcion;
    }

}
