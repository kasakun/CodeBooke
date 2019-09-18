iclass MovingAverage {
private:
    int _size;
    double sum;
    queue<int> _queue;
public:
    /** Initialize your data structure here. */
    MovingAverage(int size) : _size(size), sum(0.0){}

    double next(int val) {
        double res = 0.0;

        _queue.push(val);
        sum += val;

        if (_queue.size() > _size) {
            sum -= _queue.front();
            _queue.pop();
        }

        res = sum * 1.0/_queue.size();

        return res;
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage* obj = new MovingAverage(size);
 * double param_1 = obj->next(val);
 */

