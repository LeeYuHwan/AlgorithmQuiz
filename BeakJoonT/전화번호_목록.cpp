#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int t = 0;
	cin >> t;

	for (int test = 0; test < t; test++) {
		int n = 0;
		cin >> n;

		vector<string> v;
		for (int i = 0; i < n; i++) {
			string num = "";

			cin >> num;
			v.push_back(num);
		}

		sort(v.begin(), v.end());

		bool sw = false;
		string answer = "YES";
		for (int i = 0; i < v.size() - 1; i++) {
			if (v[i].size() < v[i + 1].size()) {
				if (v[i + 1].substr(0, v[i].size()) == v[i]) {
					answer = "NO";
					break;
				}
			}
		}
		cout << answer << '\n';
	}
}