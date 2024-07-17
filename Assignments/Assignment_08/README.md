# Assignment 08

Write a class `Time` to represent the time captures as hours, minutes, and seconds on a 24-hour basis. 

* Class `Time` should **not** have a `main` method. 
* Use Javadoc-style comments for method and constructor headers, and for class variables.
* Every method with a return reference, i.e., every method that *is not void,* should not include any print statements.

In addition, `Time` should have the following behavior. The numbers used below are just examples. Your code should work for any possible values.

## Default instantiation

```java
Time t = new Time(); // Creates an object for 00:00:00
```

`Time` objects with no values passed to the constructor should be set for midnight, i.e., `00:00:00`.

## Integer instantiation

```java
Time t = new Time(1261); // Creates an object for 00:21:01
```

The argument in this case is interpreted as the number of seconds past the default time value. 1261 seconds, in the example above, correspond to 20 minutes and 1 second. The default time is `00:00:00` and so 1261 seconds past it is `00:20:01`.

The constructor for this case should provide protection for invalid data. 

#### Negative values

```java
Time t = new Time(-123);
```

It is up to you to decide how to handle negative values. Your decision should be documented in the Javadoc section of the constructor.

#### Large values

There are 86,400 seconds in a day. How would you handle an instantiation with a larger value, e.g.

```java
Time t = new Time(86460);
```

Document the way you decide to handle such values in the Javadoc section of the constructor.


## Full instantiation

```java
Time t = new Time(18, 30, 15); // Creates an object for 18:30:15
```

Here again, the constructor for this case should provide protection for invalid data. 

#### Negative values

```java
Time t = new Time(-18, 30, 15); // or
Time t = new Time(18, -30, 15); // etc
```

It is up to you to decide how to handle negative values. Your decision should be documented in the Javadoc section of the constructor.

#### Large values

There are 24 hours in a day, 60 minutes in an hour, and 60 seconds in a minute. How would you handle an instantiation with a larger values, e.g.

```java
Time t = new Time(28, 10, 10); // or
Time t = new Time(18, 99, 15); // etc
```

Document the way you decide to handle such values in the Javadoc section of the constructor.

## Full instantiation with *ante* and *post meridiem* indicators

Many people are not comfortable with 24-hour time representation. They prefer to say "6:30 PM" instead of 18:30. The abbreviations *a.m.* and *p.m.* are from the latin words for "before midday" (*ante meridiem)* and "after midday" (*post meridiem).* Provide constructors with the following behavior.

```java
Time t = new Time(6, 30, 00, 'P'); // Creates an object for 18:30:00 (6:30 PM)
Time t = new Time(6, 30, 00, 'p'); // Also creates an object for 18:30:00

Time t = new Time(6, 30, 00, 'A'); // Creates an object for 06:30:00 (6:30 AM)
Time t = new Time(6, 30, 00, 'a'); // Also creates an object for 06:30:00
```

It may be a good idea to protect this constructor from erroneous entries, e.g.,

```java
Time t = new Time(6, 30, 00, 'S'); // S is probably a typo
```

Document the way you decide to handle such values in the Javadoc section of the constructor.


## Arithmetic

Given a properly instantiated `Time` object, e.g.,

```java
Time t = new Time(11,30,00); 
```
offer the following arithmetic operations.


#### Addition

```java
t.add(3000); // adds 3000 seconds to the object
t.add(49,60); // adds 50 minutes and 60 seconds to object
t.add(1,2,3); // adds 1 hour 2 min 3 sec to the object
```

#### Subtraction

```java
t.subtract(900); // subtracts 900 seconds from the object
t.subtract(49,60) // subtracts 50 minutes and 60 seconds from object
t.subtract(1,2,3); // subtracts 1 hour 2 min 3 sec from object
```

Notice that `t.subtract(900)` could be the same as `t.add(-900)`, etc.


#### Multiplication
This is as interesting operation to define. To simplify the example, consider:

```java
Time t = new Time(7,0,0); // 07:00:00 or 7 AM.
t.multiply(0);  // Should be 00:00:00 or 12 AM.
t.multiply(1);  // Should be 07:00:00 or 7 AM.
t.multiply(2);  // Should be 14:00:00 or 2 PM.
t.multiply(3);  // Should be 21:00:00 or 9 PM.
t.multiply(4);  // Should be 04:00:00 or 4 AM
t.multiply(5);  // Should be 11:00:00 or 11 AM
```

Consider how to handle negative values, for example
```java
t.multiply(-3); 
```
Document your decision, and your implementation, in the Javadoc for method `multiply`.


#### Division

Another fun operation to define. To simplify the example, consider:

```java
Time t = new Time(18,0,0); // 18:00:00 or 6 PM.
t.divide(0);  // Should not be allowed.
t.divide(1);  // Should be 18:00:00 or 6 PM.
t.divide(2);  // Should be 09:00:00 or 9 AM.
t.divide(3);  // Should be 06:00:00 or 6 AM.
t.divide(4);  // Should be 04:30:00 or 4:30 AM
t.divide(5);  // Should be 03:36:00 or 3:36 AM
```

It's up to you to determine and implement how to handle division by 0. Remember to document your decision in the Javadoc for method `divide`. Another thing to document (and implement) is  handling negative values, for example
```java
t.divide(-3); 
```

## String representation

Write the `toString()` method to create and return a string as follows.


```java
Time t1 = new Time(18, 0, 0); 
Time t2 = new Time(6, 0, 0); 
Time t3 = new Time(11, 15, 20); 

System.out.println(t1); // Displays: 18:00:00 (6 PM)
System.out.println(t2); // Displays: 06:00:00 (6 AM)
System.out.println(t3); // Displays: 11:15:20 (11:20 AM)
```

## Integer representation

Write a method `toSeconds()` with the following behavior.

```java
Time t1 = new Time(18, 0, 0); 
Time t2 = new Time(3, 15, 20); 
Time t3 = new Time(0, 1, 2); 

System.out.println(t1.toSeconds()); // Displays: 64,000
System.out.println(t2.toSeconds()); // Displays: 11,720
System.out.println(t3.toSeconds()); // Displays: 62
```

## Hint
Learn how to use [`String.format`](https://docs.oracle.com/javase/tutorial/java/data/numberformat.html).