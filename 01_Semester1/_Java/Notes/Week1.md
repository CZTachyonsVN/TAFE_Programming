#notes
#### Troy - Java
# Moring
- [Assessment Outline](../../../04_Media/AssessmentOutline.pdf)
- Run-through of Connect content
- Introduction to programming
## "Pseudo-code exercise
1.
```
Print ("Hello class")
Print ("Welcome to your first class")
```
2.
```
Store Value total = 10+6
Print ("Your total is " + total)
```
3.
```
Print ("What is your name?")
Store Value name = Read Input
Print ("Hello " + name)
```
4.
```
Print ("Input a first number")
Store Value number1 = Read Input
Print ("Input a second number")
Store Value number2 = Read Input
Store Value total = number1 + number2
Print ("Your total is " + total)
```
## Getting started with Java
[Presentation](../TeachingContent/Getting%20started%20with%20Java.pptx)
**Packages** - Organising classes and functionality.
**Import** - install and include a package in this code file
```java
package HelloWorld;
import java.io;

public class Main {
	
	public static void main(String[] args){
	
		System.out.println("Hello World"); // this is a statement
	}
}
```
## First Java Commands
[Online Java compiler](https://www.online-java.com/)
Print message:
```java
System.out.println("message");
```

Store value:
```java
int intName = 10; //stores intiger
String stringName = "my string"; // stores string of characters
```
- Different data types require allocation of different memory space
	- e.g. number 1 in stored as `float` is bigger than `int`

### Java command exercises
```java
import java.util.Scanner; // Import the Scanner class to read user input

public class Main {
  public static void main(String[] args) {
    	//1.
        System.out.println("Hello class"); //print message
        System.out.println("Welcome to your first class");
        
        //2.
        int total1 = 10 + 6; // add 10 and 6 and store int "total1" variable
        System.out.println("Your total is: " + total1); // prints text and the total number
        
        //3.
        Scanner consoleScanner = new Scanner(System.in); //instantiate the functionality to read user input in the console
        System.out.println("What is your name?");
        String name = consoleScanner.nextLine(); // store user input
        System.out.println("Hello " + name);
        
        //4.
        System.out.println("Input the first whole number:");
        int number1 = consoleScanner.nextInt();
        
        System.out.println("Input the second whole number:");
        int number2 = consoleScanner.nextInt();
        
        int total2 = number1 + number2;
        System.out.println("Your total is: " + total2)
```
# Evening - Tutorial
## Java practice
[Coding exercises](../Exercises/JavaWeek1_Exercises.pdf)
- Area & perimeter (square, circle, triangle)
- Simple arithmetic
- Volume converter (litres, millilitres)
- Hours to seconds to seconds
- Custom<br>
[Excercise pseudocode](Week1_exercisesPseudocode.md)
# Questions
- IntelliJ version? newest.
- Class notes availability? On Connect
