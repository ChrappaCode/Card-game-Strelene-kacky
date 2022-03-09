package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcneKarty.zamierenieStrelba.AkcnaKartaVystrelit;

import java.util.ArrayList;

public class Hrac {

    private final String meno;
    private final int poradoveCislo;
    private int pocetZivotov;
    private boolean hracZije;
    private ArrayList<AkcneKarty> ruka = new ArrayList<AkcneKarty>();

    public Hrac(int poradoveCislo) {
        this.meno = "Hráč ";
        this.poradoveCislo = poradoveCislo;
        this.pocetZivotov = 5;
        this.hracZije = true;
    }

    public Hrac(String meno , int poradoveCislo) {
        this.meno = meno;
        this.poradoveCislo = poradoveCislo;
        this.pocetZivotov = 5;
        this.hracZije = true;
    }


    public boolean hracDostalZasah() {
        this.pocetZivotov --;
        if(pocetZivotov == 0){
            this.hracZije = false;
        }
        return hracZije;
    }

    public void potiaholKartu(AkcneKarty akcneKarty) {
        this.ruka.add(akcneKarty);
    }

    public void coMaHracNaRuke() {
        System.out.println(this.ruka);
    }


    public boolean getHracZije() {
        return hracZije;
    }

    public String getMeno() {
        return meno;
    }
    public int getPoradoveCislo() {
        return poradoveCislo;
    }

    public int getPocetZivotov() {
        return pocetZivotov;
    }
}
