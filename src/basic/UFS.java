package basic;

public class UFS {

	static int a[];

	public UFS(int size) {
		a = new int[size + 1];
		for (int i = 1; i <= size; i++) {
			a[i] = i;
		}
	}

	public static int find(int x) {
		if (x == a[x])
			return a[x];
		else {
			a[x] = find(a[x]);
			return a[x];
		}
	}

	public static void union(int x, int y) {
		int fa_x = find(x);
		int fa_y = find(y);
		a[fa_x] = fa_y;
	}

}

class UnionFind {
	// 集合数量
	int count;
	// 父节点集合
	int[] parent;
	// 以x节点为父节点的层数
	int[] rank;

	public UnionFind(char[][] grid) {
		count = 0;
		int m = grid.length;
		int n = grid[0].length;
		parent = new int[m * n];
		rank = new int[m * n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == '1') {
					parent[i * n + j] = i * n + j;
					++count;
				}
				rank[i * n + j] = 0;
			}
		}
	}

	public int find(int i) {
		if (parent[i] != i)
			//路径压缩策略
			parent[i] = find(parent[i]);
		return parent[i];
	}

	public void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		if (rootx != rooty) {
			if (rank[rootx] > rank[rooty]) {
				parent[rooty] = rootx;
			} else if (rank[rootx] < rank[rooty]) {
				parent[rootx] = rooty;
			} else {
				parent[rooty] = rootx;
				rank[rootx] += 1;
			}
			--count;
		}
	}

	public int getCount() {
		return count;
	}
}
