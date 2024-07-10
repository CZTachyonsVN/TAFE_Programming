#csharp #lambda 
# Statement
Anatomy:
```cs
(input-parameters) => { <sequence-of-statements> }
```
Example:
```cs
Action<string> greet = name =>
{
    string greeting = $"Hello {name}!";
    Console.WriteLine(greeting);
};
greet("World");
// Output:
// Hello World!
```
Example:
```cs

// List to store numbers
List<int> numbers = new List<int>() {36, 71, 12, 15, 29, 18, 27, 17, 9, 34};

// foreach loop to display the list
Console.Write("The list : ");
foreach(var value in numbers)
{
	Console.Write("{0} ", value);
}
Console.WriteLine();

// Using lambda expression
// to calculate square of
// each value in the list
var square = numbers.Select(x => x * x);

// foreach loop to display squares
Console.Write("Squares : ");
foreach(var value in square)
{
	Console.Write("{0} ", value);
}
Console.WriteLine();

// Using Lambda expression to
// find all numbers in the list
// divisible by 3
List<int> divBy3 = numbers.FindAll(x => (x % 3) == 0);

// foreach loop to display divBy3
Console.Write("Numbers Divisible by 3 : ");
foreach(var value in divBy3)
{
	Console.Write("{0} ", value);
}
Console.WriteLine();
```
Output:
> The list : 36 71 12 15 29 18 27 17 9 34 
> Squares : 1296 5041 144 225 841 324 729 289 81 1156 
> Numbers Divisible by 3 : 36 12 15 18 27 9

