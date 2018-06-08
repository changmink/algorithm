#include <cstdio>
long long a[1000000];
long long tree[3000000];
long long init(int node, int start, int end) {
    if (start == end) {
        return tree[node] = a[start];
    } else {
        return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1, (start+end)/2+1, end);
    }
}
void update(int node, int start, int end, int i, long long diff) {
//수를 하나 찾는다
    if (i < start || i > end) return;
    tree[node] = tree[node] + diff;
    if (start != end) {
        update(node*2, start, (start+end)/2, i, diff);
        update(node*2+1, (start+end)/2+1, end, i, diff);
    }
}
long long sum(int node, int start, int end, int i, int j) {
    //범위를 찾는다
    if (i > end || j < start) {
        return 0;
    }
    if (i <= start && end <= j) {
        return tree[node];
    }
    return sum(node*2, start, (start+end)/2, i, j) + sum(node*2+1, (start+end)/2+1, end, i, j);
}
int main() {
    int n, m, k;
    scanf("%d %d %d",&n,&m,&k);
    m += k;
    for (int i=0; i<n; i++) {
        scanf("%lld",&a[i]);
    }
    init(1, 0, n-1);
    while (m--) {
        int t1,t2,t3;
        scanf("%d",&t1);
        if (t1 == 1) {
            int t2;
            long long t3;
            scanf("%d %lld",&t2,&t3);
            t2-=1;
            long long diff = t3-a[t2];
            a[t2] = t3;
            update(1, 0, n-1, t2, diff);
        } else if (t1 == 2) {
            int t2,t3;
            scanf("%d %d",&t2,&t3);
            printf("%lld\n",sum(1, 0, n-1, t2-1, t3-1));
        }
    }
    return 0;
}