class Solution {
public:
    int fixedPoint(vector<int>& A) {
        int start = 0, end = A.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] - mid < 0)
                start = mid + 1;
            else
                end = mid;
        }
        return A[start] == start ? start : -1;
    }
};

