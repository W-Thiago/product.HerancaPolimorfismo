package app;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();


        for (int i=1; i<=n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            if(ch == 'i'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Customs fee: ");
                double tx = sc.nextDouble();
                Product impor = new ImportedProduct(name, price, tx);
                list.add(impor);
            }
            else if (ch == 'c') {
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                list.add(new Product(name, price));
            }
            else {
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufacture = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, manufacture ));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product p: list) {
            System.out.println(p.priceTag());
        }



        sc.close();


    }
}
