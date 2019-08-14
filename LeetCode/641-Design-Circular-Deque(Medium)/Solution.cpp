class MyCircularDeque {
private:
    int k;
    int cnt;
    int front;
    int rear;
    vector<int> buf;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) : buf(k, 0), cnt(0), k(k), front(k - 1), rear(0) {
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (cnt == k) return false;

        buf[front] = value;
        front = (front - 1 + k) % k;
        ++cnt;
        return true;

}

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (cnt == k) return false;

        buf[rear] = value;
        rear = (rear + 1) % k;
        ++cnt;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (cnt == 0) return false;

        front = (front + 1) % k;
        --cnt;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (cnt == 0) return false;

        rear = (rear - 1 + k) % k;
        --cnt;
        return true;
    }

/** Get the front item from the deque. */
    int getFront() {
        return cnt == 0  ? -1 : buf[(front + 1) % k];
    }

            /** Get the last item from the deque. */
    int getRear() {
        return cnt == 0 ? -1 : buf[(rear - 1 + k) % k];
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return cnt == 0;
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return cnt == k;
    }
};

/**
 ** Your MyCircularDeque object will be instantiated and called as such:
 ** MyCircularDeque* obj = new MyCircularDeque(k);
 ** bool param_1 = obj->insertFront(value);
 ** bool param_2 = obj->insertLast(value);
 ** bool param_3 = obj->deleteFront();
 ** bool param_4 = obj->deleteLast();
 ** int param_5 = obj->getFront();
 ** int param_6 = obj->getRear();
 ** bool param_7 = obj->isEmpty();
 ** bool param_8 = obj->isFull();
 **/
