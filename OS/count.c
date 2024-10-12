#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>

// Function to count characters, words, or lines in a file
void count(char c, char *fn) {
    int lc = 0, wc = 0, cc = 0, handle;
    char ch;
    handle = open(fn, O_RDONLY);
    while (read(handle, &ch, 1) > 0) {
        cc++;
        if (ch == ' ' || ch == '\n') wc++;
        if (ch == '\n') lc++;
    }
    close(handle);
    if (c == 'c') printf("Total No. of Characters = %d\n", cc);
    else if (c == 'w') printf("Total No. of Words = %d\n", wc);
    else if (c == 'l') printf("Total No. of Lines = %d\n", lc);
}

int main() {
    char cmd[80], s[20], fn[20];
    while (1) {
        printf("myShell$ ");
        fgets(cmd, 80, stdin);
        if (sscanf(cmd, "count %s %s", s, fn) == 2) count(s[0], fn);
        else if (strcmp(cmd, "exit\n") == 0) break;
        else printf("Usage: count <c/w/l> <filename>\n");
    }
    return 0;
}
