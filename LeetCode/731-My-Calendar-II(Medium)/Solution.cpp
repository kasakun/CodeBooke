class MyCalendar {
private:
    vector<pair<int, int>> books;
public:
    bool book(int start, int end) {
        for (auto book : books)
            if (max(book.first, start) < min(book.second, end)) return false;

        books.push_back({start, end});
        return true;
    }
};

class MyCalendarTwo {
private:
    vector<pair<int, int>> books;
public:
    bool book(int start, int end) {
        MyCalendar overlaps;
        for (auto book : books) {
            if (max(book.first, start) < min(book.second, end)) { // overlap exist
                auto overlapped = getOverlap(book.first, book.second, start, end);
                if (!overlaps.book(overlapped.first, overlapped.second)) return false; // overlaps overlapped
            }
        }
        books.push_back({ start, end });
        return true;
    }

    pair<int, int> getOverlap(int s0, int e0, int s1, int e1) {
        return { max(s0, s1), min(e0, e1)};
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(start,end);
 */

