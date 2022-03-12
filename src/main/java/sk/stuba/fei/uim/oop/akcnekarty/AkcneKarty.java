package sk.stuba.fei.uim.oop.akcnekarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public abstract class AkcneKarty {

    protected String meno;

    public AkcneKarty(String meno){
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

    public abstract void pouzil(Hrac hrac);

}
