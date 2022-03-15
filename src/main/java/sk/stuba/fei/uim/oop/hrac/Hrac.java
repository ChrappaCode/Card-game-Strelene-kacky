package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.hraciepole.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Hrac {

    private final String meno;
    private final int poradoveCislo;
    private int pocetKaciek;
    private ArrayList<HraciePole> mojeKacky;
    private boolean hracZije;
    private final ArrayList<AkcneKarty> ruka = new ArrayList<>();

    public Hrac(int poradoveCislo) {
        this.meno = "Hráč ";
        this.poradoveCislo = poradoveCislo;
        this.pocetKaciek = 5;
        this.hracZije = true;
    }

    public Hrac(String meno , int poradoveCislo) {
        this.meno = meno;
        this.poradoveCislo = poradoveCislo;
        this.pocetKaciek = 5;
        this.hracZije = true;
    }


    public boolean hracDostalZasah() {
        this.pocetKaciek--;
        if(pocetKaciek == 0){
            this.hracZije = false;
        }
        return hracZije;
    }

    public void hracTahaKartu(ArrayList<AkcneKarty> balikAkcneKarty) {
        this.ruka.add(balikAkcneKarty.get(0));
        balikAkcneKarty.remove(0);
    }

    public void hracZahralKartu(ArrayList<AkcneKarty> balikAkcneKarty) {
        int cisloKarty = ZKlavesnice.readInt("Ktorú kartu chceš zahrať (1 , 2 , 3)");
        this.ruka.get(cisloKarty - 1).pouzil(this);
        balikAkcneKarty.add(this.ruka.get(cisloKarty - 1));
        this.ruka.remove(cisloKarty - 1);
        hracTahaKartu(balikAkcneKarty);
    }

    public void zahodKartu(ArrayList<AkcneKarty> balikAkcneKarty){
        int cisloKarty = ZKlavesnice.readInt("Ktorú kartu chceš zahodiť (1 , 2 , 3)");
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

    public boolean daSaZahratZamerat(boolean[] zamerane){

        int a = 1;
        int c = 1;

        for(boolean b : zamerane){
            if(!b) {
                c=2;break;
            }
            else a = 0;
        }
        if(a == 0 && c != 2){
            System.out.println("Všetko je zamerané nemožeš zahrať kartu zamerať");
            return false;
        }
        return true;
    }

    public boolean daSaZahratVystrelit(boolean[] zamerane){

        int c = 1;

        for(boolean b : zamerane){
            if(!b) {
                c=2;
            }
            else {
                c = 1;
                break;
            }
        }
        if(c == 2){
            System.out.println("Nič nie je zamerané nemožeš zahrať kartu vystreliť");
            return false;
        }
        return true;
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

    public int getPocetKaciek() {
        return pocetKaciek;
    }

    public ArrayList<HraciePole> getMojeKacky() {
        return mojeKacky;
    }
}
