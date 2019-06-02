class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string>& paths) {
        vector<vector<string>> res;
        unordered_map<string, vector<string>> files;
        
        for (auto& path : paths) {
            stringstream ss(path);
            string s, root;
            
            // get current file path
            getline(ss, root, ' ');
            
            // get file
            while (getline(ss, s, ' ')) {
                string file_path = root + '/' + s.substr(0, s.find('('));
                string file_content = s.substr(s.find('(') + 1, s.find(')') - s.find('(') - 1);
                
                files[file_content].push_back(file_path);
            }
        }

        for (auto& entry : files) {
            // only record duplicates
            if ((int)entry.second.size() == 1) continue;
            vector<string> same_content_files;
            for (auto& file : entry.second) {
                same_content_files.push_back(file);
            }
            res.push_back(same_content_files);
        }
        
        return res;
    }
};