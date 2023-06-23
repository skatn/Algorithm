#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int id;
    int gas;
} Machine;

int main()
{
    int n;
    scanf("%d", &n);

    Machine machine[n];
    for(int i=0; i<n; i++){
        scanf("%d %d", &machine[i].id, &machine[i].gas);
    }

    for(int i=1; i<101; i++){
        for(int j=0; j<n; j++){
            if(machine[j].id == i){
                printf("%d %d\n", machine[j].id, machine[j].gas);
            }
        }
    }
    return 0;
}
