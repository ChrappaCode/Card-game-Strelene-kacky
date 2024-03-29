package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcnekarty.strelba.*;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.hraciepole.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Hrac {

    private final String meno;
    private final int poradoveCislo;
    private int pocetKaciek;
    private ArrayList<Integer> pomocneCislo;
    private boolean hracZije;
    private int cisloKarty;
    private final ArrayList<AkcneKarty> ruka = new ArrayList<>();

    public Hrac(int poradoveCislo) {
        this.meno = "Hráč";
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


    public void hracDostalZasah() {
        this.pocetKaciek--;
        if(pocetKaciek == 0){
            this.hracZije = false;
        }
    }

    public void hracZomrel(ArrayList<AkcneKarty> balikAkcneKarty){
        for (int i = 0; i < this.ruka.size() ; i++) {
            balikAkcneKarty.add(this.ruka.get(i));
            this.ruka.remove(i);
        }
    }

    public void hracTahaKartu(ArrayList<AkcneKarty> balikAkcneKarty) {
        this.ruka.add(balikAkcneKarty.get(0));
        balikAkcneKarty.remove(0);
    }

    public void hracZahralKartu(ArrayList<AkcneKarty> balikAkcneKarty , boolean[] zamerane) {

        if(nedaSaZahratZamerat(zamerane) && ruka.get(0) instanceof AkcnaKartaZamierit && ruka.get(1) instanceof AkcnaKartaZamierit && ruka.get(2) instanceof AkcnaKartaZamierit){
            zahodKartu(balikAkcneKarty);
        }
        else if(nedaSaZahratVystrelit(zamerane) && ruka.get(0) instanceof AkcnaKartaVystrelit && ruka.get(1) instanceof AkcnaKartaVystrelit && ruka.get(2) instanceof AkcnaKartaVystrelit){
            zahodKartu(balikAkcneKarty);
        }
        else{
            do {
                while (true){

                    this.cisloKarty = ZKlavesnice.readInt("Ktorú kartu chcete zahrať " + pomocneCislo);
                    if(pomocneCislo.size() == 1){
                        if(pomocneCislo.get(0) == cisloKarty){
                            break;
                        }
                    }
                    if(pomocneCislo.size() == 2){
                        if(pomocneCislo.get(1) == cisloKarty || pomocneCislo.get(0) == cisloKarty){
                            break;
                        }
                    }
                    if(pomocneCislo.size() == 3){
                        break;
                    }
                }
            } while (cisloKarty < 1 || cisloKarty > 3);

            this.ruka.get(cisloKarty - 1).pouzil(this);
            balikAkcneKarty.add(this.ruka.get(cisloKarty - 1));
            this.ruka.remove(cisloKarty - 1);
            hracTahaKartu(balikAkcneKarty);
        }
    }

    public void zahodKartu(ArrayList<AkcneKarty> balikAkcneKarty){

        do {
        this.cisloKarty = ZKlavesnice.readInt("Nemožete zahrať žiadnu kartu (Ktorú kartu chcete zahodiť ? (1  2  3))");
        } while (cisloKarty < 1 || cisloKarty > 3);
        balikAkcneKarty.add(this.ruka.get(cisloKarty-1));
        this.ruka.remove(cisloKarty-1);
        hracTahaKartu(balikAkcneKarty);
    }

    public void rozdajKacky(Hrac hrac , ArrayList<HraciePole> balikHraciePole) {

        ArrayList<HraciePole> mojeKacky = new ArrayList<>();

        for(int i = 0; i < pocetKaciek; i++) {
            mojeKacky.add(new Kacka(hrac));
            balikHraciePole.add(mojeKacky.get(i));
        }
    }

    public void coMaHracNaRuke(boolean[] zamerane) {
        this.pomocneCislo = new ArrayList<>(3);
        for (int i = 0; i < ruka.size() ; i++) {
            System.out.print(String.format("Karta %d • ", i+1) + ruka.get(i).getMeno());

            if(ruka.get(i) instanceof AkcnaKartaVystrelit && nedaSaZahratVystrelit(zamerane)){
                System.out.println(" - Nič nie je zamerané nemožeš zahrať kartu vystreliť");
                continue;
            }
            if(ruka.get(i) instanceof AkcnaKartaZamierit && nedaSaZahratZamerat(zamerane)){
                System.out.println(" - Všetko je zamerané nemožeš zahrať kartu zamerať");
                continue;
            }
            System.out.println();
            pomocneCislo.add(i+1);
        }
    }

    private boolean nedaSaZahratZamerat(boolean[] zamerane){

        for(boolean zamerane1 : zamerane){
            if(!zamerane1) {
                return false;
            }
        }
        return true;
    }

    private boolean nedaSaZahratVystrelit(boolean[] zamerane){

        for(boolean zamerane1 : zamerane){
            if(zamerane1) {
                return false;
            }
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
}
