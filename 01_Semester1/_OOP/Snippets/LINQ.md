#csharp  #linq #collections
```csharp
Random random = new Random();  
int[] numArray = new int[10];  
  
numArray.ToList().ForEach(num =>  
{  
    num = random.Next(0, 10);  
    Console.WriteLine(num);  
});  
Console.ReadLine();
```