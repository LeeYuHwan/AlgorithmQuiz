using namespace std;

long long solution(int price, int money, int count)
{
    long long answer = money;

    for (int i = 1; i <= count; i++) {
        answer -= (price * i);
    }

    if (answer >= 0) answer = 0;
    else answer *= -1;

    return answer;
}