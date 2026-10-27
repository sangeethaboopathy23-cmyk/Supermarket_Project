import java.util.Scanner;
import java.io.*;
import java.awt.Desktop;
import java.time.*;
import java.time.format.*;
public class Supermarket_bill_excel{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int category, item, brand, quantity;
        double price = 0, amount;
        String itemname = "";
        String brandname = "";
        System.out.println("---- SUPERMARKET ----");
        System.out.println("1. Stationery");
        System.out.println("2. Groceries");
        System.out.print("Choose category: ");
        category = sc.nextInt();
        switch (category) {
            case 1:
                System.out.println("\n--- STATIONERY ---");
                System.out.println("1. Pen");
                System.out.println("2. Pencil");
                System.out.println("3. Notebook");
                System.out.print("Choose item: ");
                item = sc.nextInt();
                switch (item) {
                    case 1:
                        System.out.println("1. Reynolds - Rs.10");
                        System.out.println("2. Cello - Rs.15");
                        System.out.print("Choose brand: ");
                        brand = sc.nextInt();
                        switch (brand) {
                            case 1:
                                itemname="Pen";
                                brandname="Reynolds";
                                price = 10;
                                break;
                            case 2:
                                itemname="pen";
                                brandname="Cello";
                                price = 15;
                                break;
                            default:
                                System.out.println("Invalid brand!");
                        }
                        break;
                    case 2:
                        System.out.println("1. Nataraj - Rs.5");
                        System.out.println("2. Apsara - Rs.8");
                        System.out.print("Choose brand: ");
                        brand = sc.nextInt();
                        switch (brand) {
                            case 1:
                                itemname="Pencil";
                                brandname="Nataraj";
                                price = 5;
                                break;
                            case 2:
                                itemname="Pencil";
                                brandname="Apsara";
                                price = 8;
                                break;
                            default:
                                System.out.println("Invalid brand!");
                        }
                        break;
                    case 3:
                        System.out.println("1. Classmate - Rs.50");
                        System.out.println("2. Navneet - Rs.40");
                        System.out.print("Choose brand: ");
                        brand = sc.nextInt();
                        switch (brand) {
                            case 1:
                                itemname="Notebook";
                                brandname="Classmate";
                                price = 50;
                                break;
                            case 2:
                                itemname="Notebook";
                                brandname="Navneet";
                                price = 40;
                                break;
                            default:
                                System.out.println("Invalid brand!");
                        }
                        break;
                    default:
                        System.out.println("Invalid item!");
                }
                break;
            case 2:
                System.out.println("\n--- GROCERIES ---");
                System.out.println("1. Rice - Rs.60 per kg");
                System.out.println("2. Sugar - Rs.45 per kg");
                System.out.print("Choose item: ");
                item = sc.nextInt();
                switch (item) {
                    case 1:
                        price = 60;
                        itemname="Rice";
                        brandname="Standard";
                        break;
                    case 2:
                        price = 45;
                        itemname="Sugar";
                        brandname="Standard";
                        break;
                    default:
                        System.out.println("Invalid item!");
                }
                break;
            default:
                System.out.println("Invalid category!");
        }
      if (price > 0) {
            sc.nextLine();
            System.out.print("Enter customer name: ");
            String customerName = sc.nextLine();
            System.out.print("Enter quantity: ");
            quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero!");
                sc.close();
                return;
            }
            amount = price * quantity;
            String dateTime = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            );
            System.out.println("\n---- CUSTOMER BILL ----");
            System.out.println("Customer: " + customerName);
            System.out.println("Item: " + itemname);
            System.out.println("Brand: " + brandname);
            System.out.println("Price: Rs." + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Amount: Rs." + amount);
            File file = new File("C:\\Users\\Lenovo\\OneDrive\\Desktop\\java program\\Supermarket.csv");
            try {
                boolean newFile = !file.exists();
                FileWriter writer = new FileWriter(file, true);
                if (newFile) {
                    writer.write(
                        "Date and Time,Customer Name,Item,Brand,Unit Price,Quantity,Total Amount\n"
                    );
                }
                writer.write(
                    "\"" + dateTime + "\","
                    + "\"" + customerName.replace("\"", "\"\"") + "\","
                    + "\"" + itemname + "\","
                    + "\"" + brandname + "\","
                    + price + ","
                    + quantity + ","
                    + amount + "\n"
                );
                writer.close();
                System.out.println("\nSales details saved successfully!");
                System.out.println("File: " + file.getAbsolutePath());
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file.getAbsoluteFile());
                }
            }
                catch (IOException e) {
                System.out.println("Error saving or opening file: "
                                   + e.getMessage());
            }
        }

        sc.close();
    }
}