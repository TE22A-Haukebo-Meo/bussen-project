import java.util.Scanner;
static Scanner tb = new Scanner(System.in);

public class App {
    public static void main(String[] args) throws Exception {
        
        boolean loop = true;
        int[][] bokning = new int[5][4];
        int[] priser = new int[20];
        String[][] visa_platser = new String[5][4];
        while (loop) {
            System.out.println("Hej! Välj en tjänst från listan nedan!");
            visa_meny();
        }
        
    }

    public static void visa_meny(){
        
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
        while (true) {
            if (val>5) {
                System.out.println("Välj en tjänst med dess siffra.");
            }
        }
        switch (val) {
            case 1:
                boka_plats();
                break;
            case 2:
                hitta_bokning();
                break;
            case 3:
                visa_passagerare();
                break;
            case 4:
                beräkna_vinst();
                break;
            case 5:
                avsluta();
                break;
        }
    }
    
    public static int boka_plats(){
        System.out.println("Ange ditt födelsedatum ÅÅÅÅMMDD:");
        int person_nr = tb.nextInt();
        while (person_nr<10000000 || person_nr>=100000000) {
            System.out.println("Ange ditt födelsedatum ÅÅÅÅMMDD:");
            person_nr = tb.nextInt();
        }
        
    }

    public static boolean avsluta(){
        return false;
    }
}
