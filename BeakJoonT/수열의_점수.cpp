#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);	
	vector<long long> plusV;
	vector<long long> minusV;
	int n = 0;
	cin >> n;

	int zero = 0, one = 0;
	for (int i = 0; i < n; i++) {
		int num = 0;
		cin >> num;
		if (num == 0) zero++;
		else if (num == 1) one++;
		else if (num < 0) minusV.push_back(num);
		else plusV.push_back(num);
	}

	sort(plusV.begin(), plusV.end());
	sort(minusV.begin(), minusV.end());

	long long answer = 0;
	if(plusV.size() == 1) answer += plusV[0];
	else {
		for (int i = plusV.size() - 1; i >= 0; i -= 2) {
			if(i == 0) answer += plusV[i];
			else answer += plusV[i] * plusV[i - 1];
		}
	}
	answer += one;
	if (minusV.size() == 1) {
		if (zero == 0) answer += minusV[0];
	}
	else {
		for (int i = 0; i < minusV.size(); i += 2) {
			if (i == minusV.size() - 1) {
				if (zero == 0) answer += minusV[minusV.size() - 1];
			}
			else answer += minusV[i] * minusV[i + 1];
		}
	}
	cout << answer;
}