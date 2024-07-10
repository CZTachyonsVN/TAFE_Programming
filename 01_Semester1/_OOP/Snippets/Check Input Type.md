#csharp #snippets #input

```csharp
Console.WriteLine("Your input:");  
string? input = Console.ReadLine();  
_ = CheckInputType(input, typeof(int));  
  
static bool CheckInputType(string? input, Type dataType)  
{  
    bool isCurrentType = false;  
    if (input is not null)  
    {        switch (Type.GetTypeCode(dataType))  
        {            case TypeCode.Int32:  
            case TypeCode.Int16:  
            case TypeCode.Int64:  
                isCurrentType = int.TryParse(input, out int number);  
                Console.WriteLine(isCurrentType ? typeof(int) : "not int");  
                break;  
            case TypeCode.String:  
                isCurrentType = true;  
                Console.WriteLine(isCurrentType ? typeof(string): "not string");  
                break;  
            case TypeCode.Boolean:  
                isCurrentType = bool.TryParse(input, out bool boolean);  
                Console.WriteLine(isCurrentType ? typeof(bool) : "not bool");  
                break;  
            case TypeCode.Double:  
                isCurrentType = double.TryParse(input, out double dbl);  
                Console.WriteLine(isCurrentType ? typeof(double) : "not double");  
                break;  
            default:  
                isCurrentType = false;  
                Console.WriteLine("type not available");  
                break;  
        }    }    return isCurrentType;  
}
```
