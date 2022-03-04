package sk.stuba.fei.uim.oop.streleneKacky;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.Objects;

public class StreleneKacky {

    public static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;
    private int pocetHracov;
    private int hracNaTahu = 0;

    public StreleneKacky(){

        System.out.println("Strelené Kačky Jakub Chrappa");
        this.pocetHracov = KeyboardInput.readInt(String.format("Zadaj pocet hracov od 2 do %d", MAX_POCET_HRACOV));
        while (true){
            if(pocetHracov < 2 || pocetHracov > 6){ //aby nedal menej ako 2 a viac ako 6
                pocetHracov = KeyboardInput.readInt(String.format("Zadaj pocet hracov od 2 do %d", MAX_POCET_HRACOV));
                continue;
            }
            this.hraci = new Hrac[pocetHracov];
            break;
        }
        for (int i = 0; i < pocetHracov; i++) {                             //tu si vytvorim hracov
            this.hraci[i] = new Hrac(i + 1);
        }

        System.out.println("Počet hráčov je : " + pocetHracov);
        getHraci();
        startHry();
    }

    private void startHry() {

        System.out.println("Hra sa začala");

        //kod here

        System.out.println("Hra sa skončila");
        //vitazHry();  //funguje to len nechcem ten vypis teraz

    }

    private void prepniHraca() {
        this.hracNaTahu ++;
        System.out.println(this.hracNaTahu);
        this.hracNaTahu = (this.hracNaTahu % pocetHracov);
    }


    public void getHraci() {
        System.out.println("Dnes hrá : ");
        for (int i = 0; i < pocetHracov; i++) {
            System.out.println(this.hraci[i].getMeno() + this.hraci[i].getPoradoveCislo());
        }
    }

    private void vitazHry() {
        for (int i = 0; i < pocetHracov; i++) {
            if (this.hraci[i].isHracZije()) {
                System.out.println("Vyhral hráč s poradovím číslom: " + this.hraci[i].getPoradoveCislo());
            }
        }
    }
}
