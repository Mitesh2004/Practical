#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>

void list(char option, char *dirName) {
    DIR *dir = opendir(dirName);
    struct dirent *entry;
    struct stat buff;
    int count = 0;

    while ((entry = readdir(dir)) != NULL) {
        switch (option) {
            case 'f':
                printf("%s\n", entry->d_name);
                break;
            case 'n':
                count++;
                break;
            case 'i':
                stat(entry->d_name, &buff);
                printf("%s\t%ld\n", entry->d_name, (long)buff.st_ino);
                break;
        }
    }

    if (option == 'n') printf("Total No. of Entries = %d\n", count);
    closedir(dir);
}

int main() {
    char cmd[80], o[20], fn[20];

    while (1) {
        printf("myShell$ ");
        fgets(cmd, 80, stdin);

        if (sscanf(cmd, "list %s %s", o, fn) == 2) list(o[0], fn);
        else if (strcmp(cmd, "exit\n") == 0) break;
        else printf("Usage: list <f/n/i> <directory>\n");
    }

    return 0;
}
