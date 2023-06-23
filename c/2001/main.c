#include <stdio.h>
#include <stdlib.h>

int main()
{
    int pasta[3], juice[2];
    float min = 9999;

    for(int i=0; i<3; i++){
        scanf("%d", &pasta[i]);
    }
    for(int i=0; i<2; i++){
        scanf("%d", &juice[i]);
    }

    for(int i=0; i<3; i++){
        for(int j=0; j<2; j++){
            float n = pasta[i] + juice[j];
            n += n*0.1;

            if(n < min){
                min = n;
            }
        }
    }

    printf("%.1f", min);
    return 0;
}
