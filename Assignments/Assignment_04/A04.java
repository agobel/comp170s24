public class A04 {
    public static void main(String[] args) {
        printOddCharacters("Springfield"); // Expect: p i g i l
        printEvenCharacters("Springfield"); // Expect: S r n f e d 
    } // method main

    static void printOddCharacters(String string){
        for (int position = 0; position < string.length(); position = position+1) {
            if (position %2 == 1){
                continue;
            }
            char current = string.charAt(position);
            System.out.printf(format:"\nAt position %2d the character is %s", position, current);
        }

    static void printEvenCharacters(String string){
        for (int position = 0; position < string.length(); position = position+1) {
            if (position %2 == 0){
                continue;
            }
            char current = string.charAt(position);
            System.out.printf(format:"\nAt position %2d the character is %s", position, current);     
        }

}
