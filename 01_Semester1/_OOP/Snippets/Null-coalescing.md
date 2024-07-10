---
noteID: 943f5ead-15ad-48b7-9ff5-68e7396542d9
---
#csharp #null
## ??
- returns the value on its left-hand side of it is not null
- if left-hand value is null, evaluates  and returns the right-hand side
Example
```cs
double SumNumbers(List<double[]> setsOfNumbers, int indexOfSetToSum)
{
    return setsOfNumbers?[indexOfSetToSum]?.Sum() ?? double.NaN;
}

var sum = SumNumbers(null, 0);
Console.WriteLine(sum);  // output: NaN
/```
Example
```cs
private static void Display<T>(T a, T backup)
{
    Console.WriteLine(a ?? backup);
}
```
## ??=
- if left-hand value is null, assign to it the right-hand value
Example
```cs
List<int>? numbers = null;
int? a = null;

Console.WriteLine((numbers is null)); // expected: true
// if numbers is null, initialize it. Then, add 5 to numbers
(numbers ??= new List<int>()).Add(5);
Console.WriteLine(string.Join(" ", numbers));  // output: 5
Console.WriteLine((numbers is null)); // expected: false        


Console.WriteLine((a is null)); // expected: true
Console.WriteLine((a ?? 3)); // expected: 3 since a is still null 
// if a is null then assign 0 to a and add a to the list
numbers.Add(a ??= 0);
Console.WriteLine((a is null)); // expected: false        
Console.WriteLine(string.Join(" ", numbers));  // output: 5 0
Console.WriteLine(a);  // output: 0
```
## Right-associative
```cs
a ?? b ?? c
d ??= e ??= f
//the same as
a ?? (b ?? c)
d ??= (e ??= f)
```
