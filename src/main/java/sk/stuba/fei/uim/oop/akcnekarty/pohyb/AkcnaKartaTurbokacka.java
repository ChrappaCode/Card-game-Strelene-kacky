package sk.stuba.fei.uim.oop.akcnekarty.pohyb;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;

public class AkcnaKartaTurbokacka extends AkcneKarty {

    private static final String MENO = "Turbokacka";

    public AkcnaKartaTurbokacka(boolean[] zamerane){
        super(MENO,zamerane);
    }

    @Override
    public void pouzil(Hrac hrac) {

    }
}
