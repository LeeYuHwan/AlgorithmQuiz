
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int ca, cb = 0;

        if(a < b) {
            ca = a;
            cb = b;
        }
        else {
            ca = b;
            cb = a;
        }

        if(ca % 2 == 1) ca += 1;
        if(cb % 2 == 1) cb += 1;

        while(cb - ca > 1) {        
            ca /= 2;
            cb /= 2; 

            if(ca % 2 == 1) ca += 1;
            if(cb % 2 == 1) cb += 1;

            answer++;
        }

        return answer;
    }
}