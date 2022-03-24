package sk.stuba.fei.uim.oop.akcnekarty.pohyb;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;

import java.util.ArrayList;
import java.util.Collections;

public class AkcnaKartaKacaciTanec extends AkcneKarty {

    private static final String MENO = "Kačací Tanec";

    public AkcnaKartaKacaciTanec(boolean[] zamerane , ArrayList<HraciePole> pole , Hrac[] hraci){
        super(MENO,zamerane, pole ,hraci);
    }

    @Override
    public void pouzil(Hrac hrac) {

        Collections.shuffle(pole);

    }
}
