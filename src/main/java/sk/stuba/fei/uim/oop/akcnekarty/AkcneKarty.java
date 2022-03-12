package sk.stuba.fei.uim.oop.akcnekarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public abstract class AkcneKarty {

    protected String meno;
    protected boolean[] zamerane;

    public AkcneKarty(String meno , boolean[] zamerane){
        this.meno = meno;
        this.zamerane = zamerane;
    }


    public String getMeno() {
        return meno;
    }

    public abstract void pouzil(Hrac hrac);

}
