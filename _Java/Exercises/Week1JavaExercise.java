import java.awt.datatransfer.StringSelection;
import java.io.Console;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;

// IMPORTANT:
// RENAME FILE TO "Main.java" BEFORE COMPILING

public class Main {
    public static void main(String[] args) {
        // initiate scanner for user input
        // App running states
        Scanner read = new Scanner(System.in);
        boolean badInput = true;
        boolean exit = false;
        int choice = 0;

        //Run program until exit condition is true
        while(!exit) {
            //Check bad input. Keep prompting options until input is valid.
            while (badInput) {
                System.out.flush();
                System.out.println("Pick an option by entering the corresponding number\r\n1. Area and perimeter\r\n2. Simple arithmetics\r\n3. Volume converter\r\n4. Time converter\r\n5. Exit");
                try {
                    choice = read.nextInt();
                    badInput = false;
                } catch (Exception e) {
                    System.out.println("Something went wrong and it's probably your fault. Press any key to try again.");
                    read.nextLine();
                }
            }

            //Select choice
            switch (choice) {
                case 1:
                    AreaAndPerimeter();
                    break;
                case 2:
                    SimpleArithmetic();
                    break;
                case 3:
                    VolumeConverter();
                    break;
                case 4:
                    TimeConverter();
                    break;
                case 5:
                    exit = true; // exit condition is true
                    break;
                default:
                    System.out.println("Error - You did not select from the options above dummy. BYE!");
            }
            badInput = true; //reseting bad input condition before user chooses another option.
        }

        //Exit application
        System.exit(0);
    }

    private static void TimeConverter(){
        Scanner read = new Scanner(System.in);
        System.out.println("Time converter is not ready....... YET! Come back later.\r\nPress enter to go back to menu.");
        read.nextLine();
    }
    private static void VolumeConverter() {
        Scanner read = new Scanner(System.in);
        System.out.println("Volume converter is not ready....... YET! Come back later.\r\n" +
                "Press enter to go back to menu.");
        read.nextLine();
    }

    private static void SimpleArithmetic() {
        boolean repeat = true;
        Scanner read = new Scanner(System.in);
        String input;
        String regex = "(?<number>\\d+\\.\\d+|\\d+)|(?<operators>\\+|-|\\*|\\/)";
        LinkedList<String> list = new LinkedList<String>();
        float result = 0;

        while (repeat) {
            boolean validInput = true;
            int indexCheck = 0;
            int count = 0;
            float currentNum = 0f;
            boolean isDivision = false;
            boolean isNumber = true;

            System.out.flush();
            System.out.println("This calculator only handles addition, subtraction, multiplication, and " +
                    "division.\r\nEnter your arithmetic problem:");

            input = read.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            list.clear();
            list.add("0");

            {
                try {
                    float f = Float.parseFloat(input.substring(input.length() - 1));
                } catch (Exception e) {
                    validInput = false;
                    System.out.println("Invalid Input - Non-numerical character at the end of your input");
                }
            }// Check for non-numerical last character

            while(matcher.find() && validInput){

                // starting index of this match should be the same as the indexCheck which
                // corresponds to the last index of the last match.
                if(matcher.start() == indexCheck && validInput){
                    indexCheck = matcher.end(); //remember match end index
                    // System.out.println(matcher.group()); //Print current match

                    {
                        try {
                            currentNum = Float.parseFloat(matcher.group());
                            if (isDivision && currentNum == 0){
                                System.out.println("Invalid input - Division by zero");
                                validInput = false;
                            }
                            switch (list.getLast()){
                                case "+":
                                    list.removeLast();
                                    break;
                                case "-":
                                    list.removeLast();
                                    currentNum *= -1;
                            }
                            isNumber = true;
                            list.add(String.valueOf(currentNum));

                        } // Match is a number.
                        catch (Exception e) {
                            String operator = matcher.group();
                            if (count == 0 && !(Objects.equals(matcher.group(), "-") || Objects.equals(matcher.group(), "+"))){
                                validInput = false;
                                System.out.println("Invalid Input - Input does not start with a number.");
                            }

                            if(!isNumber) {
                                if (Objects.equals(matcher.group(), "*")||Objects.equals(matcher.group(), "/")) {
                                    validInput = false;
                                    System.out.println("Invalid Input - Invalid adjacent operators.");
                                }
                                else if(Objects.equals(list.getLast(), matcher.group())){
                                    list.removeLast();
                                    operator = "+";
                                }
                                else if (!(Objects.equals(list.getLast(), "*")||Objects.equals(list.getLast(), "/"))){
                                        list.removeLast();
                                        operator = "-";
                                }
                            } // Adjacent operator check



                            if (Objects.equals(matcher.group(), "/")){
                                isDivision = true;
                            }

                            isNumber = false;
                            list.add(operator);
                        } // Match is an operator
                    }// is number or operator? Adjacent operator check. Invalid start of string. Get number value of match to 'currenNum'
                    count++;
                }
                else{
                    System.out.println("Invalid Input - Contains invalid characters.");
                    validInput = false;
                }
            }//Input check and storing

            //Print list
            for (String s : list) {
                System.out.print(s + " | ");
            }

            if (validInput) {
                System.out.println();

                {
                    result = 0;
                    //int currentPosition = 0;
                    boolean multiplication = false;
                    int indexDiv = list.indexOf("/"), indexMul = list.indexOf("*");


                    while (indexMul != -1 || indexDiv != -1) { // if * or / exist
                        {
                            if (indexDiv * indexMul > 0) { // if * and / exist
                                if (indexDiv > indexMul) {
                                    multiplication = true;
                                } else {
                                    multiplication = false;
                                }
                            } else if (indexMul == -1) {
                                multiplication = false;
                            } else {
                                multiplication = true;
                            }
                        } // Finding the first multiplication or division

                        if (multiplication) {
                            System.out.println(list.get(indexMul-1) + "*" + list.get(indexMul+1));
                            list.set(indexMul - 1,
                                    String.valueOf(Float.parseFloat(list.get(indexMul - 1)) *
                                            Float.parseFloat(list.get(indexMul + 1))));
                            list.remove(indexMul + 1);
                            list.remove(indexMul);
                        } //multiplication
                        else {
                            System.out.println(list.get(indexDiv-1) + "/" + list.get(indexDiv+1));
                            list.set(indexDiv - 1,
                                    String.valueOf(Float.parseFloat(list.get(indexDiv - 1)) /
                                            Float.parseFloat(list.get(indexDiv + 1))));
                            list.remove(indexDiv + 1);
                            list.remove(indexDiv);
                        }//division

                        // Find next
                        indexDiv = list.indexOf("/");
                        indexMul = list.indexOf("*");
                    }//multiplication and division

                    for (String s : list) {
                        result += Float.parseFloat(s);
                    }
                }//Calculation
                System.out.println("Your result is: " + String.valueOf(result));
            } //Calculation

            boolean promptLoop = true;
            while (promptLoop) {
                System.out.println("Would you like to try again?[y/n]");
                String answer = read.nextLine();
                switch (answer) {
                    case "y":
                        repeat = true;
                        promptLoop = false;
                        break;
                    case "n":
                        repeat = false;
                        promptLoop = false;
                        break;
                    default:
                        System.out.println("Invalid input. Try again.");
                }
            }//End Loop
        }// App loop
    }


    private static void AreaAndPerimeter() {
        //Area & perimeter of a: square, circle, and triangle
        //square given a side
        //circle given a radius
        //triangle given all three sides using Heron's formula
        Scanner read = new Scanner(System.in);
        double radius;
        double squareLength;
        double[] triangleSides = new double[4];
        double area;
        double perimeter;
        double s; //half perimeter

        //circle
        System.out.println("Enter the radius of your circle:");

        radius = read.nextFloat();
        area = 3.14 * radius * radius;
        perimeter = radius * 3.14 * 2;

        System.out.println("The area is: " + area);
        System.out.println("The circumference is: " + perimeter);

        //square
        System.out.println("Enter the lenght a side of your square:");
        squareLength = read.nextDouble();

        area = squareLength * squareLength;
        perimeter = squareLength * 4;

        System.out.println("The area is: " + area);
        System.out.println("The perimeter is: " + perimeter);

        //triangle
        System.out.println("Enter the length of the first side of your triangle");
        triangleSides[0] = read.nextDouble();
        System.out.println("Enter the length of the second side of your triangle");
        triangleSides[1] = read.nextDouble();
        System.out.println("Enter the length of the third side of your triangle");
        triangleSides[2] = read.nextDouble();

        perimeter = triangleSides[0] + triangleSides[1] + triangleSides[2];
        s = perimeter / 2;
        area = Math.sqrt(s * (s - triangleSides[0]) * (s - triangleSides[1]) * (s - triangleSides[2]));

        System.out.println("The area is: " + area);
        System.out.println("The perimeter is: " + perimeter);
    }
}
