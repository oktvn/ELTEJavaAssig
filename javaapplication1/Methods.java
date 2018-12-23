package javaapplication1;


import javaapplication1.models.Kid;
import javaapplication1.models.Oompa;
import javaapplication1.models.GoldenTicket;
import javaapplication1.models.Product;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import javaapplication1.models.OompaLoompaSong;

public class Methods {
    
    public static List<Kid> kids = new ArrayList<Kid>();
    public static List<Oompa> oompas = new ArrayList<Oompa>();
    private static ArrayList<GoldenTicket> tickets = new ArrayList<>();
    public static List<Product> products = new ArrayList<Product>();
    
    static Scanner scanner = new Scanner(System.in);
    // Random name
    
    // Dead code. Discovered half-way that my randomization approach (no user input needed)
    // was not entirely suitable for solving this assignment
    public String generateRandomNames() {
        String[] firstnames = new String[]{"John", "Mary", "Joseph", "Ryan"
        , "Robert", "Steve", "Lia", "Mandy", "Jeffrey"};
        String[] lastnames = new String[]{"E.", "R.", "C.", "Q."
        , "L.", "A.", "O.", "W.", "F."};
        Random rand = new Random();
        return  firstnames[rand.nextInt(firstnames.length)] + " " +
                lastnames[rand.nextInt(lastnames.length)];
    }
    public Product generateRandomProducts() {
        String[] descriptions = new String[]{"Milk chocolate", "Dark chocolate", "White chocolate"};
        long[] barcodes = new long[]{123, 456, 789};
        int serialnr = new Random().nextInt(999999);
        String[] serialletter = new String[]{"E", "R", "C", "Q"
        , "L", "A", "O", "W", "F"};
        Random rand = new Random();
        String serial = "" + serialletter[rand.nextInt(serialletter.length)] + serialnr;
        String description = descriptions[rand.nextInt(descriptions.length)];
        long barcode = barcodes[rand.nextInt(barcodes.length)];
        Product prod = new Product(description, barcode, serial, null);
        return prod;
    }

    
    public void addRandomProducts(int numberOfProds) {
        for (int i=0; i < numberOfProds; i++) {
            products.add(generateRandomProducts());
        }
    }
    
    public void goldenTicketsDistri(int numberOfProds) {
        for (int i=0; i < 5; i++) {
            GoldenTicket ticket = new GoldenTicket();
            Random rand = new Random();
            products.get(rand.nextInt(products.size())).setPrizeTicket(ticket);
        }
    }
    
    public void listProducts(int numberOfProds) {
        for (int i=0; i < numberOfProds; i++) {
            System.out.println(products.get(i).toString());
        }
    }
    
    public void generatePeople(int numberOfSales) {
        for (int i=0; i < numberOfSales; i++) {
            Kid kid = new Kid(generateRandomNames());
            kids.add(kid);
        }
        for (int i=0; i < numberOfSales; i++) {
            System.out.println(kids.get(i).getName() + " " + kids.get(i).getCode());
        }
    }

    public void promptEnterKey(){
        System.out.println("Press 'Enter' to continue...");
        Scanner scanner2 = new Scanner(System.in);
        scanner2.nextLine();
    }
    
    public void listTickets(){
        boolean found = false;
        for (int i=0; i < products.size(); i++) {
            if (products.get(i).getPrizeTicket() != null){
                System.out.println(products.get(i).getSerialNumber());
                found = true;
            } 
        }
        if (!found) {
            System.out.println("No golden tickets found! Please run the randomized ticket distribution first (Option 1).");
        }
    }
    
    public void registerSaleTicket() {
        System.out.println("Please provide the child's ID: ");
        int childID = scanner.nextInt();
        System.out.println("Please provide the product ID: ");
        String productID = scanner.next();
        for (int i=0; i < kids.size(); i++) {
            if (products.get(i).getPrizeTicket() != null){
                System.out.println(products.get(i).getSerialNumber());
            } 
        }
    }
    
    // Dead code end
    
    //-----------------------------------------
    
    public void registerPrizeTickets() {
        System.out.println("Ticket serial number (alphanumeric):");
        String ticketCode = scanner.next();
        System.out.println("Raffled date (DD/MM/YYYY):");
        String date = scanner.next();
        try {
            GoldenTicket newTicket = new GoldenTicket(ticketCode, date);
            tickets.add(newTicket);
            System.out.println("The " + ticketCode + " golden ticket was added.");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public void listPrizeTickets() {
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i));
        }
    }

    public void listRaffledTickets() {
        boolean found = false;
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getRaffled()) {
                System.out.println(tickets.get(i));
                found = true;
            } else if (!found) {
               System.out.println("None found.");
            } 
        }
    }
    
    public void newSong() {
        System.out.println("How many lines do you want it to be:");
        int lines = scanner.nextInt();
        OompaLoompaSong song = new OompaLoompaSong(lines);
        song.sing();
    }
    
    public void registerBeings(String type) {
        System.out.println("Write the name of the "+type+": ");
        String name = scanner.next();
        if (type.equals("kid")) {
            kids.add(new Kid(name));
        } else {
            oompas.add(new Oompa(name));    
        }
        System.out.println("The "+type+" was added successfully!");
    }
    
    
    public void registerProducts() {
        System.out.println("Description: ");
        String description = scanner.next();
        System.out.println("Barcode: ");
        long barcode = scanner.nextInt();
        System.out.println("Serial number: ");
        String sn = scanner.next();

        Product product = new Product(description, barcode, sn, null);

        try {
            products.add(product);
            System.out.println("The product was added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void raffleTicket() {
        System.out.println("How many golden tickets should be put into play out of existing " + tickets.size() + "?");
        int intoPlay = scanner.nextInt();
        if (intoPlay  <= tickets.size() && products.size()>0) {
            for (int i=0; i < intoPlay; i++) {
                Random rand = new Random();
                int randIndex = rand.nextInt(tickets.size());
                tickets.get(randIndex).setRaffled();
                    for (int j = 0; j < products.size(); j++) {
                        if (products.get(j).getSerialNumber() == tickets.get(randIndex).getCode()) {
                            products.get(j).setPrizeTicket(tickets.get(randIndex));
                        }
                    }
            }
        } else {
            System.out.println("Please add sufficient golden tickets to begin with.");
        }
    }
    
    public void registerSale() {
        System.out.println("Write the code of the creature: ");
        int code = scanner.nextInt();
        System.out.println("Write the barcode of the product: ");
        long barcode = scanner.nextInt();

        ArrayList<Product> picked = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getBarcode() == barcode) {
                picked.add(products.get(i));
            }
        }

        Random rand = new Random();
        int index = rand.nextInt(picked.size());
        Product product = picked.get(index);

        for (int i = 0; i < kids.size(); i++) {
            if (kids.get(i).getCode() == code) {
                kids.get(i).addProducts(product);
            }
        }

        // Removing
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getBarcode() == barcode) {
                products.remove(products.get(i));
            }
        }
    }
    
    public void listWinners() {
        System.out.println("Winners:\n");
        for (int i = 0; i < kids.size(); i++) {
            for (int j = 0; j < kids.get(i).getProducts().size(); j++) {
                if (!kids.get(i).getProducts().isEmpty()) {
                    if (kids.get(i).getProducts().get(j).getPrizeTicket().getRaffled()) {
                        System.out.println(kids.get(i));
                    }
                }
            }
        }
    }
    
    public void listProducts() {
        System.out.println("Products:\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }
    
    public void listBeings() {
        System.out.println("Kids:\n");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i).toString() +"\n");
        }
        System.out.println("Oompas:\n");
        for (int i = 0; i < oompas.size(); i++) {
            System.out.println(oompas.get(i).toString() +"\n");
        }
    }

}
