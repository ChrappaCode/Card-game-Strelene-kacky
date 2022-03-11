package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hraciePole.HraciePole;
import sk.stuba.fei.uim.oop.hraciePole.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Hrac {

    private final String meno;
    private final int poradoveCislo;
    private int pocetZivotov;
    private ArrayList<HraciePole> mojeKacky;
    private boolean hracZije;
    private final ArrayList<AkcneKarty> ruka = new ArrayList<>();

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

    public void hracTahaKartu(ArrayList<AkcneKarty> balikAkcneKarty) {
        this.ruka.add(balikAkcneKarty.get(0));
        balikAkcneKarty.remove(0);
    }

    public void hracZahralKartu(Hrac hrac, ArrayList<AkcneKarty> balikAkcneKarty) {
        int cisloKarty = ZKlavesnice.readInt("ktorú kartu chceš zahrať (1 , 2 , 3)");
        this.ruka.get(cisloKarty - 1).pouzil(hrac);
        balikAkcneKarty.add(this.ruka.get(cisloKarty - 1));
        this.ruka.remove(cisloKarty - 1);
        hracTahaKartu(balikAkcneKarty);
    }

    public void rozdajKacky(Hrac hrac , ArrayList<HraciePole> balikHraciePole) {

        mojeKacky = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            mojeKacky.add(new Kacka(hrac));
            balikHraciePole.add(mojeKacky.get(i));
        }

    }


    public void coMaHracNaRuke() {
        for (int i = 0; i < ruka.size() ; i++) {
            System.out.println(String.format("karta %d • ", i+1) + ruka.get(i).getMeno());
        }
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

    public ArrayList<HraciePole> getMojeKacky() {
        return mojeKacky;
    }
}
