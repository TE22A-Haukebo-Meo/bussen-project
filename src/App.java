import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Hej! Välj en tjänst från listan nedan!");
            visa_meny();
        }
        
    }
    public static void visa_meny(){
        Scanner tb = new Scanner(System.in);
        int val = tb.nextInt();
        switch (val) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
}
