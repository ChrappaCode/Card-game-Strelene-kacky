package sk.stuba.fei.uim.oop.akcnekarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;

import java.util.ArrayList;

public abstract class AkcneKarty {

    protected String meno;
    protected boolean[] zamerane;
    protected ArrayList<HraciePole> pole;
    protected Hrac[] hraci;

    public AkcneKarty(String meno , boolean[] zamerane , ArrayList<HraciePole> pole , Hrac[] hraci){
        this.meno = meno;
        this.zamerane = zamerane;
        this.pole = pole;
        this.hraci = hraci;
    }


    public String getMeno() {
        return meno;
    }

    public abstract void pouzil(Hrac hrac);

}
