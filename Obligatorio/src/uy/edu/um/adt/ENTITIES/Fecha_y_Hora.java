package uy.edu.um.adt.ENTITIES;

public class Fecha_y_Hora {
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int minuto;

    public Fecha_y_Hora(int dia, int mes, int anio, int hora, int minuto){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minuto = minuto;
    }

    public int verFecha(){
        return (dia + (mes * 100) + (anio * 10000));
    }
}
