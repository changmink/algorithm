#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;
//맵과 비트마스크
int main() {
    map<string, int> d;
    int n, m;
    cin >> n >> m;
    while (n--) {
        string name;
        cin >> name;
        d[name] |= 1;//듣지 못함
    }
    while (m--) {
        string name;
        cin >> name;
        d[name] |= 2;//보지도 못함
    }
    vector<string> ans;
    for (auto &p : d) {
        if (p.second == 3) {//듣도 봇한 사람
            ans.push_back(p.first);
        }
    }
    cout << ans.size() << '\n';
    for (auto &name : ans) {
        cout << name << '\n';
    }
    return 0;
}
