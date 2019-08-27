class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        for (auto& row : A) {
            int size = row.size();

            for (int i = 0; i < (size + 1)/2; ++i) {
                int temp = row[i] ^ 1;
                row[i] = row[size - i - 1] ^ 1;
                row[size - i - 1] = temp;
            }
        }

        return A;
    }
};

