class MaxStack {
private:
    stack<int> _stack;
    stack<int> _maxStack;
public:
    /** initialize your data structure here. */
    MaxStack() {

    }

    void push(int x) {
        int _max = _maxStack.empty() ? x : _maxStack.top();

        _maxStack.push(_max > x ? _max : x);
        _stack.push(x);
    }

    int pop() {
        int temp = _stack.top();
        _stack.pop();
        _maxStack.pop();

        return temp;
    }

    int top() {
        return _stack.top();
    }

    int peekMax() {
        return _maxStack.top();
    }

    int popMax() {
        int _max = peekMax();

        stack<int> buf;

        while (top() != _max)
            buf.push(pop());

        pop();

        while (!buf.empty()) {
            int temp = buf.top();
            push(temp);
            buf.pop();
        }

        return _max;
    }
};

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack* obj = new MaxStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->peekMax();
 * int param_5 = obj->popMax();
 */

