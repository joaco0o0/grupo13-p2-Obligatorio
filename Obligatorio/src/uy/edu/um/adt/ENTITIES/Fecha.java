package uy.edu.um.adt.ENTITIES;

public class Fecha{
    private Long dia;
    private Long mes;
    private Long anio;

    public Fecha(Long dia, Long mes, Long anio){
        this.mes = mes;
        this.anio = anio;
        this.dia = dia;

    }

    public Long getDia(){
        return dia;
    }
    public Long getMes(){
        return mes;
    }
    public Long getAnio(){
        return anio;
    }

    public boolean containsMes(int mes){
       if(this.mes == mes){
                return true;
            }else{
                return false;
            }
    }
    public boolean containsAnio(int anio){
        if(this.anio == anio){
                return true;
            }else{
                return false;
            }
    }
}