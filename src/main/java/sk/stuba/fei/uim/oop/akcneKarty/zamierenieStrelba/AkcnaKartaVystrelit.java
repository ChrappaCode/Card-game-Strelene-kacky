package sk.stuba.fei.uim.oop.akcneKarty.zamierenieStrelba;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;

public class AkcnaKartaVystrelit extends AkcneKarty {

    private static final String MENO = "Vystreliť";

    public AkcnaKartaVystrelit(){
        super(MENO);
    }

    @Override
    public void pouzil(Hrac hrac) {

        hrac.hracDostalZasah();

    }

}
