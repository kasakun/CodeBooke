class Solution {
private:
    int getHash(int x, int y) {
        return (x << 16) + y;
    }
public:
    int minAreaRect(vector<vector<int>>& points) {
        int res = INT_MAX;
        unordered_set<int> pts;
        for (auto &p: points) 
            pts.insert(getHash(p[0], p[1]));

        for (int i = 0; i < points.size(); i++) {
            vector<int> &p1 = points[i];
            for (int j = i+1; j < points.size(); j++) {
                vector<int> &p2 = points[j];
                if (p1[0] != p2[0] && p1[1] != p2[1] &&
                    pts.count(getHash(p1[0], p2[1])) &&
                    pts.count(getHash(p2[0], p1[1]))) {
                    int area = abs(p1[0]-p2[0]) * abs(p1[1]-p2[1]);
                    res = min(res, area);
                }
            }
        }
        return res < INT_MAX ? res : 0;
    }

};

