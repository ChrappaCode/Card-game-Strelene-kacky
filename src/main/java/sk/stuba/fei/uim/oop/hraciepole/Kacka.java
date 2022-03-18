package sk.stuba.fei.uim.oop.hraciepole;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public class Kacka extends HraciePole{

    private static final String MENO = "\uD83E\uDDA2";

    public Kacka(Hrac hracovaKacka) {
        super(MENO, hracovaKacka.getMeno(), hracovaKacka.getPoradoveCislo());
    }


    }

