import java.util.Scanner;

public class SalesRecordLoop {
    public static void main(String args[]) {

        /* this program allows the user a to display sales record on the console*/

        //initialize sales record variable
        int customerID = 0;
        double salesAmount = 0;
        String taxCode = "";
        String customerName = "";

        //Answer Yes [y,Y] or no [n,N] to continue or stop displaying sales records
        String answer = "";

        Scanner keyboard = new Scanner(System.in);

        do {

            // get the details of one sale record
            // get customer name
            System.out.println("Enter customer name: ");
            customerName = keyboard.nextLine();

            // get customerID
            System.out.println("Enter customer ID: ");
            customerID = keyboard.nextInt();
            keyboard.nextLine();

            //get sales amount
            System.out.println("Enter Sales Amount: ");
            salesAmount = keyboard.nextDouble();
            keyboard.nextLine();

            //get  the taxCode
            System.out.println("Enter the tax code: ");
            //check if tax code is valid
            do {
                taxCode = keyboard.nextLine();
            } while (!checkIfTaxCodeValid(taxCode));

            // print the sales record details to the screen
            displayDetails(customerID, customerName, salesAmount, taxCode);

            //ask the user if he want to continue displaying sales records
            System.out.print("Do you want to enter another record?  (Y/N) \n");

            // make sure that the user answer is valid
            do {
                // get the answer from the user
                answer = keyboard.next();
                keyboard.nextLine();
            } while (!checkIfAnswerValid(answer));

        } while (answer.equalsIgnoreCase("y"));

        System.out.println("Thank you!");
    }

    // print the one sale record to the screen
    public static void displayDetails(int customerID, String customerName,
                                      double salesAmount, String taxCode) {
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Customer ID       : " + customerID);
        System.out.println("Customer name     : " + customerName);
        System.out.println("Sales amount      : $" + salesAmount);
        System.out.println("Tax code          : " + taxCode.toUpperCase());

        //calculate total amount
        double totalAmount = calculateTotalAmount(salesAmount, taxCode);

        System.out.println("Total Amount Due  : $" + totalAmount);
        System.out.println("---------------------------------------------------------------\n\n");

    }

    // Print the total amount depending on the tax code
    public static double calculateTotalAmount(double salesAmount, String taxCode) {

        // print total amount
        double totalAmount = 0;

        //Tax codes NRM = 6%, NPF =  0%, BIZ = 4.5%
        if (taxCode.equalsIgnoreCase("NRM")) {
            totalAmount = salesAmount * 1.06;
        } else if (taxCode.equalsIgnoreCase("BIZ")) {
            totalAmount = salesAmount * 1.045;
        } else if (taxCode.equalsIgnoreCase("NPF")) {
            totalAmount = salesAmount;
        } else {
            totalAmount = salesAmount;
            System.out.println("*****(" + taxCode + ")" + " Invalid tax code.*****");

        }
        return totalAmount;


    }

    // check if the answer is Yes [y,Y] or no [n,N]
    public static boolean checkIfAnswerValid(String answer) {

        if ((answer.equalsIgnoreCase("y")) || (answer.equalsIgnoreCase("n"))) {
            return true;
        } else {
            // ask the user to enter a valid answer
            System.out.println("Please, answer [y]or[Y] for Yes or [n]or[N] for No.\n");
            return false;
        }
    }

    //Check if the tax code is valid
    //Tax codes NRM = 6%, NPF =  0%, BIZ = 4.5%
    public static boolean checkIfTaxCodeValid(String taxCode){
        if (taxCode.equalsIgnoreCase("NRM")) {
            return true;
        } else if (taxCode.equalsIgnoreCase("BIZ")) {
            return true;
        } else if (taxCode.equalsIgnoreCase("NPF")) {
            return true;
        } else {
            System.out.println("*****(" + taxCode + ")" + " Invalid. Please enter a valid tax code (NRM/BIZ/NPF). *****");
            return false;
        }

    }


}
