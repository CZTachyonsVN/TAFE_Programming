// See https://aka.ms/new-console-template for more information
#region calculator
//Console.WriteLine("Enter value for 'a'");
//int a = int.Parse(Console.ReadLine());

//Console.WriteLine("Enter value for 'b'");
//int b = int.Parse(Console.ReadLine());

//if (b != 0)
//{

//    int addition = a + b;
//    int difference = a - b;
//    int division = a / b;
//    int multiplication = a * b;
//    int[] answers = new int[4] { addition, difference, division, multiplication };

//    for (int i = 0; i<answers.Length; i++) {
//    Console.WriteLine($"{answers[i]}");
//    }
//}
//else Console.WriteLine("Cannot divide by 0");
#endregion

#region temp conversion
//Console.WriteLine("Enter temperature");
//string tempInput = Console.ReadLine();
//char unit = tempInput.Last<char>();
//tempInput = tempInput.Remove(tempInput.Length - 1, 1);
//Console.WriteLine(tempInput);
//Console.ReadLine();
//double temperature = double.Parse(tempInput);

//switch (unit)
//{
//    case 'f':
//        Console.WriteLine("Temp in C:" + FtoC(temperature) + "c");
//        break;
//    case 'c':
//        Console.WriteLine("Temp in F: " + CtoF(temperature) + "f");
//        break;
//    default:
//        break;
//}
#endregion

#region time conversion
//Console.WriteLine("Please enter time. End with 's' for seconds, 'H' for hours:");
//string input = Console.ReadLine();
//char unit = input.Last<char>();
//input = input.Remove(input.Length - 1, 1);
//double time = double.Parse(input);

//switch (unit)
//{
//    case 's':
//        Console.WriteLine("Time in hours:" + StoH(time) + "H");
//        break;
//    case 'H':
//        Console.WriteLine("Time in seconds: " + HtoS(time) + "s");
//        break;
//    default:
//        break;
//}

#endregion

//string isAdult(int age) => age < 18 ? "Teen" : "Adult";

//Console.WriteLine(isAdult(15));
//Console.WriteLine(isAdult(27));

//Console.ReadLine();

#region avarage
//double[] twoNums = new double[4];
//Console.WriteLine("Give me a number");
//Double.TryParse(Console.ReadLine(), out twoNums[0]);

//Console.WriteLine("Give me another number");
//Double.TryParse(Console.ReadLine(), out twoNums[1]);

//Console.WriteLine("Give me a third number");
//Double.TryParse(Console.ReadLine(), out twoNums[2]);

//Console.WriteLine("Give me a last number");
//Double.TryParse(Console.ReadLine(), out twoNums[3]);

//double avarage = 0;
//for (int i = 0; i < twoNums.Length; i++)
//{
//    avarage += twoNums[i];
//}
//Console.WriteLine($"Your average is {avarage / twoNums.Length}");
#endregion

#region Get age from year of birth
//Console.WriteLine("What year were you born in?");

//int yearOfBirth;

//int.TryParse(Console.ReadLine(),out yearOfBirth);

//int currentYear = 2024;

//int Age =  currentYear - yearOfBirth;

//Console.WriteLine($"You are {Age} years old");

//Console.ReadLine();
#endregion

#region Biggest number
//Random random = new Random();

//int[] numbers = new int[10];

//for (int i = 0; i < numbers.Length; i++)
//{
//    numbers[i] = random.Next(0,99);
//    Console.Write(numbers[i] + " | ");
//}

//int indexCurrent = 0;
//int indexNext = 1;
//while (indexNext < numbers.Length)
//{
//    if (numbers[indexCurrent] >= numbers[indexNext])
//    {
//        indexNext++;
//    }
//    else
//    {
//        indexCurrent = indexNext;
//        indexNext++;
//    }
//}

//Console.WriteLine("The biggest number is: " + numbers[indexCurrent]);

//Console.ReadLine();
#endregion

#region decimal to binary
//Console.WriteLine("Put in a decimal number");
//uint.TryParse(Console.ReadLine(),out var decimalNum);
//var input = decimalNum;
//string result = "";
//while (decimalNum > 0){
//    result = result.Insert(0, (decimalNum % 2).ToString());
//    decimalNum /= 2;}
//Console.WriteLine($"Binary value of {input} is : {result}");
#endregion

#region ordinals
//while (true)
//{
//    string suffix = "";
//    int.TryParse(Console.ReadLine(), out int num);

//    int ones = num % 10;
//    int tens = (int)(Math.Floor(num / 10d)) % 10;
//    if (tens == 1)
//    {
//        suffix = "th";
//    }
//    else
//    {
//        switch (ones)
//        {
//            case 1:
//                suffix = "st";
//                break;
//            case 2:
//                suffix = "nd";
//                break;
//            case 3:
//                suffix = "rd";
//                break;
//            default:
//                suffix = "nd";
//                break;
//        }
//    }
//    Console.WriteLine(num + suffix);
//}
#endregion

#region Divisible by 5 || 3
//int hun = 1;

//while (hun <= 100)
//{
//    string value = "";
//    value = (hun % 3 != 0 && hun % 5 != 0) ? hun.ToString() : ((hun % 3 == 0) ? "Foo" : "");
//    value += (hun % 5 == 0) ? "Fighters" : "";
//    Console.WriteLine(value);
//    hun++;
//}
#endregion

#region Switch expression
//using OOP_Oleg_Week1;

//Console.WriteLine("(J)ulie or (T)omas?");
//string? nameSelect = Console.ReadLine();

//Console.WriteLine("year of birth?");
//int.TryParse(Console.ReadLine(), out int age);

//Person p = new Person()
//{
//    FirstName = nameSelect,
//    YearOfBirth = age
//};

//string favoriteTask = p.FirstName switch
//{
//    "Julia" => "Writing code",
//    "Thomas" => "Writing this blog post",
//    _ => "Watching TV",
//};


//string favoriteTask = p switch
//{
//    Person person when person.YearOfBirth is >= 1980 and <= 1990
//      => $"{person.FirstName} listens to metal",
//    _ => "Dance like no one is watching"
//};


//Console.WriteLine(favoriteTask);

#endregion

#region spaces in string count

//using System.Text.RegularExpressions;
//Console.WriteLine("enter your string:");
//Console.WriteLine($"Your string has {Regex.Matches(Console.ReadLine(), @" ").Count} ammount of spaces");

#endregion

#region is palindrome
//Console.WriteLine("Enter your string");
//string? input = Console.ReadLine();
//Console.WriteLine("Your string " + IsPalindrome(input, out _));

//string IsPalindrome(string? str, out string reverse)
//{
//	reverse = "";

//	for (int i = str.Length - 1; i >= 0; i--)
//	{
//		if (str[i] == ' ') return "has a space";
//		reverse += str[i];
//	}
//	if (reverse == str) return "is a palindrome";
//	else return "is not a palindrome";
//}

#endregion




#region methods

//double StoH(double s)
//{
//    return s / 3660;
//}
//double HtoS(double h)
//{
//    return h * 3660;
//}

//double FtoC(double f)
//{
//    return 5/9*(f-32);
//}

//double CtoF(double c)
//{
//    double result = (c * 9 / 5) + 32;
//    return result;
//}

#endregion