package sk.stuba.fei.uim.oop.streleneKacky;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcneKarty.pohyb.AkcnaKartaKacaciPochod;
import sk.stuba.fei.uim.oop.akcneKarty.pohyb.AkcnaKartaKacaciTanec;
import sk.stuba.fei.uim.oop.akcneKarty.pohyb.AkcnaKartaRosambo;
import sk.stuba.fei.uim.oop.akcneKarty.pohyb.AkcnaKartaTurbokacka;
import sk.stuba.fei.uim.oop.akcneKarty.zamierenieStrelba.AkcnaKartaDivokyBill;
import sk.stuba.fei.uim.oop.akcneKarty.zamierenieStrelba.AkcnaKartaVystrelit;
import sk.stuba.fei.uim.oop.akcneKarty.zamierenieStrelba.AkcnaKartaZamierit;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;



public class StreleneKacky {

    public static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;
    private int pocetHracov;
    private int hracNaTahu = 0;
    ArrayList<AkcneKarty> balikAkcneKarty;

    public StreleneKacky(){

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


        //akcneKarty.pouzil(this.hraci[1]);

        //System.out.println(this.hraci[1].getAkcneKarty());

        novyBalik();
        startHry();
    }

    private void startHry() {

        System.out.println("Hra sa začala");

        //kod here

        System.out.println("Hra sa skončila");
        vitazHry();  //funguje to len nechcem ten vypis teraz
        System.out.println("Jakub Chrappa ais: 111286");

    }

    private void novyBalik(){

        this.balikAkcneKarty = new ArrayList<>();

        balikAkcneKarty.add(new AkcnaKartaDivokyBill());
        balikAkcneKarty.add(new AkcnaKartaDivokyBill());
        balikAkcneKarty.add(new AkcnaKartaDivokyBill());
        balikAkcneKarty.add(new AkcnaKartaVystrelit());
        balikAkcneKarty.add(new AkcnaKartaVystrelit());
        balikAkcneKarty.add(new AkcnaKartaVystrelit());

    }

    private void generujHracov(){

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
        this.hracNaTahu ++;
        System.out.println(this.hracNaTahu);
        this.hracNaTahu = (this.hracNaTahu % pocetHracov);
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
}
