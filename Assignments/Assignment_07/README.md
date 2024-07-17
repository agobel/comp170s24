# Assignment 07

Using only the `Scanner` and `File` classes, write methods in `A07.java` to perform the following tasks.

* Find and return the longest word in a text file.
* Count the number of words with a specific length in a file and return that count value.
* Count how many words in a file are as long as its longest word, and return that count value.

You may use the text file `book.txt` in this folder. This is the text from Charles Dickens' *A Tale of Two Cities*.

Notice that punctuation can produce artificially long words. For example "`place--then`" appears as word with 11 characters when in fact it is just two words with 5 and 4 characters respectively. To avoid such artifacts, I have removed most (hopefully, *all)* punctuation from `book.txt`. This makes the test a bit challenging to read because even simple punctuation marks such as commas, possessive apostrophes, and full-stops are missing.

Your code must be well documented with comments. It must anticipate errors and provide a graceful way to end (instead of throwing an exception.) Your code must compile without errors. Tasks should be organized in separate methods. You should not write any code inside method `main`. 