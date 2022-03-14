package sk.stuba.fei.uim.oop.akcnekarty.strelba;

import sk.stuba.fei.uim.oop.akcnekarty.AkcneKarty;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.hraciepole.HraciePole;
import sk.stuba.fei.uim.oop.hraciepole.Kacka;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class AkcnaKartaDivokyBill extends AkcneKarty {


    private static final String MENO = "Divoky Bill";

    public AkcnaKartaDivokyBill(boolean[] zamerane , ArrayList<HraciePole> pole , Hrac[] hraci){
        super(MENO , zamerane , pole , hraci);
    }

    @Override
    public void pouzil(Hrac hrac) {

        int b = ZKlavesnice.readInt("Na ktoré políčko chcete vystreliť ?");

        if(pole.get(b-1) instanceof Kacka){
            hraci[pole.get(b-1).getCisloVlastnika() - 1].hracDostalZasah();
            pole.remove(b-1);
        }

        zamerane[b-1] = false;

    }

}


