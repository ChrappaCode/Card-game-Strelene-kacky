package sk.stuba.fei.uim.oop.akcnekarty.strelba;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;

public class AkcnaKartaDivokyBill extends AkcneKarty {


    private static final String MENO = "Divoky Bill";

    public AkcnaKartaDivokyBill(boolean[] zamerane){
        super(MENO , zamerane);
    }


    @Override
    public void pouzil(Hrac hrac) {

    }

}
