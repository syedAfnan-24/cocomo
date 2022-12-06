/*Cocomo Model - for Cost Estimation of Software Projects
    Authors: Syed Afnan 
             Pushpesh
             Mustaqeem
    Development Date: 6th . December 2022
*/
import java.util.*;

public class CostEstimate{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        //Taking Input as Lines of Codes required for the software Project
        System.out.print("Enter the Kilo Lines of code: ");
        int kloc = in.nextInt();
        in.close();
        
        //Function implementing Cocomo for cost Estimation
        cocomo(kloc);
    }

    public static void cocomo(int kloc){
        System.out.println("\n\tCOCOMO\t");
        double effort,time,ppl,productivity;
        
        //initializing software model type to the most basic type that is the 0 model -  organic software model
        int model = 0; 
        //this is a table defining a,b,c,d constants for calculation efforts and time
        double table[][] = {{2.4,1.05,2.5,0.38},{3.0,1.12,2.5,0.35},{3.6,1.20,2.5,0.32}}; 

        if(kloc>=2 && kloc <=50){ 
            //for kloc lying between 2 and 50
            System.out.println("\n___Organic Software Model___\n");
            model = 0;  //model = 0 represents organic
        }
        else if(kloc>50 && kloc<=300){
            //for kloc lying between 50 and 300
            System.out.println("\n___Semi-Detached Software Model___\n");
            model = 1; //model = 1 represents Semi-Detached
        }
        else if(kloc>300){ 
            //for kloc Greater than 300
            System.out.println("\n___Embedded Software Model___\n");
            model = 2;//model = 2 represents Embedded Software Model
        }

        //formula implementation

        //effort = a(kloc)^b
        effort = table[model][0] * Math.pow(kloc, table[model][1]);
        
        //time = c(effort)^d
        time = table[model][2] * Math.pow(effort, table[model][3]);
        
        //number of people reqired = effort / time + 0.5
        ppl = (effort/time) + 0.5;
        int staff = (int)ppl; 
        
        //productivity = lines of code / effort
        productivity = kloc/effort;

        //output
        System.out.println("Effort: "+effort+" Per Month");
        System.out.println("time: "+time+" Months");
        System.out.println("No. People Required: "+staff+" Person");
        System.out.println("productivity: "+productivity+" LOC/PM\n");
    }
}

