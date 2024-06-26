import java.util.Scanner;

public class App {
    static Scanner tb = new Scanner(System.in);
    final double PRIS_VUXEN = 299.90;
    final double PRIS_BARN = 149.90;
    public static void main(String[] args) throws Exception {
        boolean loop = true;
        int index = 0;
        int[] bokning_nr = new int[20];
        for (int i = 0; i < bokning_nr.length; i++) {
            bokning_nr[i] = 0;
        }
        String[] bokning_namn = new String[20];
        for (int i = 0; i < bokning_namn.length; i++) {
            bokning_namn[i] = "0";
        }
        double[] priser = new int[20];
        for (int j = 0; j < priser.length; j++) {
            priser[i] = 0;
        }
        String[][] visa_platser = new String[5][4];
        int x = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                visa_platser[i][j] = String.valueOf(x);
                x++;
            }
        }
        double total_vinst = beräkna_vinst(priser, index);
        while (loop) {
            System.out.println("Hej! Välj en tjänst från listan nedan!");
            visa_meny(priser, index, bokning_nr, bokning_namn, visa_platser);
        }
    }

    public static void visa_meny(double[] priser, int index, int[] bokning_nr, String[] bokning_namn, String[][] visa_platser){
        int val = tb.nextInt();
        try {
            val = tb.nextInt();
        } 
        catch (Exception e) {
            System.out.println("Välj en tjänst med dess siffra.");
        }
        System.out.println("1. Boka en plats på bussen.");
        System.out.println("2. Hitta/ändra bokning.");
        System.out.println("3. Visa passagerare");
        System.out.println("4. Beräkna vinst av biljetter.");
        System.out.println("5. Avsluta.");
        while (val>5 || val=0) {
            System.out.println("Välj en tjänst med dess siffra.");
        }
        switch (val) {
            case 1:
                boka_plats(bokning_nr, bokning_namn, priser, visa_platser);
                break;
            case 2:
                hitta_bokning();
                break;
            case 3:
                visa_passagerare(bokning_namn, bokning_nr);
                break;
            case 4:
                beräkna_vinst(priser, index);
                break;
            case 5:
                avsluta();
                break;
        }
    }
    
    
    public static void boka_plats(int[] bokning_nr, String[] bokning_namn, int[] priser, String[] visa_platser){
        System.out.println("Ange ditt födelsedatum ÅÅÅÅMMDD:");
        int person_nr = tb.nextInt();
        while (person_nr<10000000 || person_nr>=100000000) {
            System.out.println("Ange ditt födelsedatum ÅÅÅÅMMDD:");
            person_nr = tb.nextInt();
        }
        System.out.println("Ange ditt namn:");
        String namn = tb.nextLine();
        
        System.out.println("Välj en plats att boka:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(visa_platser[i][j]);
            }
        }
        int val = 0;
        while (val>20 || val==0) {
            System.out.println("Skriv en siffra mellan 1-20.");
            try {
                val = tb.nextInt();
                tb.nextLine();
            } catch (Exception e) {
                System.out.println("Skriv en siffra mellan 1-20.");
                val = 0;
                tb.nextLine();
            }
            if (bokning_nr[val] != 0 || bokning_namn[val] != "0") {
                System.out.println("Platsen är redan upptagen:");
                val=0;
                tb.nextLine();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                visa_platser[i][j] = "X";
                if (String.valueOf(val) == visa_platser[i][j]) {
                    continue;
                }
            }
        }
        bokning_namn[val] = namn;
        bokning_nr[val] = person_nr;
        if (person_nr>20060502) {
            priser[val] = PRIS_BARN;
        }
        else if (person_nr<20060502) {
            priser[val] = PRIS_VUXEN;
        }
    }

    public static boolean avsluta(){
        return false;
    }

    public static int beräkna_vinst(double[] priser, int index){
        if (priser.length > index) {
            int pris = priser[index];
            index++;
            return pris+beräkna_vinst(priser, index);
        }
        else{
            return 0;
        }
    }

    public static void visa_passagerare(String[] bokning_namn, int[] bokning_nr){
        for (int i = 0; i < bokning_nr.length; i++) {
            if (bokning_nr[i] == 0) {
                break;
            }
            System.out.print(bokning_nr);
            System.out.print(bokning_namn);
        }
    }
}
