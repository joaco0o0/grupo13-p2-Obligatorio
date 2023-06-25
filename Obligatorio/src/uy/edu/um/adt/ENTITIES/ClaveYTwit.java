package uy.edu.um.adt.ENTITIES;

public class ClaveYTwit implements Comparable<ClaveYTwit> {
    private Long clave;
    private Integer twit;

    public ClaveYTwit(Long clave, Integer twit) {
        this.clave = clave;
        this.twit = twit;
    }

    public Long getClave() {
        return clave;
    }

    public Integer getTwit() {
        return twit;
    }

    @Override
    public int compareTo(ClaveYTwit o) {
        return this.twit.compareTo(o.getTwit());
    }
}
