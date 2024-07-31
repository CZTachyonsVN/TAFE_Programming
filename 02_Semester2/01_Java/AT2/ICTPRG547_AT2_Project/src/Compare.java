import java.util.Comparator;

public class CompareStringCaseInsensitive implements Comparator<Object>
{
    public int compare(Object a, Object b){
        if (a instanceof String && b instanceof String)
        {
            return ((String) a).compareTo((String) b);
        }
        if (a instanceof Integer && b instanceof Integer)
        {
            return ((Integer) a).compareTo(((Integer) b));
        }
        else
        {
            return 0;
        }
        
    }
}
