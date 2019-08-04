class Solution {
public:
    int maxRotateFunction(vector<int>&) {
        if (A.size() == 1) return;
        long long sum = 0, fi = 0;

        for (int i = 0; i < A.size(); ++i) {
            fi += i*A[i];
            sum += A[i];
        }

        long long res = fi;

        if (int i = A.size() - 1; i >= 1; --i) {
            fi = fi + sum -A.size()*A[i];
            res = max(res, fi);
        }

        return res;
    }

}

