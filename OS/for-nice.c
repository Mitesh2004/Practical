#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
// nice() +19 low to -20 high priority
int main()
{
   
    pid_t  pid = fork();
    if (pid == 0)
    {
        printf("I am child Process. ID = %d\n", getpid());
        printf("priority = %d ,ID = %d\n", nice(-20), getpid());
    }
    else
    {
       
        printf("I am parent Process. ID = %d\n", getppid());
        printf("priority = %d , ID = %d\n", nice(19), getpid());
    }
}
