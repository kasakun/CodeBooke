class MyHashMap {
private:
    vector<list<pair<int, int>>> _map;
    size_t _size = 10000;
public:
    /** Initialize your data structure here. */
    MyHashMap() {
        _map.resize(_size);
    }

    /** value will always be non-negative. */
    void put(int key, int value) {
        auto& _list = _map[key % _size];

        for (auto& entry : _list) {
            if (entry.first == key) {
                entry.second = value;
                return;
            }
        }
        _list.emplace_back(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        const auto& _list = _map[key % _size];

        if (_list.empty())
            return -1;

        for (const auto& entry : _list) {
            if (entry.first == key)
                return entry.second;
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        auto& _list = _map[key % _size];

        for (auto it = _list.begin(); it != _list.end(); ++it) {
            if (it->first == key) {
                _list.erase(it);
                return;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */

