#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int T = 0;
	cin >> T;

	for (int t = 0; t < T; t++) {
		int N = 0;
		cin >> N;

		priority_queue<long, vector<long>, greater<long>> pq;
		for (int i = 0; i < N; i++) {
			int n = 0;
			cin >> n;

			pq.push(n);
		}

		long answer = 0;
		while (!pq.empty() && pq.size() != 1) {
			long n1 = pq.top();
			pq.pop();
			long n2 = pq.top();
			pq.pop();
			answer += (n1 + n2);
			pq.push(n1 + n2);
		}
		
		cout << answer << '\n';
	}
}