package javaapplication1;
import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {
        /*
        Select from list:
        1- Say hi
        2- Say bye
        3- Add word
        4- List words
        */
    
    
    int option = 0;
    
    
    /*System.out.println("This is a Willy Wonka Golden Ticket Lottery Simulator" + "\nUse at your own risk!");
    //utils.promptEnterKey();
    System.out.println("Enter the number of chocolate bars in the lottery");
    chocolateBars = scanner.nextInt();
    System.out.println("Enter the number of sales you expect to have");
    numberOfSales = scanner.nextInt();*/

    //utils.addRandomProducts(chocolateBars);
    
 
    //utils.generatePeople(numberOfSales);

    //utils.promptEnterKey();
    /*System.out.println("The program will now randomly distribute each of the " + 
            numberOfSales + " chocolate bars to the children.");
    */
    // "Distribution complete"
    // Switch:List the winners, List the prize tickets, List all tickets
    // Switch: create oompa loompa song
    
    // When listing the winners: Name, date, GT code, type of product
    Scanner scanner = new Scanner(System.in);
    Methods utils = new Methods();

    do {
        System.out.println(
            "Choose your weapon: "
            + "\n  1 - Register prize tickets "
            + "| 2 - List all prize tickets "
            + "| 3 - List only redeemed tickets "
            + "| 4 - Create new OL song "
            + "| 5 - Register beings"
            + "\n  6 - Register products "
            + "| 7 - Raffle tickets "
            + "| 8 - Register sale "
            + "| 9 - List winners "
            + "| 10 - List products"
            + "| 11 - List children"
            + "");
        
        option = scanner.nextInt();
        
        switch (option) {
            case 1:
                //utils.goldenTicketsDistri(chocolateBars);
                //System.out.println("The 5 golden tickets have been randomly distributed");
                utils.registerPrizeTickets();
                break;
            case 2:
                utils.listPrizeTickets();
                //utils.listTickets();
                break;
            case 3:
                utils.listRaffledTickets();
                break;
            case 4:
                utils.newSong();
                break;
            case 5:
                String type;
                System.out.println("It can be either 'kid' or 'oompa'. Enter your choice.");
                type = scanner.next();
                switch(type) {
                    case "oompa":
                        utils.registerBeings("oompa");
                        break;
                    case "kid":
                        utils.registerBeings("kid");
                        break;
                    default:
                        System.out.println("Didn't get that. It can be either 'kid' or 'oompa'");
                        break;
                }
                    break;
            case 6:
                utils.registerProducts();
                break;
            case 7:
                utils.raffleTicket();
                break;
            case 8:
                utils.registerSale();
                break;
            case 9:
                utils.listWinners();
                break;
            case 10:
                utils.listProducts();
                break;
            case 11:
                utils.listBeings();
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong Option");
        }

            
    }while(option!=0);
    
    }
    
}
