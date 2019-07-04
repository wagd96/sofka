package Utilidades;

public class Utilidades {

    public double decimalAleatorio(double numeroMinimo, double numeroMaximo, double cantidadDeDecimales){
        double cDecimales = Math.pow(10,cantidadDeDecimales);
        double enteroAleatorio = (Math.random() * ((numeroMaximo - numeroMinimo))) + numeroMinimo;
        if(cantidadDeDecimales == 0){
            cDecimales = 1;
        }
        return Math.round(enteroAleatorio * cDecimales) / cDecimales;
    }

    public double decimalAleatorio(double cantidadDeEnteros, double cantidadDeDecimales){
        double cEnteros = Math.pow(10,cantidadDeEnteros);
        double cDecimales = Math.pow(10,cantidadDeDecimales);
        double enteroAleatorio = (Math.random() * ((cEnteros) + 1)) ;
        if(cantidadDeDecimales == 0){
            cDecimales = 1;
        }
        return Math.round(enteroAleatorio * cDecimales) / cDecimales;
    }

    public boolean isNumero(String numero){
        if(numero.matches("\\d+\\.\\d+|\\d+")){
            return true;
        }else{
            return false;
        }
    }
}
