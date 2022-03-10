package sk.stuba.fei.uim.oop.streleneKacky;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcneKarty.pohyb.*;
import sk.stuba.fei.uim.oop.akcneKarty.zamierenieStrelba.*;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciePole.HraciePole;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;


public class StreleneKacky {

    public static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;
    private int pocetHracov;
    private int ktoJeNaTahu = 0;
    private ArrayList<AkcneKarty> balikAkcneKarty;
    private ArrayList<HraciePole> hraciePole;


    public StreleneKacky() {

        System.out.println("Strelené Kačky Jakub Chrappa");
        this.pocetHracov = ZKlavesnice.readInt(String.format("Zadaj pocet hracov od 2 do %d: ", MAX_POCET_HRACOV));
        while (true){
            if(pocetHracov < 2 || pocetHracov > 6){ //aby nedal menej ako 2 a viac ako 6
                System.out.printf("Minimálny počet hráčov je 2 a maximálny počet hráčov je %d takže znova!\n", MAX_POCET_HRACOV);
                pocetHracov = ZKlavesnice.readInt(String.format("Zadaj pocet hracov od 2 do %d: ", MAX_POCET_HRACOV));
                continue;
            }
            this.hraci = new Hrac[pocetHracov];
            break;
        }
        generujHracov();

        System.out.println("Počet hráčov je : " + pocetHracov);
        System.out.println("Dnes hrá : ");
        getHraci();


        startHry();
    }

    private void startHry() {

        System.out.println("Hra sa začala");
        System.out.println("toto je balik akcnych kariet: ");
        novyBalik();
        zamiesajKarty();
        vypisBalicek();

        Hrac hracNaTahu = this.hraci[ktoJeNaTahu];

        hracNaTahu.hracTahaKartu(balikAkcneKarty);
        hracNaTahu.hracTahaKartu(balikAkcneKarty);
        hracNaTahu.hracTahaKartu(balikAkcneKarty);

        System.out.println("Tieto karty má " + hracNaTahu.getMeno() +" "+ hracNaTahu.getPoradoveCislo());
        hracNaTahu.coMaHracNaRuke();

        vypisBalicek();

        hracNaTahu.hracZahralKartu(hracNaTahu , balikAkcneKarty);
        hracNaTahu.coMaHracNaRuke();

        vypisBalicek();

        getHraci();

        //kod here

        prepniHraca();
        System.out.println(ktoJeNaTahu);

        System.out.println("Hra sa skončila");
        vitazHry();  //funguje to len nechcem ten vypis teraz
        System.out.println("Jakub Chrappa ais: 111286");
    }

    private void novyBalik() {

        this.balikAkcneKarty = new ArrayList<>();

        for(int i = 10; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaZamierit());
        }
        for(int i = 12; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaVystrelit());
        }
        for(int i = 2; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaDivokyBill());
        }
        for(int i = 2; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaRosambo());
        }
        for(int i = 6; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaKacaciPochod());
        }
        balikAkcneKarty.add(new AkcnaKartaTurbokacka());
        balikAkcneKarty.add(new AkcnaKartaKacaciTanec());

    }

    private void novePole() {

        this.hraciePole = new ArrayList<>();

    }

    private void generujHracov() {

        int vlastneMeno = ZKlavesnice.readInt("Chcete zadat vlastné mená postáv ak áno zadajte \"1\"");
        for (int i = 0; i < pocetHracov; i++) {//tu si vytvorim hracov
            if(vlastneMeno == 1) {
                this.hraci[i] = new Hrac(ZKlavesnice.readString(String.format("Zadajte meno hráča %d: ", i+1)), i + 1);
            }
            else {
                this.hraci[i] = new Hrac(i + 1);
            }
        }
    }


    private void prepniHraca() {
        this.ktoJeNaTahu ++;
        System.out.println(this.ktoJeNaTahu);
        this.ktoJeNaTahu = (this.ktoJeNaTahu % pocetHracov);
    }


    private void getHraci() {
        for (int i = 0; i < pocetHracov; i++) {
            System.out.println(this.hraci[i].getMeno() +" "+ this.hraci[i].getPoradoveCislo() + " -> počet životov: " + this.hraci[i].getPocetZivotov());
        }
    }

    private void vitazHry() {
        for (int i = 0; i < pocetHracov; i++) {
            if (this.hraci[i].getHracZije()) {
                System.out.println("Víťazom sa stáva : " + this.hraci[i].getMeno() + " " + this.hraci[i].getPoradoveCislo());
            }
        }
    }

    private void zamiesajKarty() {
        for (int i = 0; i < balikAkcneKarty.size(); i++) {
            int nahodnaPremenna = (int)(Math.random() * balikAkcneKarty.size());
            AkcneKarty temp = balikAkcneKarty.get(i);
            balikAkcneKarty.set(i, balikAkcneKarty.get(nahodnaPremenna));
            balikAkcneKarty.set(nahodnaPremenna, temp);
        }
    }

    private void vypisBalicek() {
        for (AkcneKarty akcneKarty : balikAkcneKarty) {
            System.out.println("• " + akcneKarty.getMeno());
        }
        System.out.println("------------------------");
    }

    public ArrayList<AkcneKarty> getBalikAkcneKarty() {
        return balikAkcneKarty;
    }
}
