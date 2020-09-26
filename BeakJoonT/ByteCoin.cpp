#include<iostream>
#include<vector>
using namespace std;

int main()
{
	int n = 0;
	long w = 0;
	long coin = 0;
	vector<int> day;

	cin >> n;
	cin >> w;

	int a = 0;
	for (int i = 0; i < n; i++) {
		cin >> a;
		day.push_back(a);
	}

	for (int i = 0; i < n; i++) {
		if (i < n - 1 && coin == 0) {
			if (day[i] < day[i + 1]) {
				coin += w / day[i];
				w %= day[i];
			}
		}
		else if (i < n - 1 && coin > 0) {
			if (day[i] > day[i + 1]) {
				w += day[i] * coin;
				coin = 0;
			}
		}
	}

	if (coin > 0) {
		w += day[day.size() - 1] * coin;
		coin = 0;
	}

	cout << w;
}