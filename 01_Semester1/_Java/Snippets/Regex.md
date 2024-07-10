#regex #java #programming #snippets
## code
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\d+"); //number of any length
    Matcher matcher = pattern.matcher("Visit W3456Schools!");
    
    int count = 0;
    
    while(matcher.find()){
    	System.out.println(matcher.group());
        count++;        
    }
    
    System.out.println("no of matches: " + count);
    
  }
}
```
## output
```
3456
no of matches: 1
```

Every time `matcher.find()` is called, `matcher` jumps to the next match
```
Any number including decimal or arithmetic operators
(?<number>\d+\.\d+|\d+)|(?<operators>\+|-|\*|\/)
```
