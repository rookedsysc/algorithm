import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		long d =0, g=0;
		boolean[] visited = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			long a = list[i].size();
			if(a >= 3) {
				g += (a*(a-1)*(a-2))/6;
			}
			
			visited[i] = true;
			for(int next : list[i]) {
				long b = list[next].size();
				if(!visited[next]) {
					d += (a-1)*(b-1);
				}
			}
		}
		
		if(d > 3*g) {
			System.out.println("D");
		}else if(d < 3*g) {
			System.out.println("G");
		}else {
			System.out.println("DUDUDUNGA");
		}
	}
}