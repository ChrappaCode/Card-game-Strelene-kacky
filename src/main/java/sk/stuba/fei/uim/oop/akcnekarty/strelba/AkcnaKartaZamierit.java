package sk.stuba.fei.uim.oop.akcnekarty.strelba;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class AkcnaKartaZamierit extends AkcneKarty {

    private static final String MENO = "Zamieriť";

    public AkcnaKartaZamierit(boolean[] zamerane){
        super(MENO , zamerane);
    }

    @Override
    public void pouzil(Hrac hrac) {

        int a = ZKlavesnice.readInt("Ktoré políčko chcete zamieriť ?");
        zamerane[a-1] = true;

    }
}
