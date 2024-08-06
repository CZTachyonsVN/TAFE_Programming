package Archive;

import java.util.Comparator;

public final class Compare implements Comparator<Object>
{
    public int compare(Object a, Object b){
        if (a instanceof String && b instanceof String)
        {
            return (((String) a).toLowerCase()).compareTo(((String) b).toLowerCase());
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
