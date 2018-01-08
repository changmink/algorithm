#include <iostream>
#include <string>
#include <set>
using namespace std;
int main() {
    int n;
    cin >> n;
    set<string> s;
    while (n--) {
        string name, what;
        cin >> name >> what;
        if (what == "enter") {//엔터면 추가
            s.insert(name);
        } else { //찾아서 지운다
            s.erase(s.find(name));
        }
    }
    //사전 순이 아니라 역순이라서 이렇게 출력한다.
    for (auto it = s.rbegin(); it!=s.rend(); it++) {
        cout << *it << '\n';
    }
    return 0;
}