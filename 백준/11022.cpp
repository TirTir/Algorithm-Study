#include <stdio.h>
#include <string.h>

int main() {
    int T = 0, a, b;
    scanf("%d", &T);
    for (int i = 1; i <= T; i++) {
        scanf("%d %d", &a, &b);
        printf("Case #%d: %d + %d = %d\n", i, a, b, a + b);
    }
}