package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter the number of products: ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Product" + " #" + (i + 1) + " data: ");
			System.out.println("Common, used or imported? (c/u/i)");
			char option = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Price: ");
			Double productPrice = sc.nextDouble();
			System.out.println();
			if (option == 'c') {

				list.add(new Product(productName, productPrice));

			} else if (option == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(productName, productPrice, manufactureDate));
			} else if (option == 'i') {
				System.out.println("Customs fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(productName, productPrice, customsFee));
			} else {
				System.out.println("Invalid option!");
			}
		}
		System.out.println("");
		System.out.println("PRICE TAGS: ");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}

		sc.close();
	}

}
