import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] nums = new Num[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i] = new Num(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(nums);
        
        for (Num num : nums) {
            System.out.println(num.number + 1);
        }
    }
}

class Num implements Comparable<Num> {
    int x;
    int y;
    int number;
    
    public Num(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    @Override
    public int compareTo(Num o) {
        int distance1 = Math.abs(this.x) + Math.abs(this.y);
        int distance2 = Math.abs(o.x) + Math.abs(o.y);
        
        if (distance1 > distance2) {
            return 1;
        } else if (distance1 == distance2) {
            return this.number - o.number;
        } else {
            return -1;
        }
    }
}