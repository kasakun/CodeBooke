class MinStack {
private:
    vector<int> _min;
    vector<int> _stack;
public:
    /** initialize your data structure here. */
    MinStack() {
        _min.push_back(INT_MAX);
    }

    void push(int x) {
        _stack.push_back(x);
        if (x < _min.back()) {
            _min.push_back(x);
        } else {
            _min.push_back(_min.back());
        }

    }

    void pop() {
        _stack.pop_back();
        _min.pop_back();
    }

    int top() {
        return _stack.back();
    }

    int getMin() {
        return _min.back();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */

