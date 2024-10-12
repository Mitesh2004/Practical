#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

void bubbleSort(int a[], int n)
{
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (a[j] > a[j + 1])
            {
                // Swap using a temporary variable
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
}

int main()
{
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);

    int a[n];
    printf("Enter %d integers: ", n);
    for (int i = 0; i < n; i++) 
        scanf("%d", &a[i]);

    fork(); // Fork process

    bubbleSort(a, n); // Sort array
    printf("Sorted array: ");
    for (int i = 0; i < n; i++) 
        printf("%d ", a[i]);
    printf("\n");

    char *args[n + 2];
    args[0] = "./binary_search";
    for (int i = 0; i < n; i++)
    {
        args[i + 1] = malloc(10);
        snprintf(args[i + 1], 10, "%d", a[i]);
    }
    args[n + 1] = NULL;

    execve(args[0], args, NULL);
    perror("execve"); // If execve fails

}
