package sk.stuba.fei.uim.oop.akcnekarty.pohyb;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;

public class AkcnaKartaKacaciTanec extends AkcneKarty {

    private static final String MENO = "Kacaci Tanec";

    public AkcnaKartaKacaciTanec(boolean[] zamerane){
        super(MENO,zamerane);
    }

    @Override
    public void pouzil(Hrac hrac) {

    }
}
