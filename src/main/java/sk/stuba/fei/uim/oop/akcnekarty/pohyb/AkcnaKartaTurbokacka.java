package sk.stuba.fei.uim.oop.akcnekarty.pohyb;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.hraciepole.Voda;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class AkcnaKartaTurbokacka extends AkcneKarty {

    private static final String MENO = "Turbokačka";

    public AkcnaKartaTurbokacka(boolean[] zamerane , ArrayList<HraciePole> pole , Hrac[] hraci){
        super(MENO,zamerane , pole, hraci);
    }

    @Override
    public void pouzil(Hrac hrac) {

        int ktoraKacka = ZKlavesnice.readInt("Ktorú kačku chceš dať na začiatok pola ?");

        while (true){
            if(ktoraKacka < 1 || ktoraKacka > 6){
                ktoraKacka = nejdeZahrat(ktoraKacka);
                continue;
            }
            if(pole.get(ktoraKacka-1) instanceof Voda){
                System.out.println("Toto poličko je Voda");
                ktoraKacka = ZKlavesnice.readInt("Ešte raz");
                continue;
            }
            break;
        }

        pole.add(0,pole.get(ktoraKacka-1));
        pole.remove(ktoraKacka);

    }
}
