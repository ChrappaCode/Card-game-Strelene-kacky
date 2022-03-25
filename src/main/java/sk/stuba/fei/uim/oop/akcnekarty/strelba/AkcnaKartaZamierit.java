package sk.stuba.fei.uim.oop.akcnekarty.strelba;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class AkcnaKartaZamierit extends AkcneKarty {

    private static final String MENO = "Zamieriť";

    public AkcnaKartaZamierit(boolean[] zamerane ,  ArrayList<HraciePole> pole ,  Hrac[] hraci){
        super(MENO , zamerane , pole , hraci);
    }

    @Override
    public void pouzil(Hrac hrac) {

        int zamier = ZKlavesnice.readInt("Ktoré políčko chcete zamerať ?");
        while (true){
            if(zamier < 1 || zamier > 6){
                zamier = nejdeZahrat(zamier);
                continue;
            }
            if(zamerane[zamier-1]){
                System.out.println("Toto poličko je už zamerané, daj iné");
                zamier = ZKlavesnice.readInt("Ktoré políčko chcete zamieriť ?");
                continue;
            }
            break;
        }
        zamerane[zamier-1] = true;

    }
}
