package sk.stuba.fei.uim.oop.akcnekarty.pohyb;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;

import java.util.ArrayList;

public class AkcnaKartaRosambo extends AkcneKarty {

    private static final String MENO = "Rošambo";

    public AkcnaKartaRosambo(boolean[] zamerane , ArrayList<HraciePole> pole , Hrac[] hraci){
        super(MENO,zamerane , pole , hraci);
    }

    @Override
    public void pouzil(Hrac hrac) {

        for(int i = 0 ; i < 6 ; i++){
           int nahodnaPremenna = (int)(Math.random() * 6);
           HraciePole temp = pole.get(i);
           pole.set(i, pole.get(nahodnaPremenna));
           pole.set(nahodnaPremenna, temp);
        }
    }
}
