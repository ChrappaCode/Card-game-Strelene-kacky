package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcnekarty.pohyb.*;
import sk.stuba.fei.uim.oop.akcnekarty.strelba.*;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class StreleneKacky {

    private static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;
    private int pocetHracov;
    private int ktoJeNaTahu = 0;
    private ArrayList<AkcneKarty> balikAkcneKarty;
    private ArrayList<HraciePole> balikHraciePole;
    private boolean[] zamerane;

    public StreleneKacky() {

        System.out.println("Strelené Kačky Jakub Chrappa");
        this.pocetHracov = ZKlavesnice.readInt(String.format("Zadaj počet hráčov od 2 do %d: ", MAX_POCET_HRACOV));
        while (true){
            if(pocetHracov < 2 || pocetHracov > 6){
                System.out.printf("Minimálny počet hráčov je 2 a maximálny počet hráčov je %d takže znova!\n", MAX_POCET_HRACOV);
                pocetHracov = ZKlavesnice.readInt(String.format("Zadaj počet hráčov od 2 do %d: ", MAX_POCET_HRACOV));
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

        inicializaciaZamerania();
        novePole();
        Collections.shuffle(balikHraciePole);
        novyBalik();
        Collections.shuffle(balikAkcneKarty);

        vypisPole();
        getHraci();
        rozdajKartyHracom();

        for (this.ktoJeNaTahu = 0; kolkoZijeHracov() > 1; this.prepniHraca()) {

            Hrac hracNaTahu = this.hraci[ktoJeNaTahu];
            if (!hracNaTahu.getHracZije()){
                hracNaTahu.hracZomrel(balikAkcneKarty);
                continue;
            }
            System.out.println("Tieto karty má " + hracNaTahu.getMeno() +" "+ hracNaTahu.getPoradoveCislo());
            hracNaTahu.coMaHracNaRuke(zamerane);
            hracNaTahu.hracZahralKartu(balikAkcneKarty,zamerane);

            vypisPole();
            getHraci();

        }
        vitazHry();
        System.out.println("Hra sa skončila");
        System.out.println("Jakub Chrappa ais: 111286");
    }

    private void rozdajKartyHracom(){
        for (Hrac hrac : hraci) {
            hrac.hracTahaKartu(balikAkcneKarty);
            hrac.hracTahaKartu(balikAkcneKarty);
            hrac.hracTahaKartu(balikAkcneKarty);
        }
    }

    private void novyBalik() {

        this.balikAkcneKarty = new ArrayList<>();

        for(int i = 10; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaZamierit(zamerane , balikHraciePole , hraci));
        }
        for(int i = 12; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaVystrelit(zamerane , balikHraciePole , hraci));
        }
        for(int i = 2; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaDivokyBill(zamerane , balikHraciePole , hraci));
        }
        for(int i = 2; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaRosambo(zamerane , balikHraciePole , hraci));
        }
        for(int i = 6; i > 0; i--){
            balikAkcneKarty.add(new AkcnaKartaKacaciPochod(zamerane , balikHraciePole , hraci));
        }
        balikAkcneKarty.add(new AkcnaKartaTurbokacka(zamerane , balikHraciePole , hraci));
        balikAkcneKarty.add(new AkcnaKartaKacaciTanec(zamerane , balikHraciePole , hraci));
    }

    private void inicializaciaZamerania() {
        this.zamerane = new boolean[6];
        Arrays.fill(zamerane, false);
    }

    private void novePole() {

        this.balikHraciePole = new ArrayList<>();

        for(int i = 5; i > 0; i--){
            balikHraciePole.add(new Voda());
        }

        for (Hrac hrac : hraci) {
            hrac.rozdajKacky(hrac, balikHraciePole);
        }
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

    private int kolkoZijeHracov() {
        int pocet = 0;
        for (Hrac hrac : this.hraci) {
            if (hrac.getHracZije()) {
                pocet++;
            }
        }
        return pocet;
    }

    private void prepniHraca() {
        this.ktoJeNaTahu ++;
        this.ktoJeNaTahu = (this.ktoJeNaTahu % pocetHracov);
    }

    private void getHraci() {
        for (int i = 0; i < pocetHracov; i++) {
            System.out.println(this.hraci[i].getMeno() +" "+ this.hraci[i].getPoradoveCislo() + " -> počet životov: " + this.hraci[i].getPocetKaciek());
        }
        System.out.println("---------------------------------");
    }

    private void vitazHry() {
        for (int i = 0; i < pocetHracov; i++) {
            if (this.hraci[i].getHracZije()) {
                System.out.println("Víťazom sa stáva : " + this.hraci[i].getMeno() + " " + this.hraci[i].getPoradoveCislo());
            }
        }
    }

    private void vypisPole() {
        System.out.println("toto je herne pole: ");
        for (int i = 0; i < 6 ; i++) {
            System.out.print((i+1) +" • ");

            if(zamerane[i]){
                System.out.print("✔️-> " + balikHraciePole.get(i).getMeno());
            }
            if(!zamerane[i]){
                System.out.print("❌️-> " + balikHraciePole.get(i).getMeno());
            }
            if(balikHraciePole.get(i) instanceof Kacka){
                System.out.println(" " + balikHraciePole.get(i).getMenoVlastnika() +" "+ balikHraciePole.get(i).getCisloVlastnika());
            }
            else{
                System.out.println();
            }
        }
        System.out.println("---------------------------------");
    }
}