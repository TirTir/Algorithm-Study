#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int N = 0;
    scanf("%d", &N);
    int* arr = (int *)malloc(sizeof(int) * N);
    for (int i = 0; i < N; i++) scanf("%d", &arr[i]);

    int s = arr[0], b = arr[0];
    for (int i = 1; i < N; i++) {
        if (s > arr[i]) s = arr[i];
        if (b < arr[i]) b = arr[i];
    }
    printf("%d %d", s, b);
    free(arr);
}