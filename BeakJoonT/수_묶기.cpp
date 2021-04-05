#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N = 0;
	
	cin >> N;

	vector<int> v;
	for (int i = 0; i < N; i++) {
		int num = 0;

		cin >> num;
		v.push_back(num);
	}

	sort(v.begin(), v.end());

	int minusCnt = 0;
	int plusCnt = 0;
	for (int i = 0; i < N; i++) {
		if (v[i] > 0) break;
		minusCnt++;
	}

	plusCnt = v.size() - minusCnt;
	int answer = 0;
	for (int i = 0; i < minusCnt; i += 2) {
		int tmp = 1;
		if (i + 1 >= minusCnt) break;
		for (int j = 0; j < 2; j++) {
			tmp = (v[i] * v[i + 1]);
		}

		answer += tmp;
	}
	
	if (minusCnt % 2 == 1) answer += v[minusCnt - 1];

	if (minusCnt < v.size()) {
		for (int i = v.size() - 1; i >= minusCnt; i -= 2) {
			int tmp = 1;
			if (i - 1 < minusCnt) break;
			for (int j = 0; j < 2; j++) {
				if (v[i] == 1 || v[i - 1] == 1) tmp = (v[i] + v[i - 1]);
				else tmp = (v[i] * v[i - 1]);
			}

			answer += tmp;
		}
	}

	if (plusCnt % 2 == 1) answer += v[minusCnt];
	cout << answer;
}