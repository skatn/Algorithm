#include <stdio.h>
#include <stdlib.h>

int map[128][128];
int n;
int white, blue;

void func(int x, int y, int width, int height){
    for(int i=y; i<y+height; i++){
        for(int j=x; j<x+width; j++){
            if(map[y][x] != map[i][j]){
                func(x, y, width/2, height/2);
                func(x+width/2, y, width/2, height/2);
                func(x, y+height/2, width/2, height/2);
                func(x+width/2, y+height/2, width/2, height/2);
                return;
            }
        }
    }
    map[y][x]==1? blue++ : white++;
}

int main()
{
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            scanf("%d", &map[i][j]);
        }
    }

    func(0, 0, n, n);
    printf("%d\n%d", white, blue);

    return 0;
}
