package sk.stuba.fei.uim.oop.hraciepole;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public class Kacka extends HraciePole{

    private static final String MENO = "Kačiak";

    public Kacka(Hrac hracovaKacka) {
        super(MENO + " " + hracovaKacka.getPoradoveCislo());
    }


    }

