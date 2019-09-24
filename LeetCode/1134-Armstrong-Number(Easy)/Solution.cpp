class Solution {
public:
    bool isArmstrong(int N) {
        int n = N;
        int digits = 0, sum = 0;

        while(n) {
            ++digits;
            n /= 10;
        }

        n = N;

        while(n) {
            sum += pow(n % 10, digits);
            if(sum > N) {
                return false;
            }
            n /= 10;
        }

        return (sum == N);
    }
};

