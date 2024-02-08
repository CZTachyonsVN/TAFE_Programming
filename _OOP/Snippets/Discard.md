#csharp #variables #discard #lambda 
- Placeholder variables that are to be ignored but need to be declared in the code.
Example:
```cs
bool isInteger = int.TryParse(Console.ReadLine(), out _);
```
Example:
```cs
var p = new Person("John", "Quincy", "Adams", "Boston", "MA");

var (fName, _, city, _) = p;
Console.WriteLine($"Hello {fName} of {city}!");
// The example displays the following output:
//      Hello John of Boston!
```
### Switch Expression
- Every expression including `null`, always matches the discard
```cs
object?[] objects = [CultureInfo.CurrentCulture,
                   CultureInfo.CurrentCulture.DateTimeFormat,
                   CultureInfo.CurrentCulture.NumberFormat,
                   new ArgumentException(), null];
foreach (var obj in objects)
    ProvidesFormatInfo(obj);

static void ProvidesFormatInfo(object? obj) =>
    Console.WriteLine(obj switch
    {
        IFormatProvider fmt => $"{fmt.GetType()} object",
        null => "A null object reference: Its use could result in a NullReferenceException",
        _ => "Some object type without format information"
    });
// The example displays the following output:
//    System.Globalization.CultureInfo object
//    System.Globalization.DateTimeFormatInfo object
//    System.Globalization.NumberFormatInfo object
//    Some object type without format information
//    A null object reference: Its use could result in a NullReferenceException
```
### Null check
- The expression forces a null check. The discard clarifies your intent: the result of the assignment isn't needed or used.
```cs
public static void CheckNullString(string arg)
{
    _ = arg ?? throw new ArgumentNullException(paramName: nameof(arg), message: "arg can't be null");

    // Do work with arg.
}
```
- In the previous example, the debugger will stop the program when the exception is thrown. Without a debugger attached, the exception is silently ignored.