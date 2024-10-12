#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>


void typeline(char *s, char *fn)
{
    int handle = open(fn, O_RDONLY);

    if (strcmp(s, "a") == 0)
    {
        char ch;
        while (read(handle, &ch, 1) > 0)  putchar(ch);
    }
    else
    {
        int n = atoi(s);
        char ch;
        int lc = 0;

        if (n > 0)
        {
            while (read(handle, &ch, 1) > 0 && lc < n)
            {
                putchar(ch);
                if (ch == '\n')  lc++;
            }
        }
        else
        {
            // Count total lines
            int tl = 0;
            lseek(handle, 0, SEEK_SET);
            while (read(handle, &ch, 1) > 0)
            {
                if (ch == '\n')
                    tl++;
            }
            lseek(handle, 0, SEEK_SET); // Reset file offset

            // Skip lines and print the rest
            lc = tl + n; // Calculate lines to skip
            while (read(handle, &ch, 1) > 0)
            {
                if (lc <= 0)
                    putchar(ch);
                if (ch == '\n')
                    lc--;
            }
        }
    }
    close(handle);
}

int main()
{
    char cmd[80], o[20], fn[20];
    while (1)
    {
        printf("myShell$ ");
        fgets(cmd, /*sizeof(cmd)*/80, stdin);
        if (sscanf(cmd, "typeline %s %s", o, fn) == 2) typeline(o, fn);
        else if (strcmp(cmd, "exit\n") == 0) break;
        else printf("Usage: typeline <n/a> <filename>\n");
    }
}

