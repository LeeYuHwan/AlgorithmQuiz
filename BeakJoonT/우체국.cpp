#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0;
	cin >> N;
	
	vector<pair<long long, long long>> v;
	long long sum = 0;
	for (int i = 0; i < N; i++) {
		int x = 0, a = 0;
		cin >> x >> a;
		v.push_back(make_pair(x, a));
		sum += a;
	}

	sort(v.begin(), v.end());
    sum += 1;
	sum /= 2;

    int answer = 0;
	long long tmp = 0;
	for (int i = 0; i < N; i++) {
		tmp += v[i].second;
		if (tmp >= sum) {
			answer = v[i].first;
			break;
		}
	}
    
    cout << answer;
}