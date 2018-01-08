#include <cstdio>
#include <algorithm>
#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <queue>
#include <stack>
#include <sstream>
using namespace std;
struct Edge {
    int to, cost;
    Edge(int to, int cost) : to(to), cost(cost) {
    }
};
const int MAX = 100111;
vector<Edge> a[MAX];
int parent[MAX];
bool check[MAX];
int depth[MAX];
int dist[MAX];
int lca(int u, int v) {
    if (depth[u] < depth[v]) {
        swap(u,v);
    }
    int output = 0;
    while (depth[u] != depth[v]) {
        output += dist[u];
        u = parent[u];
    }
    while (u != v) {
        output += dist[u];
        output += dist[v];
        u = parent[u];
        v = parent[v];
    }
    return output;
}
int main() {
    int n;
    scanf("%d",&n);
    for (int i=0; i<n-1; i++) {
        int u,v,w;
        scanf("%d %d %d",&u,&v,&w);
        a[u].push_back(Edge(v,w));
        a[v].push_back(Edge(u,w));
    }
    depth[1] = 0;
    check[1] = true;
    queue<int> q;
    q.push(1);
    parent[1] = 0;
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        for (Edge &e : a[x]) {
            int y = e.to;
            if (!check[y]) {
                depth[y] = depth[x] + 1;
                dist[y] = e.cost;
                check[y] = true;
                parent[y] = x;
                q.push(y);
            }
        }
    }
    int m;
    scanf("%d",&m);
    while (m--) {
        int u, v;
        scanf("%d %d",&u,&v);
        printf("%d\n",lca(u, v));
    }
    return 0;
}