#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
//머지소트에서 배열 참칠때를 응용 정렬에 nlogn 찾는데 n
int main() {
    int n, m;
    cin >> n >> m;
    vector<string> a(n), b(m);
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    for (int i=0; i<m; i++) {
        cin >> b[i];
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    vector<string> ans;

    //이부분은 set_interection으로 가능하다. 소스 참고
    for (int i=0, j=0; i<a.size() && j<b.size();) {
        if (a[i] < b[j]) {//다르면 각각 ++해줌
            i++;
        } else if (a[i] > b[j]) {
            j++;
        } else {//같으면 추가
            ans.push_back(a[i]);
            i++;
            j++;
        }
    }
    cout << ans.size() << '\n';
    for (auto &name : ans) {
        cout << name << '\n';
    }
    return 0;
}