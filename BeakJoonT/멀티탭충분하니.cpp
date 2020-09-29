#include<iostream>
#include<vector>
using namespace std;

int main()
{
	int n = 0;
	int k = 0;
	string answer = "NO";
	vector<int> a;

	cin >> n >> k;

	int tmp = 0;
	for (int i = 0; i < k; i++) {
		cin >> tmp;
		a.push_back(tmp);
	}

	if (n <= k) {
		answer = "YES";
	}
	else {
		for (int i = 0; i < k; i++) {
			n -= (a[i] / 2);
			if (a[i] % 2 == 1) n -= 1;
		}
		if (n <= 0) answer = "YES";
	}

	cout << answer;
}