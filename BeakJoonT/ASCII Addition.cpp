#include <iostream>
#include <string>
using namespace std;
string number[11] = {
	{"xxxxxx...xx...xx...xx...xx...xxxxxx"},//0
	{"....x....x....x....x....x....x....x"},//1
	{"xxxxx....x....xxxxxxx....x....xxxxx"},//2
	{"xxxxx....x....xxxxxx....x....xxxxxx"},//3
	{"x...xx...xx...xxxxxx....x....x....x"},//4
	{"xxxxxx....x....xxxxx....x....xxxxxx"},//5
	{"xxxxxx....x....xxxxxx...xx...xxxxxx"},//6
	{"xxxxx....x....x....x....x....x....x"},//7
	{"xxxxxx...xx...xxxxxxx...xx...xxxxxx"},//8
	{"xxxxxx...xx...xxxxxx....x....xxxxxx"},//9
	{".......x....x..xxxxx..x....x......."}//+
};
int main()
{
	string input[7];
	string tmp = "";

	for (int i = 0; i < 7; i++) {
		cin >> input[i];
	}

	int value1 = 0, value2 = 0;

	int add = 1;
	int idx = 0;
	bool sw = 0;

	for (int i = input[0].length() - 1; i > -1; i--) {
		for (int j = 0; j < 7; j++) {
			idx = 0;
			for (int z = 5 - 1; z > -1; z--){
				idx = i - z;
				tmp += input[j][idx];
				
			}
		}
		
		for (int j = 0; j < 11; j++) {
			if (tmp.compare(number[j]) == 0) {
				if (j == 10) {
					sw = 1;
					add = 1;
				}

				if (sw == 0 && j != 10) {
					int tmp = j * add;
					value2 += tmp;
					add *= 10;
				}
				else if (sw == 1 && j != 10){
					int tmp = j * add;
					value1 += tmp;
					add *= 10;
				}
				
			}
				
		}
			
		if (i == 4) break;

		tmp = "";
	}
	string answer = to_string(value1 + value2);
	string output[7] = {"","","","","","",""};

	int count = 0;
	idx = 0;
	for (int i = 0; i < answer.length(); i++) {
		for (int j = 0; j < 35; j++) {
			output[idx] += number[answer[i] - 48][j];

			count++;
			if (count == 5 && i != answer.length() - 1) {
				output[idx] += ".";
				idx++;
				count = 0;
			}
			else if (count == 5 && i == answer.length() - 1) {
				idx++;
				count = 0;
			}
		}
		idx = 0;
	}
	
	for (int i = 0; i < 7; i++) {
		cout << output[i] << endl;
	}
}