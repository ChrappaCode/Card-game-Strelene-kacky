package sk.stuba.fei.uim.oop.akcnekarty.strelba;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;

public class AkcnaKartaVystrelit extends AkcneKarty {

    private static final String MENO = "Vystreliť";

    public AkcnaKartaVystrelit(boolean[] zamerane){
        super(MENO , zamerane);
    }

    @Override
    public void pouzil(Hrac hrac) {

        hrac.hracDostalZasah();

    }

}
