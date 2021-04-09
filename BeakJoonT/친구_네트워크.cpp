#include <iostream>
#include <vector>
#include <map>

using namespace std;

int parent[200001];
int child[200001];

int find(int x) {
	if (x == parent[x])
		return x;
	else
		return parent[x] = find(parent[x]);
}

int unite(int x, int y) {
	x = find(x);
	y = find(y);
	if (x != y) {
		parent[x] = y;
		child[y] += child[x];
		child[x] = 1;
	}
	return child[y];
}

int main()
{
    ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int T = 0;
	cin >> T;

	for (int test = 0; test < T; test++) {
		int F = 0;
		cin >> F;

		for (int i = 0; i < F * 2; i++) {
			parent[i] = i;
			child[i] = 1;
		}

		int a = 0, b = 0, count = 0;
		map<string, int> m;
		for (int i = 0; i < F; i++) {			
			string f1 = "", f2 = "";
			cin >> f1 >> f2;
			
			if (m.count(f1) == 0) m[f1] = count++;
			a = m[f1];
			if (m.count(f2) == 0) m[f2] = count++;
			b = m[f2];

			cout << unite(a, b) << '\n';
		}
		m.clear();
	}
}