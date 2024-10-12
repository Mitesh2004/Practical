#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t pid = fork();
    if (pid == 0)
    {
        printf("Child process started with PID: %d\n", getpid());
        printf("Child process's parent PID: %d\n", getppid());
        sleep(5);
        printf("Child process after parent termination, new parent PID: %d\n", getppid());
        printf("Child process is doing some work....\n");
        sleep(10);
        printf("Child process completed work and exiting.\n");
    }
    else
    {  
        printf("Parent process with PID: %d is terminating before child completes.\n", getpid());
        sleep(2);
        printf("Parent process exiting.\n");
        exit(0);
    }
}

