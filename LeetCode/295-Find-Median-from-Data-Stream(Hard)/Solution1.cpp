/**
 * TLE
 *  Naive sort
 */
class MedianFinder {
private:
    vector<int> nums;
public:
    /** initialize your data structure here. */
    MedianFinder() {
        
    }
    
    // O(1)
    void addNum(int num) {
        nums.push_back(num);
        
        return;
    }
    
    // O(NlogN)
    double findMedian() {
        int size = nums.size();
        
        sort(nums.begin(), nums.end());
        
        return size & 1 ?
               nums[size/2] : (nums[size/2] + nums[size/2 - 1]) *0.5;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
