package BangunDatar;

public class Lingkaran {
    double phi, jari2;

    public Lingkaran(double jari2){
        this.jari2 = jari2;
        this.phi = 22.0/7.0;
    }

    public double luas(){
        return phi * this.jari2 * this.jari2;
    }

    public double keliling(){
        return 2 * phi * jari2;
    };
}
