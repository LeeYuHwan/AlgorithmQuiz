#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n = 0;
	vector<long> distance;
	cin >> n;

	for (int i = 0; i < n - 1; i++) {
		long a = 0;
		cin >> a;
		distance.push_back(a);
	}

	long answer = 0;
	long first_city = 0;
	cin >> first_city;
	answer += first_city * distance[0];

	int min_city = first_city;
	
	for (int i = 1; i < n - 1; i++) {
		long city = 0;
		cin >> city;
		if (min_city > city) {
			min_city = city;
		}
		answer += min_city * distance[i];
	}

	cout << answer;
}