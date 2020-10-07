import java.util.ArrayList;
import java.util.List;

public class minimum_path_sum_triangle
{
    public static void main(String[] args) {
        List<List<Integer>> arrlist = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        arrlist.add(new ArrayList<>(temp));
        temp.remove(temp.size()-1);
        temp.add(6);
        temp.add(4);
        arrlist.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(5);
        temp.add(2);
        temp.add(7);
        arrlist.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(9);
        temp.add(1);
        temp.add(8);
        temp.add(6);
        arrlist.add(new ArrayList<>(temp));
        temp.clear();

        minPathSum(arrlist);
    }

    public static void minPathSum(List<List<Integer>> arrList)
    {
        System.out.println(arrList);
        for (int i=arrList.size()-2;i>=0;i--)
        {
            for (int j=0;j<arrList.get(i).size();j++)
            {
                arrList.get(i).set(j,arrList.get(i).get(j)+Math.min(arrList.get(i+1).get(j),arrList.get(i+1).get(j+1)));
            }
        }
        System.out.println(arrList.get(0).get(0));
    }
}
