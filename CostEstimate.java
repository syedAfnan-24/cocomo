import java.util.*;

public class CostEstimate{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Kilo Lines of code: ");
        int kloc = in.nextInt();
        in.close();
        cocomo(kloc);
    }

    public static void cocomo(int kloc){
        System.out.println("\n\tCOCOMO\t");
        double effort,time,ppl,productivity;
        int model = 0;
        double table[][] = {{2.4,1.05,2.5,0.38},{3.0,1.12,2.5,0.35},{3.6,1.20,2.5,0.32}};

        if(kloc>=2 && kloc <=50){
            System.out.println("\n___Organic Software Model___\n");
            model = 0;
        }else if(kloc>50 && kloc<=300){
            System.out.println("\n___Semi Detached Software Model___\n");
            model = 1;
        }else if(kloc>300){
            System.out.println("\n___Embedded Software Model___\n");
            model = 2;
        }

        effort = table[model][0] * Math.pow(kloc, table[model][1]);
        time = table[model][2] * Math.pow(effort, table[model][3]);
        ppl = (effort/time) + 0.5;
        int staff = (int)ppl;
        productivity = kloc/effort;

        System.out.println("Effort: "+effort+" Per Month");
        System.out.println("time: "+time+" Months");
        System.out.println("No. People Required: "+staff+" Person");
        System.out.println("productivity: "+productivity+" LOC/PM\n");
    }
}

