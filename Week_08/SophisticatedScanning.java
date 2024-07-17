import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A program to demonstrate graceful handling of errors when trying to
 * scan a file.
 */
public class SophisticatedScanning {

    private static final String ERROR_MESSAGE = "\nFile %s not available\n\n";
    private static final String REPORT_MESSAGE = "\nFile %s has %d line(s)\n\n";

    /**
     * This method establishes a scanner connection to a specified file.
     * Instead of throwing a FileNotFoundException, the method returns
     * a null when the connection cannot be established. It is up to the
     * users of this method to determine how to handle the situation.
     * 
     * @param filename String with filepath to file that we want to scan
     * @return Scanner object connected to the specified file or null if connection
     *         not possible.
     */
    public static Scanner connectToFile(String filename) {
        // Declare a scanner variable. Its actual value will be assigned
        // by the try/catch block.
        Scanner sc;
        // The try/catch block will try to instantiate a scanner for the
        // specified file. If the connection is possible, the scanner
        // variable will be assigned with a value identifying the
        // scanner instance to the specified file.
        try {
            // Execute this code and if no errors occur during execution
            // skil past the try/catch scope. But if an error occurs,
            // execute onluy the code in the catch block.
            File file = new File(filename);
            sc = new Scanner(file);
        } catch (Exception e) {
            // If anything goes wrong int the try block above, just
            // execute this block and exit the try/catch scope.
            sc = null;
        }
        // At this point, one of the two blocks of the try/catch scope
        // above has executed. As a result there is a value assigned
        // to the return variable. If something went wrong that value
        // is null; otherwise, it's a scanner connected to the specified file.
        return sc;
    } // method connectToFile

    /**
     * Counts the lines in a specified file. If the file cannot be found
     * the method returns -1 instead of throwing an exception, allowing
     * its users how to handle the situation.
     * 
     * @param filename String with filepath to file that we want to scan
     * @return int value with number of lines in the specified file or -1 is
     *         something goes wrong and we cannot connect to that file.
     */
    public static int countLines(String filename) {
        // Initialize the return value to -1
        int lineCount = -1;
        // Use method connectToFile to establish a scanner connection to the specified
        // file. The method returns a null when the connections is not possible. In that
        // case we skip the if-block and return the default value -1.
        Scanner sc = connectToFile(filename);
        if (sc != null) {
            // Connection was possible; reset the lineCount value to 0 and
            // start counting lines until we reach the end of file.
            lineCount = 0;
            while (sc.hasNextLine()) {
                lineCount++;
                sc.nextLine();
            }
            // Be nice and close the scanner when done using it.
            sc.close();
        }
        // At the end of the if-block the value of lineCount is either -1 because we
        // never executed the if block (scanner sc was null) or some value >-1
        // representing the actual number of lines in the specified file.
        return lineCount;
    } // method countLines

    /**
     * Demonstration of a prehistoric way of bundling three values into a single
     * return variable. The method counts the lines, words, and characters in a
     * file, and returns all three values packaged as an array. Users of this method
     * must be be aware of the positional convention for the return array.
     * 
     * @param filename String with filepath to analyze
     * @return int[] where [0] is the count of lines in the file, [1] is the count
     *         of words, and [2] is the count of characters. If the file is not
     *         accessible, the method will return the array [-1, -1, -1]
     */
    public static int[] countElementsPaleolithic(String filename) {
        // Array to return; assume the worst
        int[] description = { -1, -1, -1 };
        Scanner sc = connectToFile(filename);
        if (sc != null) {
            // Connectio to the file was successful; initiate line, word, and character
            // counters.
            int countLines = 0, countWords = 0, countCharacters = 0; // best to have one statement per variable
            while (sc.hasNextLine()) {
                countLines++;
                // Split the current line from the file into words (tokens separated by spaces
                // and place them in a String array)
                String[] wordsFromCurrentLine = sc.nextLine().split(" ");
                // The number of elements in that string array is the number of words in the
                // current line
                countWords = countWords + wordsFromCurrentLine.length;
                // traverse word array to count characters
                for (int i = 0; i < wordsFromCurrentLine.length; i++) {
                    countCharacters = countCharacters + wordsFromCurrentLine[i].length();
                }
            }
            // done scanning the file
            sc.close(); // be nice
            description[0] = countLines;
            description[1] = countWords;
            description[2] = countCharacters;
        }
        return description;
    } // method countElementsPaleolithic

    /**
     * Demonstration of a less-prehistoric way of bundling three values into a
     * single
     * return variable. The method counts the lines, words, and characters in a
     * file, and returns all three values packaged as an array. Users of this method
     * must be be aware of the positional convention for the return array. The
     * positional notation is incorporated in the method, with constants LINES,
     * WORDS, CHARACTERS referencing the elements of the return array with the
     * corresponding values.
     * 
     * @param filename String with filepath to analyze
     * @return int[] where [LINES] is the count of lines in the file, [WORDS] is the
     *         count
     *         of words, and [CHARACTERS] is the count of characters. If the file is
     *         not
     *         accessible, the method will return the array [-1, -1, -1]
     */
    public static double[] countElementsNeolithic(String filename) {
        // Array to return; assume the worst
        double[] counter = { -1.0, -1.0, -1.0, -1.0, -1.0 };
        // Positional references for the return array
        final int LINES = 0, WORDS = 1, CHARACTERS = 2;
        final int WORDS_PER_LINE = 3, CHAR_PER_LINE = 4;
        Scanner sc = connectToFile(filename);
        if (sc != null) {
            // Connection to the file was successful; initiate line, word, and character
            // counters.
            counter[LINES] = 0;
            counter[WORDS] = 0;
            counter[CHARACTERS] = 0;
            while (sc.hasNextLine()) {
                counter[LINES]++;
                // Split the current line from the file into words (tokens separated by spaces
                // and place them in a String array)
                String[] wordsFromCurrentLine = sc.nextLine().split(" ");
                // The number of elements in that string array is the number of words in the
                // current line
                counter[WORDS] += wordsFromCurrentLine.length;
                // traverse word array to count characters
                for (String word : wordsFromCurrentLine) {
                    counter[CHARACTERS] += word.length();
                }
            }
            // done scanning the file ... computer averages
            counter[WORDS_PER_LINE] = counter[WORDS] / (1+counter[LINES]);
            counter[CHAR_PER_LINE] = counter[CHARACTERS] / (1+counter[LINES]);
            sc.close(); // be nice
        }
        return counter;
    } // method countElementsNeolithic

    public static FileDescription countElementsModern(String filename) {
        FileDescription fd = new FileDescription();
        Scanner sc = connectToFile(filename);
        if (sc != null) {
            int longestStringLength = 0;
            String longestString = "";
            fd.reset(); // set all fd variables to 0
            while (sc.hasNextLine()) {
                fd.linesCount++;
                String currentLine = sc.nextLine();
                // Break current line into array of words
                String[] words = currentLine.split(" ");
                // Add number of words to corresponding count
                fd.wordsCount = fd.wordsCount + words.length;
                // count the characters in each word and update the corresponding count
                for (String word : words) { // for every string inside the array words
                    if (word.length() > longestStringLength) {
                        longestStringLength = word.length();
                        longestString = word;
                    }
                    fd.charactersCount = fd.charactersCount + word.length();
                }
            }
            // update averages
            fd.wordsPerLine = fd.wordsCount / (1+fd.linesCount);
            fd.charsPerLine = fd.charactersCount / (1+fd.linesCount);
            // update the longest string
            fd.longestWordFound = longestString;
        }
        return fd;
    }

    /**
     * Displays information about a file, specifically the number of lines in it.
     * 
     * @param filename String filepath to file to analyze.
     */
    public static void reportLineCount(String filename) {
        // Number of lines is obtained from method countLines; if something goes wrong
        // the reported number will be -1
        int lineCount = countLines(filename);
        if (lineCount == -1) {
            // Something went wrong; inform the user
            System.out.printf(ERROR_MESSAGE, filename);
        } else {
            // Report information obtained about the file.
            System.out.printf(REPORT_MESSAGE, filename, lineCount);
        }
    } // method reportLineCount

    /** Driver code */
    public static void main(String[] args) {
        String wrongFilename = "Week_98/UX8qw114.txt"; // fictitious file
        String rightFilename = "Week_08/students.txt"; // existing file
        reportLineCount(wrongFilename);
        reportLineCount(rightFilename);

        System.out.println("\nDemo countElements:\n");
        System.out.println(Arrays.toString(countElementsNeolithic(rightFilename)));

        System.out.println("\nHow about using our own object?");
        FileDescription fd = countElementsModern(rightFilename);
        System.out.println(fd);
    } // method main

} // class SophisticatedScanning