import java.util.Arrays;

public class imp_min_no_platforms
{
    public static void main(String[] args) {

        int[] arr = {900,940,950,1100,1500,1800};       // arrival Time
        int[] dep = {910,1200,1120,1130,1900,2000};     // Departure Time
        // minimum number of platform at a time that is required to hold all the trains
        countPlatforms(arr,dep);
        minPlatForm(arr,dep);
    }

    // Time - O(n^2)         space - O(1)
    public static void countPlatforms(int[] arr,int[] dep)
    {
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            count = 1;
            for (int j=i+1;j<arr.length;j++)
            {
                if ((arr[j]<arr[i] && dep[j]<arr[i])
                        || (dep[i]<arr[j] && dep[i]<dep[j]))
                    continue;
                count++;
            }

            max = Math.max(max,count);
        }

        System.out.println(max);
    }

    // Time - O(nlogn)              space - O(1)
    public static void minPlatForm(int []arr,int []dep)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int min_platform_needed = 1;        // maximum platform needed at a time
        int curr_platform_needed = 1;
        int i = 0;
        int j = 1;
        while (i<arr.length && j<arr.length)
        {
            if (dep[i]<arr[j])
            {
                curr_platform_needed--;
                i++;
            }
            if (dep[i]>=arr[j])
            {
                curr_platform_needed++;
                j++;
            }
            min_platform_needed = Math.max(min_platform_needed,curr_platform_needed);
        }

        System.out.println(min_platform_needed);
    }
}
