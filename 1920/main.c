#include <stdio.h>

void func(int n){
    if(n==0){
        return;
    }
    func(n>>1);
    printf("%d", n&1);
}

int main()
{
    int n;
    scanf("%d", &n);

    if(n==0){
        printf("0");
    }
    else{
        func(n);
    }
    return 0;
}
