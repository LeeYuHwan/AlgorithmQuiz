#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int R = 0, C = 0, T = 0;
	cin >> R >> C >> T;

	int airH1 = 0;
	int airH2 = 0;
	bool firstAir = true;
	vector<vector<int>> v;
	vector<vector<bool>> check;
	for (int i = 0; i < R; i++) {
		vector<int> tmp;
		vector<bool> cTmp;
		for (int j = 0; j < C; j++) {
			int n = 0;
			cin >> n;

			if (n == -1) {
				if (firstAir) {
					airH1 = i;
					firstAir = false;
				}
				else airH2 = i;
			}
			tmp.push_back(n);
			if (n != -1 && n != 0) cTmp.push_back(true);
			else cTmp.push_back(false);
		}
		v.push_back(tmp);
		check.push_back(cTmp);
	}
	for (int t = 0; t < T; t++) {

		vector<vector<int>> tmp(R, vector<int>(C, 0));
		vector<vector<bool>> cTmp(R, vector<bool>(C, false));
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (v[i][j] != -1 && check[i][j]) {
					int cnt = 0;
					cTmp[i][j] = true;
					if (i > 0) {
						bool sw = false;
						if (j == 0) {
							if (i - 1 != airH2) sw = true;
						}
						else sw = true;

						if (sw) {
							if (check[i - 1][j]) {
								tmp[i - 1][j] += (v[i][j] / 5);
							}
							else v[i - 1][j] += (v[i][j] / 5);
							cnt++;

							if (v[i - 1][j] != 0) cTmp[i - 1][j] = true;
						}
					}
					if (j > 0) {
						bool sw = false;
						if (i == airH1 || i == airH2) {
							if (j - 1 != 0) sw = true;
						}
						else sw = true;
						if (sw) {
							if (check[i][j - 1]) {
								tmp[i][j - 1] += (v[i][j] / 5);
							}
							else v[i][j - 1] += (v[i][j] / 5);
							cnt++;

							if (v[i][j - 1] != 0) cTmp[i][j - 1] = true;
						}					
					}
					if (i < R - 1) {
						bool sw = false;
						if (j == 0) {
							if (i + 1 != airH1) sw = true;
						}
						else sw = true;
						if (sw) {
							if (check[i + 1][j]) {
								tmp[i + 1][j] += (v[i][j] / 5);
							}
							else v[i + 1][j] += (v[i][j] / 5);
							cnt++;

							if (v[i + 1][j] != 0) cTmp[i + 1][j] = true;
						}		
					}
					if (j < C - 1) {
						if (check[i][j + 1]) {
							tmp[i][j + 1] += (v[i][j] / 5);
						}
						else v[i][j + 1] += (v[i][j] / 5);
						cnt++;

						if (v[i][j + 1] != 0) cTmp[i][j + 1] = true;
					}
					v[i][j] -= (v[i][j] / 5) * cnt;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				v[i][j] += tmp[i][j];
				check[i][j] = cTmp[i][j];
			}
		}
		int air1 = v[airH1][C - 1];
		bool check1 = check[airH1][C - 1];
		for (int i = C - 1; i > 1; i--) {
			v[airH1][i] = v[airH1][i - 1];
			check[airH1][i] = check[airH1][i - 1];
		}
		v[airH1][1] = 0;
		check[airH1][1] = false;

		int air2 = v[0][C - 1];
		bool check2 = check[0][C - 1];
		for (int i = 0; i < airH1 - 1; i++) {
			v[i][C - 1] = v[i + 1][C - 1];
			check[i][C - 1] = check[i + 1][C - 1];
		}
		v[airH1 - 1][C - 1] = air1;
		check[airH1 - 1][C - 1] = check1;

		int air3 = v[0][0];
		bool check3 = check[0][0];
		for (int i = 0; i < C - 1; i++) {
			v[0][i] = v[0][i + 1];
			check[0][i] = check[0][i + 1];
		}
		v[0][C - 2] = air2;
		check[0][C - 2] = check2;

		for (int i = airH1 - 1; i > 1; i--) {
			v[i][0] = v[i - 1][0];
			check[i][0] = check[i - 1][0];
		}
		v[1][0] = air3;
		check[1][0] = check3;

		int air1_2 = v[airH2][C - 1];
		bool check1_2 = check[airH2][C - 1];
		for (int i = C - 1; i > 1; i--) {
			v[airH2][i] = v[airH2][i - 1];
			check[airH2][i] = check[airH2][i - 1];
		}
		v[airH2][1] = 0;
		check[airH2][1] = false;

		int air2_2 = v[R - 1][C - 1];
		bool check2_2 = check[R - 1][C - 1];
		for (int i = R - 1; i > airH2; i--) {
			v[i][C - 1] = v[i - 1][C - 1];
			check[i][C - 1] = check[i - 1][C - 1];
		}
		v[airH2 + 1][C - 1] = air1_2;
		check[airH2 + 1][C - 1] = check1_2;

		int air3_2 = v[R - 1][0];
		bool check3_2 = check[R - 1][0];
		for (int i = 0; i < C - 1; i++) {
			v[R - 1][i] = v[R - 1][i + 1];
			check[R - 1][i] = check[R - 1][i + 1];
		}
		v[R - 1][C - 2] = air2_2;
		check[R - 1][C - 2] = check2_2;

		for (int i = airH2 + 1; i < R - 1; i++) {
			v[i][0] = v[i + 1][0];
			check[i][0] = check[i + 1][0];
		}
		v[R - 2][0] = air3_2;
		check[R - 2][0] = check3_2;
	}

	int answer = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (v[i][j] != -1) answer += v[i][j];
		}
	}

	cout << answer;
}