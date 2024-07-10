#csharp #switch #propertypattern #patternmatching #varpattern #property #var
[Source](https://www.thomasclaudiushuber.com/2021/02/25/c-9-0-pattern-matching-in-switch-expressions/)
Class:
```cs
public class Person
{
    public string FirstName { get; set; }
    public int YearOfBirth { get; set; }
}
```
Main:
```cs
Console.WriteLine("(J)ulie or (T)omas?");
string nameSelect = Console.ReadLine();

Person p = new Person() { FirstName = nameSelect,
		                  YearOfBirth = 1994};

string favoriteTask = p.FirstName switch
{
    "Julia" => "Writing code",
    "Thomas" => "Writing this blog post",
    _ => "Watching TV",
};

Console.WriteLine(favoriteTask);
```
Or:
```cs
string favoriteTask = p switch
{
    Person person when person.YearOfBirth is >= 1980 and <= 1990
      => $"{person.FirstName} listens to metal",
    _ => "Dance like no one is watching"
};

Console.WriteLine(favoriteTask);
```
## Case guard
A _case guard_ is another condition that must be satisfied together with a matched pattern. A case guard must be a Boolean expression. You specify a case guard after the `when` keyword that follows a pattern, as the following example shows:
```cs
public readonly struct Point
{
    public Point(int x, int y) => (X, Y) = (x, y);
    
    public int X { get; }
    public int Y { get; }
}

static Point Transform(Point point) => point switch
{
    { X: 0, Y: 0 }                    => new Point(0, 0),
    { X: var x, Y: var y } when x < y => new Point(x + y, y),
    { X: var x, Y: var y } when x > y => new Point(x - y, y),
    { X: var x, Y: var y }            => new Point(2 * x, 2 * y),
};
```
### Property patterns
```cs
public record Point(int X, int Y);
public record Segment(Point Start, Point End);

static bool IsAnyEndOnXAxis(Segment segment) =>
    segment is { Start: { Y: 0 } } or { End: { Y: 0 } };
```
### Var patterns
```cs
public record Point(int X, int Y);

static Point Transform(Point point) => point switch
{
    var (x, y) when x < y => new Point(-x, y),
    var (x, y) when x > y => new Point(x, -y),
    var (x, y) => new Point(x, y),
};

static void TestTransform()
{
    Console.WriteLine(Transform(new Point(1, 2)));  // output: Point { X = -1, Y = 2 }
    Console.WriteLine(Transform(new Point(5, 2)));  // output: Point { X = 5, Y = -2 }
}
```