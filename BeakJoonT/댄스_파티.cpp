#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0;
	
	cin >> N;
	
	vector<int> manP, manM;
	vector<int> womanP, womanM;
	for (int i = 0; i < N; i++) {
		int n = 0;
		cin >> n;
		if (n > 0) manP.push_back(n);
		else manM.push_back(-1 * n);
	}
	for (int i = 0; i < N; i++) {
		int n = 0;
		cin >> n;
		if (n > 0) womanP.push_back(n);
		else womanM.push_back(-1 * n);
	}

	sort(manP.begin(), manP.end());
	sort(manM.begin(), manM.end());
	sort(womanP.begin(), womanP.end());
	sort(womanM.begin(), womanM.end());

	int answer = 0;

	if (womanP.size() > 0) {
		int idx = 0;
		for (int i = 0; i < manM.size(); i++) {
			if (manM[i] > womanP[idx]) {
				answer++;
				idx++;

				if (idx >= womanP.size()) break;
			}
		}
	}
	
	if (manP.size() > 0) {
		int idx = 0;
		for (int i = 0; i < womanM.size(); i++) {
			if (manP[idx] < womanM[i]) {
				answer++;
				idx++;

				if (idx >= manP.size()) break;
			}
		}
	}

	cout << answer;
}