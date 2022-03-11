package sk.stuba.fei.uim.oop.hraciePole;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public class Kacka extends HraciePole{

    private static final String MENO = "Kačiak";
    protected Hrac hracovaKacka;

    public Kacka(Hrac hracovaKacka) {
        super(MENO + " " + hracovaKacka.getPoradoveCislo());
    }

    protected void rozdajKacky(Hrac hrac) {

        this.hracovaKacka = hrac;

        }

    }

