import java.util.ArrayList;
import java.util.List;

public class Flattener {

    public static List<Object> flattenRecursive(List<Object> sourceList){
        List<Object> list = new ArrayList<>();
        return flattenRecursive(sourceList, list);
    }

    public static List<Object> flattenRecursive(List<?> sourceList, List<Object> targetList){

        for(int i = 0; i< sourceList.size(); i++){
            if(sourceList.get(i) instanceof List){
                flattenRecursive((List<?>) sourceList.get(i), targetList);
            } else{
                targetList.add(sourceList.get(i));
            }
        }
        return targetList;
    }
}
