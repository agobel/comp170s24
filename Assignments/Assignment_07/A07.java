import java.io.File;
import java.util.Scanner;

public class A07 {

    /*****************************
     * DO NOT MODIFY METHOD MAIN *
     ****************************/
    public static void main(String[] args) {
        String filename = "Assignments/Assignment_07/book.txt";
        String longest = findLongestWord(filename);
        int longestLength = longest.length();
        int asLongAsLongest = countWithLength(longestLength);
        System.out.printf(
                "\nThe longest word in the book is \"%s\" witn %d characters.",
                longest, longestLength);
        System.out.printf(
                "\nI also found %d more words in the book with the same length.\n\n",
                asLongAsLongest - 1);
    } // method main
    
} // class A07
