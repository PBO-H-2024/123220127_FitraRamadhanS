
import java.util.*;
import BangunRuang.*;
public class Main {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        while (true) {
            System.out.println("1. Limas Segitiga");
            System.out.println("2. Tabung");
            System.out.println("3. Exit");

            System.out.print(">> ");
            String input = scannerObj.next();
            if(input.equals("1")){
                hitungLimas(scannerObj);
            }else if(input.equals("2")){
                hitungTabung(scannerObj);
            }else if(input == "3"){
                scannerObj.close();
                return;
            }
            System.out.print("\nPress Enter To Continue");
            scannerObj.nextLine();
            scannerObj.nextLine();
        }
     }   

     public static void hitungLimas(Scanner scannerObj){
        System.out.println("\nINPUT");
        System.out.print("Input Tinggi Alas\t: ");
        double tinggiAlas = scannerObj.nextDouble();
        System.out.print("Input Alas \t\t: ");
        double alas = scannerObj.nextDouble();
        System.out.print("Input Tinggi Limas\t: ");
        double tinggiLimas = scannerObj.nextDouble();

        System.out.println("\nOUTPUT");
        Limas limas = new Limas(tinggiAlas, alas, tinggiLimas);
        System.out.println("Luas Segitiga\t\t: " + limas.luas());
        System.out.println("Keliling Segitiga\t: " + limas.keliling());
        System.out.println("Volume Limas\t\t: " + limas.volume());
        System.out.println("LuasPermukaan Limas\t: " + limas.luasPermukaan());
     }

     public static void hitungTabung(Scanner scannerObj){
        System.out.println("\nINPUT");
        System.out.print("Input Jari-Jari\t\t: ");
        double jari2 = scannerObj.nextDouble();
        System.out.print("Input Tinggi Tabung\t: ");
        double tinggi = scannerObj.nextDouble();
        
        System.out.println("\nOUTPUT");
        Tabung tabung = new Tabung(jari2, tinggi);
        System.out.println("Luas Lingkaran\t\t: " + tabung.luas());
        System.out.println("Keliling Lingkaran\t: " + tabung.keliling());
        System.out.println("Volume Tabung\t\t: " + tabung.volume());
        System.out.println("LuasPermukaan Tabung\t: " + tabung.luasPermukaan());
     }
}


