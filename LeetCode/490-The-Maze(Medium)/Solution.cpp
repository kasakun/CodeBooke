class Solution {
private:
    vector<vector<bool>> visited;
    vector<int> dst;

    bool dfs(vector<vector<int>>& maze, vector<int> start) {
        if (visited[start[0]][start[1]]) return false;

        if (start[0] == dst[0] && start[1] == dst[1]) return true;

        visited[start[0]][start[1]] = true;

        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;

        // go until hit the wall
        while (r < maze[0].size() && maze[start[0]][r] == 0)
            ++r;
        if (dfs(maze, vector<int>{start[0], r - 1})) return true;

        while (l >= 0 && maze[start[0]][l] == 0)
            --l;
        if (dfs(maze, vector<int>{start[0], l + 1})) return true;

        while (u >= 0 && maze[u][start[1]] == 0)
            --u;
        if (dfs(maze, vector<int>{u + 1, start[1]})) return true;

        while (d < maze.size() && maze[d][start[1]] == 0)
            ++d;
        if (dfs(maze, vector<int>{d - 1, start[1]})) return true;

        return false;
    }
public:
    bool hasPath(vector<vector<int>>& maze,
                 vector<int>& start,
                 vector<int>& destination) {

        dst = destination;
        visited.resize(maze.size(),
                       vector<bool>(maze[0].size(), false));

        return dfs(maze, start);
    }
};

