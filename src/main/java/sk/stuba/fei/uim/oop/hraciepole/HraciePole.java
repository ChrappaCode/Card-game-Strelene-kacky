package sk.stuba.fei.uim.oop.hraciepole;

public abstract class HraciePole {

    protected String meno;
    protected int cisloVlastnika;
    protected String menoVlastnika;

    public HraciePole(String meno ,String menoVlastnika , int poradoveCislo){
        this.meno = meno;
        this.menoVlastnika = menoVlastnika;
        this.cisloVlastnika = poradoveCislo;
    }

    public String getMeno() {
        return meno;
    }

    public int getCisloVlastnika() {
        return cisloVlastnika;
    }

    public String getMenoVlastnika() {
        return menoVlastnika;
    }
}
