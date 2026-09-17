import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] nums = new Num[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = new Num(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < N; i++) {
            nums[nums[i].idx].rank = i + 1;
        }
        
        for (Num num : nums) {
            System.out.print((num.rank) + " ");
        }
    }
}

class Num implements Comparable<Num> {
    int number;
    int idx;
    int rank;
    
    public Num(int number, int idx) {
        this.number = number;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Num o) {
        return this.number - o.number;
    }
}