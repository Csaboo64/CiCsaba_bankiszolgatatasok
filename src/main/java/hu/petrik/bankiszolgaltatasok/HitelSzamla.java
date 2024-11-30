package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final int hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelkeret) {
        super(tulajdonos);
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív.");
        }
        this.hitelkeret = hitelkeret;
    }

    public int getHitelkeret() {
        return hitelkeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (this.egyenleg - osszeg >= -this.hitelkeret) {
            this.egyenleg -= osszeg;
            return true;
        }
        return false;
    }

    @Override
    public Kartya ujKartya(String kartyaszam) {
        return null;
    }
}

