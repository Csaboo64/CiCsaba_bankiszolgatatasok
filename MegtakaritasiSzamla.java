package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;
    private static double alapKamat = 1.1;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    @Override
    public Kartya ujKartya(String kartyaszam) {
        return null;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (this.egyenleg - osszeg >= 0) {
            this.egyenleg -= osszeg;
            return true;
        }
        return false;
    }

    public void kamatJovairas() {
        this.egyenleg *= (int) this.kamat;
    }
}

