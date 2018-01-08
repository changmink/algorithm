#include <iostream>
#include <vector>
#include <set>
using namespace std;
struct Node {
    int val;
    Node *left;
    Node *right;
    Node() {
        val = 0;
        left = NULL;
        right = NULL;
    }
};
//135페이지에 문자 설명
string preorder(Node *root) {
    string ans = "";
    ans += "V";
    if (root->left) {
        ans += "L";
        ans += preorder(root->left);
        ans += "l";
    }
    if (root->right) {
        ans += "R";
        ans += preorder(root->right);
        ans += "r";
    }
    ans += "v";
    return ans;
}
void remove(Node *root) {
    if (root->left) {
        remove(root->left);
    }
    if (root->right) {
        remove(root->right);
    }
    delete root;
}
int main() {
    ios_base::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    set<string> s;
    for (int k=0; k<n; k++) {
        vector<int> a(m);
        for (int i=0; i<m; i++) {
            cin >> a[i];
        }
        Node *root = new Node;
        root->val = a[0];
        for (int i=1; i<m; i++) {
            Node *cur = root;
            // 삽입하기
            while (true) {
                if (cur->val > a[i]) {//작다 - 왼쪽이다.
                    if (cur->left == NULL) {//왼쪽자식이 업으면 넣고
                        cur->left = new Node;
                        cur->left->val = a[i];
                        break;
                    } else {
                        cur=cur->left; //있으면 탐색
                    }
                } else if (cur->val < a[i]) { //오른쪽도 마찬가지
                    if (cur->right == NULL) {
                        cur->right = new Node;
                        cur->right->val = a[i];
                        break;
                    } else {
                        cur=cur->right;
                    }
                } else {
                    break;
                }
            }
        }

        s.insert(preorder(root));
        remove(root);
    }
    cout << s.size() << '\n';
    return 0;
}