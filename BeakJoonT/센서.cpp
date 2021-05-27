#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

	int N = 0, K = 0;
	cin >> N >> K;

	vector<int> v;
	for (int i = 0; i < N; i++) {
		int n = 0;
		cin >> n;
		v.push_back(n);
	}

	sort(v.begin(), v.end());
	vector<int> ansV;

	for (int i = 0; i < N - 1; i++) {
		ansV.push_back(v[i + 1] - v[i]);
	}

	sort(ansV.begin(), ansV.end());
	
	int answer = 0;
	for (int i = 0; i < N - K; i++) {
		answer += ansV[i];
	}

	cout << answer;
}