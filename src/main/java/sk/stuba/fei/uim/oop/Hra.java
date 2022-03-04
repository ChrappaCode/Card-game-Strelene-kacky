package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Hra {

    public static final int MAX_POCET_HRACOV = 6;
    private final Hrac[] hraci;

    public Hra(){

        System.out.println("Strelené Kačky Jakub Chrappa");
        int pocetHracov = KeyboardInput.readInt(String.format("Zadaj pocet hracov od 2 do %d", MAX_POCET_HRACOV));
        System.out.println("Počet hráčov je : "+ pocetHracov);
        this.hraci = new Hrac[pocetHracov];
        startHry();
    }

    private void startHry() {

        System.out.println("Hra sa začala");
    }

}
