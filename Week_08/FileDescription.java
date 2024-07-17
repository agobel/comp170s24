public class FileDescription {

    private int linesCount;
    private int wordsCount;
    private int charactersCount;
    private double wordsPerLine;
    private double charsPerLine;
    private String longestWordFound;

    public FileDescription() {
        linesCount = -1;
        wordsCount = -1;
        charactersCount = -1;
    }

    public void reset() {
        linesCount = 0;
        wordsCount = 0;
        charactersCount = 0;
    }

   public String toString() {
        return "\nlines: " + linesCount +
                "\nwords: " + wordsCount +
                "\ncharacters: " + charactersCount +
                "\n" + wordsPerLine + " words per line" +
                "\n" + charsPerLine + " characters per line" +
                "\n\"" + longestWordFound + "\" is the longest word found";
    }
            
}
