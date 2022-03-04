package sk.stuba.fei.uim.oop.streleneKacky;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.Objects;

public class StreleneKacky {

    public static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;
    private int pocetHracov;

    public StreleneKacky(){

        System.out.println("Strelené Kačky Jakub Chrappa");
        this.pocetHracov = KeyboardInput.readInt(String.format("Zadaj pocet hracov od 2 do %d", MAX_POCET_HRACOV));
        while (true){
            if(pocetHracov < 2 || pocetHracov > 6){
                pocetHracov = KeyboardInput.readInt(String.format("Zadaj pocet hracov od 2 do %d", MAX_POCET_HRACOV));
                continue;
            }
            this.hraci = new Hrac[pocetHracov];
            break;
        }
        for (int i = 0; i < pocetHracov; i++) {
            this.hraci[i] = new Hrac("Hráč ", i + 1);
        }
        System.out.println("Počet hráčov je : " + pocetHracov);
        getHraci();
        startHry();
    }

    private void startHry() {

        System.out.println("Hra sa začala");

        System.out.println("Hra sa skončila");
        System.out.println("Vyhral " + Objects.requireNonNull(vitazHry()).getMeno() + Objects.requireNonNull(vitazHry()).getPoradoveCislo());

    }

    public void getHraci() {
        System.out.println("Dnes hrá : ");
        for (int i = 0; i < pocetHracov; i++) {
            System.out.println(this.hraci[i].getMeno() + this.hraci[i].getPoradoveCislo());
        }
    }

    private Hrac vitazHry() {
        for (int i = 0; i < pocetHracov; i++) {
            if (this.hraci[i].isHracZije()) {
                return this.hraci[i];
            }
        }
        return null;
    }
}
