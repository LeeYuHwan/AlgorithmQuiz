#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0, C = 0, M = 0;
	cin >> N >> C >> M;

	vector<pair<int, int>> v;
	vector<vector<int>> wv(N + 1);

	for (int i = 1; i <= N; i++) {
		vector<int> tmp(N + 1);
		wv[i] = tmp;
	}

	for (int i = 0; i < M; i++) {
		int start = 0, end = 0, box = 0;
		cin >> start >> end >> box;
		v.push_back(make_pair(start, end));
		wv[start][end] = box;
	}
		
	sort(v.begin(), v.end(), cmp);

	vector<int> maxW(N + 1);
	int answer = 0;
	for (int i = 0; i < M; i++) {
		int weight = 0;
		for (int j = v[i].first; j < v[i].second; j++) {
			if (weight < maxW[j]) weight = maxW[j];
		}

		int current = 0;
		if (wv[v[i].first][v[i].second] > (C - weight)) current = C - weight;
		else current = wv[v[i].first][v[i].second];
		answer += current;

		for (int j = v[i].first; j < v[i].second; j++) {
			maxW[j] += current;
		}
	}
	cout << answer;
}