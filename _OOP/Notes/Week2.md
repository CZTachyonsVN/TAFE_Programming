# Variables [(Presentation)](../TeachingContent/VariablesAndDataTypes.pptx)
## Typecasting
- the process of changing a datatype of a value
	- e.g. converting `string`="123" to `int`=123
```cs
double a = 3.14;
int b = Convert.ToInt32(a); //Store 'a' into 'b' as an integer

Console.WriteLine(Convert.ToInt32(a)); //Convert 'a' to integer
Console.WriteLine(a.GetType()); //Print datatype of 'a'

Console.Writeline(b); 
Console.WriteLine(b.GetType());
```
Output:
```
3
System.Double
3
System.Int32
```

There are other ways to cast datatypes:
```cs
string s = "1"

int a = (int)s;

int b = int.Parse(s);

int c = 0;
bool d = int.TryParse(s, out c); //bool d =  did parse succeed? if yes, put result (1) in 'c', otherwise, c = 0;

string t = a.ToString();
```
**CAUTION!** If `TryParse` fails, the `out` value is `0`
- Explicit casting = casting to larger datatype
- Implicit casting = casting to smaller datatype
## Console.Read()
```cs
int i = Console.Read(); //Raad() reads the first character. We save the charater into 'i' which will return the ASCII decimal value

Console.WriteLine(i);

Console.WriteLine(Convert.ToChar(i))
```
Input
```
A
```
Output:
```
65
A
```
## String.Replace()
```cs
string phoneNum = "123-456-789";
phoneNum = phoneNum.Replace("-","");

string name = "Wbob Bwobbinsky";
string fullName = name.Insert(0,"Mr.");
```
## String Interpolation
```cs
int i = 50;
string firstName = "Wbob";
string lastName = "Bwobbinsky";

Console.WriteLine($"Hello {firstName} {lastName}! You are {i,5} years old.")
```
Output:
```
Hello Wbob Bwobbinsky! You are 50      years old.
```
## If Else and Boolean [(Presentation)](../TeachingContent/IfElseStatementsAndBooleans.pptx)
## Exercises
```
Ask for length
store the length
Ask to calculate area (S), perimeter(P), or both(B)

IF user input == S
	Calculate area for circle and square
Else If user input ==P
	Calculate perimeter
Else
	Calcualte Both

```