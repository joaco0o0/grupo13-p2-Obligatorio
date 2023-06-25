package uy.edu.um.adt.ENTITIES;

public class Fecha {
    private Long dia;
    private Long mes;
    private Long anio;

    public Fecha(Long dia, Long mes, Long anio){
        this.mes = mes;
        this.anio = anio;
        this.dia = dia;

    }

    public int getDia() {
        return Integer.parseInt(dia.toString());
    }

    public int getMes() {
        return Integer.parseInt(mes.toString());
    }

    public int getAnio() {
        return Integer.parseInt(anio.toString());
    }

    public boolean contains(int mes, int anio) {
        if (this.mes == mes && this.anio == anio) {
            return true;

        } else {
            return false;
        }
    }

    public boolean containsDia(int dia, int mes, int anio) {
        if (this.mes == mes && this.anio == anio && this.dia == dia) {
            return true;

        } else {
            return false;
        }
    }
}