package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcnekarty.pohyb.*;
import sk.stuba.fei.uim.oop.akcnekarty.strelba.*;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.hraciepole.Kacka;
import sk.stuba.fei.uim.oop.hraciepole.Voda;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Arrays;



public class StreleneKacky {

    public static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;
    private int pocetHracov;
    private int ktoJeNaTahu = 0;
    private ArrayList<AkcneKarty> balikAkcneKarty;
    private ArrayList<HraciePole> balikHraciePole;
    private boolean[] zamerane;

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

        inicializaciaZamerania();
        novePole();
        zamiesajKarty(balikHraciePole);
        novyBalik();
        zamiesajKarty();



        vypisBalikPole();
        vypisPole();

        balikHraciePole.add(balikHraciePole.get(0));
        balikHraciePole.remove(0);

        vypisPole();

        System.out.println("hraje " + pocetHracov + " hracov " + "preto máme " + (balikHraciePole.size() - 5) + " utiek");

        System.out.println();


        Hrac hracNaTahu = this.hraci[ktoJeNaTahu];


        hracNaTahu.hracTahaKartu(balikAkcneKarty);
        hracNaTahu.hracTahaKartu(balikAkcneKarty);
        hracNaTahu.hracTahaKartu(balikAkcneKarty);

        System.out.println("Tieto karty má " + hracNaTahu.getMeno() +" "+ hracNaTahu.getPoradoveCislo());

        hracNaTahu.daSaZahrat(zamerane);
        hracNaTahu.coMaHracNaRuke();
        hracNaTahu.hracZahralKartu(balikAkcneKarty);
        hracNaTahu.coMaHracNaRuke();

        vypisPole();

        hracNaTahu.daSaZahrat(zamerane);
        hracNaTahu.coMaHracNaRuke();
        hracNaTahu.hracZahralKartu(balikAkcneKarty);
        hracNaTahu.coMaHracNaRuke();

        vypisPole();


        hracNaTahu.daSaZahrat(zamerane);
        hracNaTahu.coMaHracNaRuke();
        hracNaTahu.hracZahralKartu(balikAkcneKarty);
        hracNaTahu.coMaHracNaRuke();

        vypisPole();


        getHraci();
        prepniHraca();
        System.out.println(ktoJeNaTahu);

        vitazHry();  //funguje to len nechcem ten vypis teraz
        System.out.println("Hra sa skončila");
        System.out.println("Jakub Chrappa ais: 111286");
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

    public void inicializaciaZamerania() {
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

    private void prepniHraca() {
        this.ktoJeNaTahu ++;
        System.out.println(this.ktoJeNaTahu);
        this.ktoJeNaTahu = (this.ktoJeNaTahu % pocetHracov);
    }


    private void getHraci() {
        for (int i = 0; i < pocetHracov; i++) {
            System.out.println(this.hraci[i].getMeno() +" "+ this.hraci[i].getPoradoveCislo() + " -> počet životov: " + this.hraci[i].getPocetKaciek());
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

    private void zamiesajKarty(ArrayList<HraciePole> balikHraciePole) {
        for (int i = 0; i < balikHraciePole.size(); i++) {
            int nahodnaPremenna = (int)(Math.random() * balikHraciePole.size());
            HraciePole temp = balikHraciePole.get(i);
            balikHraciePole.set(i, balikHraciePole.get(nahodnaPremenna));
            balikHraciePole.set(nahodnaPremenna, temp);
        }
    }

    private void vypisBalicekAkcnychKariet() {
        System.out.println("toto je balik akcnych kariet: ");
        for (AkcneKarty akcneKarty : balikAkcneKarty) {
            System.out.println("• " + akcneKarty.getMeno());
        }
        System.out.println("------------------------");
    }

    private void vypisBalikPole() {
        System.out.println("toto je balik kariet pola: ");
        for (HraciePole hraciePole : balikHraciePole) {
            System.out.println("• " + hraciePole.getMeno());
        }
        System.out.println("------------------------");
    }

    private void vypisPole() {
        System.out.println("toto je herne pole: ");
        for (int i = 0; i < 6 ; i++) {
            System.out.print((i+1) +" • " + balikHraciePole.get(i).getMeno());
            if(balikHraciePole.get(i) instanceof Kacka){
                System.out.print(" " +  balikHraciePole.get(i).getCisloVlastnika());
            }
            System.out.println(" -> " + zamerane[i]);

        }
        System.out.println("------------------------");
    }

    public boolean[] getZamerane() {
        return zamerane;
    }
}
