#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

// Bubble sort function
void bubbleSort(int a[], int n)
{
    int i, j, temp;
    for (i = 0; i < n - 1; i++)
    {
        for (j = 0; j < n - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

// Insertion sort function
void insertionSort(int a[], int n)
{
    int i, j, key;
    for (int i = 1; i < n; i++)
    {
        key = a[i];
        j = i - 1;
        while (j >= 0 && a[j] > key)
        {
            a[j + 1] = a[j];
            j = j - 1;
        }
        a[j + 1] = key;
    }
}

// Function to print array
void printArray(int a[], int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
}

int main()
{
    int n;
    printf("Enter the number 'n' of integers: ");
    scanf("%d", &n);
    int a[n];

    printf("Enter the integers: ");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    pid_t pid = fork();
    if (pid == 0)
    {
       
        printf("Child process sorting using insertion\n");
        insertionSort(a, n);
        printf("Child process sorted array: ");
        printArray(a, n);
    }
    else
    {
       
        wait(NULL); 
        printf("Parent process sorting using bubble\n");
        bubbleSort(a, n);
        printf("Parent process sorted array: ");
        printArray(a, n);
    }
}

