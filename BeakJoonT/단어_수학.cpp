#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

bool cmp(const pair<char, int>& a, const pair<char, int>& b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second > b.second;
}

int main()
{
	int n = 0;
	cin >> n;

	map<char, int> m;
	vector<string> v;
	int maxSize = 0;
	for (int i = 0; i < n; i++) {
		string tmp = "";
		cin >> tmp;
		v.push_back(tmp);

		int tmpNum = 1;
		for (int j = tmp.length() - 1; j >= 0; j--) {
			m[tmp[j]] += tmpNum;
			tmpNum *= 10;
		}
	}

	vector<pair<char, int>> vec(m.begin(), m.end());
	sort(vec.begin(), vec.end(), cmp);

	m.clear();
	int mul = 9;
	for (auto num : vec) {	
		if (m[num.first] == 0) {
			m[num.first] = mul;
			mul--;
		}		
	}

	int answer = 0;
	for (int i = 0; i < v.size(); i++) {
		mul = 1;
		for (int j = v[i].size() - 1; j >= 0; j--) {
			answer += m[v[i][j]] * mul;
			mul *= 10;
		}
	}

	cout << answer;
}