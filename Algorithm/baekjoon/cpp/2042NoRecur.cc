#include <cstdio>
long long tree[3000000];
int b = 1;
void update(int x, long long diff) {
    x += b;
    tree[x] += diff;
    while (x > 1) {//위로 올라가면서 값을 바꿔간다.
        tree[x/2] += diff;
        x /= 2;
    }
}
long long sum(int l, int r) {
    l += b;
    r += b;
    long long ans = 0;
    while (l < r) {
        if (l%2 == 0) {//왼쪽이 왼쪽 자식
            l /= 2;//위로 올라간다
        } else {//왼쪽이 오른쪽 자식
            ans += tree[l]; //합을 더하고
            l += 1;//오른쪽으로 이동하고
            l /= 2;//위
        }
        if (r%2 == 1) {//오른쪽이 오른쪽 자식
            r /= 2;//위로 올라간다
        } else {//오른쪽이 왼쪾 자
            ans += tree[r];
            r -= 1;//왼쪽으로 가서
            r /= 2;//위로 올라감
        }
    }
    if (l == r) {//조심 - 한번만 더해야한다.
        ans += tree[l];
    }
    return ans;
}
int main() {
    int n, m, k;
    scanf("%d %d %d",&n,&m,&k);
    // 가장 가까운 2ㅅk찾기
    m += k;
    while (b <= n) {
        b *= 2;
    }
    b -= 1;
    //입력 받으면서 값을 바꿈
    for (int i=1; i<=n; i++) {
        long long x;
        scanf("%lld",&x);
        update(i, x);
    }
    while (m--) {
        int t1;
        scanf("%d",&t1);
        if (t1 == 1) {
            int t2;
            long long t3;
            scanf("%d %lld",&t2,&t3);
            update(t2, t3-tree[b+t2]);
        } else if (t1 == 2) {
            int t2,t3;
            scanf("%d %d",&t2,&t3);
            printf("%lld\n",sum(t2, t3));
        }
    }
    return 0;
}