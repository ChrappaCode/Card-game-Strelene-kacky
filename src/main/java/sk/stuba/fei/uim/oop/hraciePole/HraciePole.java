package sk.stuba.fei.uim.oop.hraciePole;

public abstract class HraciePole {

    protected String meno;

    public HraciePole(String meno){
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

}
