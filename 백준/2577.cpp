#define _SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int num = 0, result = 1;
    int count = 3;
    while (count--) {
        scanf("%d", num);
        result *= num;
    }

    num = 0;
    while (result != 0) {
        result /= 10;
        num++;
    }

    char arr[100];
    int cout[11];
    itoa(result, arr, 10);
    
    for (int i = 0; i < sizeof(arr); i++) {
        cout[arr[i]]++;
    }

    for (int i = 0; i < sizeof(cout); i++) {
        printf("%d\n", cout[i]);
    }
}