package com.biznis.sd.alpinazvezda;

import java.util.ArrayList;

public class ArtikalProvider {
    public static ArrayList<Artikal> getArtikle(){
        ArrayList<Artikal> artikli=new ArrayList<>();
        artikli.add(new Artikal(0,R.drawable.metal,"Tessarol","Industrijski premazi","Industrijski premazi za metal",650));
        artikli.add(new Artikal(1,R.drawable.vuna,"Kamena vuna","Gradjevinski premazi","Izolacioni materijal",1400));
        artikli.add(new Artikal(2,R.drawable.kola,"Motip farba za motor","Autoprogram","Zavrsne boje i lakovi",450));
        artikli.add(new Artikal(3,R.drawable.glet,"Glet masa Ceresit","Gradjevinski premazi","Lepkovi, glet mase i ispunjivaci",890));

        return artikli;
    }

    public static Artikal getArtikalById(int id){
        switch (id){
            case 0:
                return new Artikal(0,R.drawable.metal,"Tessarol","Industrijski premazi","Industrijski premazi za metal",650);
            case 1:
                return new Artikal(1,R.drawable.vuna,"Kamena vuna","Gradjevinski premazi","Izolacioni materijal",1400);
            case 2:
                return new Artikal(2,R.drawable.kola,"Motip farba za motor","Autoprogram","Zavrsne boje i lakovi",450);
            case 3:
                return new Artikal(3,R.drawable.glet,"Glet masa Ceresit","Gradjevinski premazi","Lepkovi, glet mase i ispunjivaci",890);
            default:
                return null;
        }
    }
}