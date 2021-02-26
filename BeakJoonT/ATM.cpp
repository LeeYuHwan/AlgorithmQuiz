#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int tmp = 0;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());

	int ans = 0;
	
	vector<int> answer;
	for (int i = 0; i < n; i++) {
		ans += v[i];		
		answer.push_back(ans);
	}

	int out = 0;
	for (int i = 0; i < n; i++) {
		out += answer[i];
	}

	cout << out;
}