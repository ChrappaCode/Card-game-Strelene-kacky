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

        int b = ZKlavesnice.readInt("Ktoré políčko chcete zamerať ?");
        while (true){
            if(b < 1 || b > 6){
                b = nejdeZahrat(b);
                continue;
            }
            if(zamerane[b-1]){
                System.out.println("Toto poličko je už zamerané");
                b = ZKlavesnice.readInt("Ktoré políčko chcete zamieriť ?");
                continue;
            }
            break;
        }
        zamerane[b-1] = true;

    }
}
