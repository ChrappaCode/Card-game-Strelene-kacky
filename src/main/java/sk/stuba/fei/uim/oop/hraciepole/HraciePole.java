package sk.stuba.fei.uim.oop.hraciepole;

public abstract class HraciePole {

    protected String meno;
    protected int cisloVlastnika;

    public HraciePole(String meno , int poradoveCislo){
        this.meno = meno;
        this.cisloVlastnika = poradoveCislo;
    }

    public String getMeno() {
        return meno;
    }

    public int getCisloVlastnika() {
        return cisloVlastnika;
    }
}
