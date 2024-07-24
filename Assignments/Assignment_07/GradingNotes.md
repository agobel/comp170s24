# Grading notes for assignment 07

There are two parts in this assignment: the analysis/design part and the implementation part. Most of the word is done in the analysis/design part. The exercise asked for three things:

* Find and return the longest word in a text file.
* Count the number of words with a specific length in a file and return that count value.
* Count how many words in a file are as long as its longest word, and return that count value.

## How to find the longest word in a file?

Clearly this involves scanning the file one word at a time. Assume that the longest word is the empty string or the first word we scan. Every time we find a word that is longer than the longest, we make it the longest. The *pseudocode* for this process is:

```text
establish a scanner to the file
longest word = ""
while there are words in the file
  read the current word from the scanner
  if current word is longer than longest
    longest = current word
```

## How to count  number of words with  specific length in a file?

This process too requires us to scan the file, one word at a time. Every time we find a word with the specific length, we update a counter. The *pseudocode* for this process is:


```text
establish a scanner to the file
counter = 0
while there are words in the file
  read the current word from the scanner
  if current word length == specified length
    counter++
```

## Comparison between the two techniques

Both techniques above need to scan the file. We can build the `Scanner` code in each method but that would introduce a lot of redundant code, like

```java
Scanner sc;
try {
    File file = new File(filename);
    sc = new Scanner(file)
} catch (Exception e) {
    sc = null
}
// Make sure scanner is legit
if (sc != null) {
    while (sc.hasNext()) {
        // method-specific tasks, e.g., look for the longest word
        // or for a word with specific length
    }
}
```
We don't want to have two methods with so much similar code. It is best if we commit this code to a separate method. Then call that method whenever we need it in other methods. For example:

```java
public static Scanner connectTo(String filename) {
    Scanner sc = null;
    if (filename != null && filename.length() > 0) {
        try {
            File file = new File(filename);
            sc = new Scanner(file);
        } catch (Exception e) {
            sc = null;
        }
    }
    return sc;
} 
```

Then, we can write the two methods we discussed as follows

```java
public static String findLongestWord(String filename) {
        Scanner sc = connectTo(filename);
        if (sc != null) {
            String longest = "";
            // ...
```

and

```java
public static int countWithLength(int length, String filename) {  
    Scanner sc = connectTo(filename);
    int counter = -1;
    if (sc != null) {
            counter = 0;
            // ...
```

Using the `connectTo` method alleviates 10 lines of redundant code from methods `findLongestWord` and `countWithLength`.

Finally, the third deliverable of this assignment --
 how many words in a file are as long as its longest word -- can be obtained with methods `findLongestWord` and `countWithLength`, as follows:

 ```java
// find the longest string in the file
String longest = findLongestWord(filename);
// obtain its length
int longestLength = longest.length();
// count the words of that length in the same file
int asLongAsLongest = countWithLength(longestLength, filename);
```

This is the code that was given in `A07.main`. 

If we didn't care to know which word is the longest, and only wanted to count how many other words of same length are present in the file, we'd need to call only `countWithLength` and pass `findLongestWord` as an argument to it:

```java
int asLongAsLongest = countWithLength(findLongestWord(filename), filename);
```

## Review of analysis

* The third deliverable (count of words with same length as the longest word) can be achieved with the second deliverable (count of words of a specific length). Just find the length of the longest word first.
* Finding the longest word was, of course, the first deliverable.
* Notice that both methods require a scanner attached to the file. 
* Attempt to attach a scanner to the file in a separate method -- the code for this was developed in class the previous week and is available in [`SophisticatedScanning.connectToFile`](https://github.com/lgreco/comp170s24/blob/882cb9566a3e852a5fe10f5c02dd98db9a1056a8/Week_08/SophisticatedScanning.java#L24) method.

## Possible issues and areas for improvement

Based on what I saw in similar assignments, the biggest challenge here is to *avoid overthinking* the problem. This can be achieved only with some design analysis. Not spending enough time analyzing the problem can lead to overthinking the implementation. Evidence of such overthinking includes the use of exceptions like `FileNotFoundException`, redundant code, print statements instead of returned values, monolithic implementation (both longest word and count of words with that length in one method), etc.