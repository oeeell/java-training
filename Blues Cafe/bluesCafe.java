import java.util.Scanner;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

import java.security.Key;
import java.util.ArrayList;

public class bluesCafe {
    Scanner input = new Scanner(System.in);

    ArrayList<customerTable> tables = new ArrayList<customerTable>();

    double totalCash = 0;

    public void addOrder() {

        // table number input
        System.out.print("Input table number : ");
        while (!input.hasNextInt()) {
            System.out.println("Input error.");
            System.out.println("Input table number : ");
            input.next();
        }
        int tableNumber = input.nextInt();
        input.nextLine();
        // newTable.tableNumber = tableNumber;

        customerTable defTableNumber = new customerTable(tableNumber);

        char key;
        double calculatedPrice = 0;
        do {

            // order input
            System.out.print("Input order : ");
            while (input.hasNextInt()) {
                System.out.println("Input error.");
                System.out.print("Input Order : ");
                input.next();
                input.nextLine();
            }
            String orderName = input.nextLine();

            // gatekeeper
            // System.out.println("Order succeed.");

            // quantity input
            System.out.print("Input quantity : ");
            while (!input.hasNextInt()) {
                System.out.println("Input error.");
                System.out.print("Input quantity : ");
                input.next();
            }
            int orderQuantity = input.nextInt();
            input.nextLine();

            // gatekeeper
            // System.out.println("Quantity succeed.");

            // price per quantity input
            System.out.print("Input price (in one quantity) : Rp");
            while (!input.hasNextInt()) {
                System.out.println("Input error.");
                System.out.print("Input price (in one quantity) : ");
                input.next();
            }
            double orderPrice = input.nextDouble();
            input.nextLine();

            tableOrder newOrder = new tableOrder(orderName, orderPrice, orderQuantity);

            System.out.print("Do you want to add another order [y/n] ?\n>> ");
            key = Character.toLowerCase(input.nextLine().charAt(0));

            calculatedPrice = calculatedPrice + (orderQuantity * orderPrice);

            defTableNumber.addOrder(newOrder);

        } while (key == 'y');

        defTableNumber.setTotalFee(calculatedPrice);
        tables.add(defTableNumber);
    }

    public void showOrders() {

        for (customerTable list : this.tables) {
            System.out.println("\nTable : " + list.getTableNumber());
            System.out.println("==================================");
            System.out.println("Quantity    Name\tPrice ");
            System.out.println("==================================");

            for (tableOrder orderList : list.orders) {
                System.out.println(orderList.getFoodQuantity() + "\t    " + orderList.getFoodOrder() + "\t"
                        + "Rp" + orderList.getFoodPrice());

                /*
                 * System.out.println("Total fee : " + list.getTotalFee());
                 * System.out.println("Total fee with Tax : " + (list.getTotalFee() +
                 * (list.getTotalFee() * 0.10)));
                 * double test = list.getTotalFee() + (list.getTotalFee() * 0.10);
                 * System.out.println("Total FTax with Service: " + (test + (test * 0.075)));
                 */
            }
        }

    }

    public double removeOrder() {
        System.out.print("Table number : ");

        int tableNumberKey = 0;
        tableNumberKey = input.nextInt();
        input.nextLine();

        double price_withTax_andService, price_withTax, totalIncome;

        for (customerTable list : this.tables) {
            if (tableNumberKey == list.getTableNumber()) {
                price_withTax = list.getTotalFee() + (list.getTotalFee() * 0.10); // 11000
                price_withTax_andService = (price_withTax * 0.075); // 750
                totalIncome = price_withTax + price_withTax_andService;
                this.tables.remove(list);
                return totalIncome;
            }
        }

        return 0;

    }

    public void exit() {

    }

    public void header() {
        String logo = " ___ _                ___       __     \n" +
                "| _ ) |_  _ ___ ___  / __|__ _ / _|___ \n" +
                "| _ \\ | || / -_|_-< | (__/ _` |  _/ -_)\n" +
                "|___/_|\\_,_\\___/__/  \\___\\__,_|_| \\___|\n\n" +
                "Total earned money : Rp" + totalCash +
                "\n=======================================";

        System.out.println(logo);
    }

    public int Menu() {

        System.out.println("1. Add Order");
        System.out.println("2. Show All Order");
        System.out.println("3. Remove Order");
        System.out.println("4. Exit");
        System.out.print(">> ");

        while (!input.hasNextInt()) {
            System.out.println("Wrong input.");
            System.out.print(">> ");
            input.next();
        }
        int key = input.nextInt();
        return key;
    }

    public static void main(String[] args) {

        bluesCafe main = new bluesCafe();
        int key;
        do {
            main.header();
            key = main.Menu();

            switch (key) {
                case 1:
                    main.addOrder();
                    break;

                case 2:
                    main.showOrders();
                    break;

                case 3:
                    main.totalCash = main.removeOrder();
            }
        } while (key != 4);

    }

}
