package com.biznis.sd.alpinazvezda;

public class Artikal {

    private int id;
    private int img;
    private String naziv;
    private String grupa;
    private String podgrupa;
    private double cena;

    public Artikal(int id, int img, String naziv, String grupa, String podgrupa, double cena) {
        this.id=id;
        this.img = img;
        this.naziv = naziv;
        this.grupa = grupa;
        this.podgrupa = podgrupa;
        this.cena = cena;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getPodgrupa() {
        return podgrupa;
    }

    public void setPodgrupa(String podgrupa) {
        this.podgrupa = podgrupa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
