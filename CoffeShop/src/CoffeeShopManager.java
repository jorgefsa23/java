import java.util.Scanner;

public class CoffeeShopManager {
    private CoffeeFlavors flavors;
    private Bag bag;
    private Payment payment;
    private int orderNumber;

    public CoffeeShopManager() {
        flavors = new CoffeeFlavors();
        bag = new Bag();
        payment = new Payment(0.0);
        orderNumber = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our coffee shop!");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Place an order");
            System.out.println("2. Summarize your order");
            System.out.println("3. Cancel an item");
            System.out.println("4. Cancel the entire process");
            System.out.println("5. Pay");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    summarizeOrder();
                    break;
                case 3:
                    cancelItem();
                    break;
                case 4:
                    cancelProcess();
                    break;
                case 5:
                    pay();
                    break;
                case 6:
                    System.out.println("Thank you for visiting our coffee shop!");
                    return;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    private void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What flavor would you like?");
        flavors.listFlavors();
        int flavorOption = scanner.nextInt();
        System.out.println("How many bags do you want?");
        int quantity = scanner.nextInt();
        bag.addItem(flavors.getFlavor(flavorOption), quantity, flavors.getPrice(flavorOption));
        System.out.println("Your order has been added to the bag");
    }

    private void summarizeOrder() {
        System.out.println("Here is your order summary:");
        System.out.println(bag.summarizeOrder());
    }

    private void cancelItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item do you want to cancel?");
        System.out.println(bag.summarizeOrder());
        int itemOption = scanner.nextInt();
        bag.cancelItem(itemOption);
        System.out.println("Item canceled");
    }

    private void cancelProcess() {
        bag.cleanBagOrder();
        orderNumber = 0;
        System.out.println("Process canceled");
    }

    private void pay() {
        payment.setPaymentOption();
        boolean paymentResult = payment.verifyPayment();

        if (paymentResult) {
            payment.authorizeOrder();
            bag.cleanBagOrder();//clear the bag to next client
        } else {
            System.out.println("Payment rejected, please try again or choose another payment option");
        }
    }
}