import java.io.*;
import java.util.*;

class SegmentTree {
    private int[] tree;
    private int[] arr;

    public SegmentTree(int[] input) {
        int n = input.length;
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        this.tree = new int[treeSize];
        this.arr = input;

        // 세그먼트 트리 초기화
        buildTree(0, n - 1, 1);
    }

    private int buildTree(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = buildTree(start, mid, 2 * node) + buildTree(mid + 1, end, 2 * node + 1);
    }

    public int query(int left, int right) {
        return query(0, arr.length - 1, 1, left, right);
    }

    private int query(int start, int end, int node, int left, int right) {
        if (right < start || left > end) { // 범위 밖
            return 0;
        }
        if (left <= start && end <= right) { // 범위 안
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(start, mid, 2 * node, left, right) + query(mid + 1, end, 2 * node + 1, left, right);
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree segmentTree = new SegmentTree(numbers);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1; 
            int right = Integer.parseInt(st.nextToken()) - 1; 

            int result = segmentTree.query(left, right);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}