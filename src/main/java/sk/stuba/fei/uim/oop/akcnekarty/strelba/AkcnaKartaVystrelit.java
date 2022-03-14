package sk.stuba.fei.uim.oop.akcnekarty.strelba;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.hraciepole.Kacka;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import java.util.ArrayList;

public class AkcnaKartaVystrelit extends AkcneKarty {

    private static final String MENO = "Vystreliť";

    public AkcnaKartaVystrelit(boolean[] zamerane , ArrayList<HraciePole> pole , Hrac[] hraci){
        super(MENO , zamerane , pole , hraci);
    }

    @Override
    public void pouzil(Hrac hrac) {

        int b = ZKlavesnice.readInt("Na ktoré políčko chcete vystreliť ?");
        while (true){
            if(!zamerane[b-1]){
                System.out.println("Toto poličko nie je zamerané");
                b = ZKlavesnice.readInt("Na ktoré políčko chcete vystreliť ?");
                continue;
            }
            break;
        }

        if(pole.get(b-1) instanceof Kacka && zamerane[b-1]){
            hraci[pole.get(b-1).getCisloVlastnika() - 1].hracDostalZasah();
            pole.remove(b-1);
        }

        zamerane[b-1] = false;

    }

}
