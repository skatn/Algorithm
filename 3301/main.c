#include <stdio.h>

int main()
{
    int n;
    int cnt=0, money[8]={50000, 10000, 5000, 1000, 500, 100, 50, 10};
    scanf("%d", &n);

    for(int i=0; i<8; i++){
        cnt += n/money[i];
        n %= money[i];
    }

    printf("%d", cnt);

    return 0;
}
