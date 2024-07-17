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

    public static String findLongestWord(String fileName) {
        String longestWord = ""; // initialize longestWord to be empty
        try (Scanner scanner = new Scanner(new File(fileName))) { // create a scanner to read the file
            while (scanner.hasNext()){
                String word = scanner.next(); // read the next word
                if (word.length() > longestWord.legth()) {
                    longestWord = word; // update longestWord if the current word is longer than previous
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName); // print an error message is something is not found 
        }
        return longestWord;
    } // method to find the longest word
    
    public static int countWithLength(int length, String fileName) {
        int count = 0; // initialize count to zero
        try (Scanner scanner = new Scanner(new File(fileName))) { // create a scanner to read the file
            while (scanner.hasNext()) {
                String word = scanner.next(); // read the next word from the file
                if (word.length() == length) {
                    count++; // increase count if the word matches the specified length
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName); // print an error message is something is not found
        }
        return count; // return the count of words with the specified length
    } // method to count words of a specific length

    public static int countWordsEqualToLongest(String fileName) {
        String longestWord = findLongestWord(fileName); // find the longest word
        int longesLength = longestWord.length(); // get the length of the longest word
        return countWithLength(longestLength, fileName); // count the words that match the longest word
    } // method to count words that are as long as the longest word
    
} // class A07
