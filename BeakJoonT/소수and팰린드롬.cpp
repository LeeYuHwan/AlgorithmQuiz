#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

int number = 1003001; // 구하고자 하는 소수의 범위
vector<int> primeNum(1003002);
vector<int> sosu;
void primeNumbers()
{
	// primeNum 배열 초기화
	for (int i = 2; i <= number; i++)
	{
		primeNum[i] = i;
	}

	for (int i = 2; i <= sqrt(number); i++)
	{
		// primeNum[i] 가 0이면 이미 소수가 아니므로 continue
		if (primeNum[i] == 0)
			continue;
		// i*k (k<i) 까지의 수는 이미 검사했으므로 j는 i*i 부터 검사해준다.
		for (int j = i * i; j <= number; j += i)
			primeNum[j] = 0;
	}

	// 소수 출력
	for (int i = 2; i <= number; i++)
	{
		if (primeNum[i] != 0) sosu.push_back(primeNum[i]);
			//printf("%d\n", primeNum[i]);
	}
}
int main()
{
	int N = 0;
	cin >> N;
	
	primeNumbers();
	string tmp = "";
	for (int i = 0; i < sosu.size(); i++) {
		if (sosu[i] >= N) {
			tmp = to_string(sosu[i]);
			int size = tmp.length() / 2;
			if (tmp.length() % 2 == 1) size++;
			string c1 = "", c2 = "";
			int reverse = tmp.length() - 1;
			for (int j = 0; j < size; j++) {
				c1 += tmp[j];
				c2 += tmp[reverse];
				reverse--;
			}

			if (c1 == c2) {
				cout << tmp;
				break;
			}
		}
		tmp = "";
	}

}