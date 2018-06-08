#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <set>
//set을 이용 nlogn
using namespace std;
int main() {
    set<string> s;
    int n, m;
    cin >> n >> m;
    while (n--) {//듣지 못한사람
        string name;
        cin >> name;
        s.insert(name);
    }
    vector<string> ans;
    while (m--) {//보지 못한사람
        string name;
        cin >> name;
        if (s.count(name)) {//이사람이 듣지도 못한 사람인
            ans.push_back(name);
        }
    }
    sort(ans.begin(),ans.end());
    cout << ans.size() << '\n';
    for (auto &name : ans) {
        cout << name << '\n';
    }
    return 0;
}