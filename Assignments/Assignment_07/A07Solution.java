import java.io.File;
import java.util.Scanner;

public class A07Solution {

    /**
     * Connects a scanner to a file. If the file is not available or
     * accessible, instead of throwing an exception, the method returns
     * a null.
     * 
     * @param filename String with path to file to scan
     * @return a scanner attached to the specified file or null if something goes
     *         wrong
     */
    public static Scanner connectTo(String filename) {
        // Prepare a null object to return
        Scanner sc = null;
        // Guard against null or empty arguments
        if (filename != null && filename.length() > 0) {
            try {
                // Attempt to connect scanner to file
                File file = new File(filename);
                sc = new Scanner(file);
            } catch (Exception e) {
                // If something goes wrong, affirm null scanner
                sc = null;
            }
        }
        // Done. If everything went well, sc is an actual scanner attached to the
        // specified file. If something went wrong (file not available or filename not
        // legit) variable sc is null.
        return sc;
    } // method connectTo

    /**
     * Finds the longest word in a file. Method assumes that file is a clear text
     * file. If connection to the file is not possible, the method returns a null
     * string.
     * 
     * @param filename String with path to file to analyze
     * @return String with longest word in the file or null if connection to the
     *         file is not possible.
     */
    public static String findLongestWord(String filename) {
        // Attach a scanner to the file; if something goes wrong and the file is not
        // available our connectTo() method will return a null and that's how we can
        // tell if there is a problem.
        Scanner sc = connectTo(filename);
        // Prepare the return value; set is up as null, and change it only after we
        // verify that we have successfully attached a scanner to the file.
        String longest = null;
        if (sc != null) {
            // Scanner to file is available. Let's assume then that the longest string in
            // the file is the empty string; this will change very soon, but we have to
            // start from somewhere.
            longest = new String(""); // 0 length
            while (sc.hasNext()) {
                // Get one word at a time from the file.
                String current = sc.next();
                // Check if it's longer than the longest word
                if (current.length() > longest.length()) {
                    // If the current word is longer than the longest, make it
                    // the longest word for now.
                    longest = current;
                }
            }
            // Done scanning the file
            sc.close(); // be nice
        }
        // At this point longest is either null because we couldn't connect to the file
        // or the longest string we found in the file. Notice that if the file is empty,
        // the longest string found is the empty string.
        return longest;
    } // method findLongestWord

    /**
     * Finds how many words in a given file have a specific length.
     * 
     * @param length   int length we are interested in
     * @param filename String with path to file we want to scan
     * @return int with the number of words in the specified file that have the
     *         specified length; if the file cannot be found return -1
     */
    public static int countWithLength(int length, String filename) {
        // Initialize the return variable
        int counter = -1;
        // Ensurse that the specified length is valid and the filename legit
        if (length > 0 && filename != null && filename.length() > 0) {
            // Attempt to attach a scanner to the file. If there is a problem our method
            // connectTo() will return a null
            Scanner sc = connectTo(filename);
            if (sc != null) {
                // Connection to file was successful, so let's reinitialize the counter to 0.
                counter = 0;
                // Scan the file
                while (sc.hasNext()) {
                    // Check if each word matches the specified length
                    if (sc.next().length() == length) {
                        // If so, update counter
                        counter++;
                    }
                } 
                // Done scanning the file
                sc.close();
            }
        }
        // Done. At this point counter is either -1 because there was a problem
        // connecting to the file or the actual count of words with the specified length
        // in the file.
        return counter;
    } // method countWithLength

    /*****************************
     * DO NOT MODIFY METHOD MAIN *
     ****************************/
    public static void main(String[] args) {
        String filename = "Solutions/Assignment_07/book.txt";
        String longest = findLongestWord(filename);
        System.out.println(longest);
        int longestLength = longest.length();
        int asLongAsLongest = countWithLength(longestLength, filename);
        System.out.printf(
                "\nThe longest word in the book is \"%s\" witn %d characters.",
                longest, longestLength);
        System.out.printf(
                "\nI also found %d more words in the book with the same length.\n\n",
                asLongAsLongest - 1);
    } // method main

} // class A07
