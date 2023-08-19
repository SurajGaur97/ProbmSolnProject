package programsProblem.company.Cepheid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program to get list of books as book1 with price 10, book2 with price 10, book3 with price 30, book4
 * with price 10, and book5 with price 40 bought by a persone who have 70 unit of cash available. and book should
 * be buy with pairs by the person.
 *
 * input:
 * 5    (no of book)
 * 70   (cash available to person)
 * book1    (5 books name)
 * book2
 * book3
 * book4
 * book5
 * 10 10 3 10 40 (price list of books)
 */
public class FindBookList {
    public void printDesiredList() {
        Scanner scanner = new Scanner(System.in);
        int noOfBook = Integer.parseInt(scanner.nextLine());
        int cash = Integer.parseInt(scanner.nextLine());

        String[] booksName = new String[noOfBook];
        for(int i = 0; i < noOfBook; i++) {
            String bookName = scanner.nextLine();
            booksName[i] = bookName;
        }
        String[] priceList = scanner.nextLine().split(" ");

        int availableBal = cash;
        for(int i = 0; i < noOfBook; i++) {
            if(Integer.parseInt(priceList[i]) < availableBal) {
                availableBal -= Integer.parseInt(priceList[i]);
                System.out.println(booksName[i] + " - " + priceList[i]);
            }
        }
    }
}
