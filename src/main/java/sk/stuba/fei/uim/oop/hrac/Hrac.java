package sk.stuba.fei.uim.oop.hrac;

public class Hrac {

    private final String meno;
    private final int poradoveCislo;
    private int pocetZivotov;
    private boolean hracZije;

    public Hrac(String meno ,int poradoveCislo) {
        this.meno = meno;
        this.poradoveCislo = poradoveCislo;
        this.pocetZivotov = 5;
        this.hracZije = true;
    }

    public boolean zabiHraca() {
        hracZije = false;
        return hracZije;
    }

    public boolean isHracZije() {
        return hracZije;
    }

    public String getMeno() {
        return meno;
    }
    public int getPoradoveCislo() {
        return poradoveCislo;
    }
}
