#include <stdio.h>
#include <stdlib.h>

int binary_search(int a[], int n, int target)
{
    int L = 0, R = n - 1;
    while (L <= R)
    {
        int mid = (L + R) / 2;
        if (a[mid] == target) return mid;
        if (a[mid] < target) L = mid + 1;
        else R = mid - 1;
    }
    return -1;
}

int main(int argc, char *argv[])
{
    if (argc < 2) return 1;

    int a[argc - 1], target;
    for (int i = 0; i < argc - 1; ++i)
        a[i] = atoi(argv[i + 1]);

    printf("Enter number to search: ");
    scanf("%d", &target);

    int result = binary_search(a, argc - 1, target);
    printf(result != -1 ? "Found at index %d\n" : "Not found\n", result);
}
