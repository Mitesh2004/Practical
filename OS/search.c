#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>

void search(char mode, char *searchStr, char *filename) {
    int handle, i = 1, count = 0, j = 0;
    char ch, buffer[80];
    
    if ((handle = open(filename, O_RDONLY)) == -1) {
        perror("Error opening file");
        return;
    }

    while (read(handle, &ch, 1) > 0) {
        if (ch == '\n' || j == sizeof(buffer) - 1) {
            buffer[j] = '\0';  // End current line
            j = 0;  // Reset buffer index
            
            if (strstr(buffer, searchStr)) {
                if (mode == 'f') {
                    printf("%d : %s\n", i, buffer);
                    break;
                } else if (mode == 'c') {
                    count++;
                } else if (mode == 'a') {
                    printf("%d : %s\n", i, buffer);
                }
            }
            i++;  // Line number increment
        } else {
            buffer[j++] = ch;  // Store character in buffer
        }
    }

    if (mode == 'c') {
        printf("Total No. of Occurrences = %d\n", count);
    }

    close(handle);
}

int main() {
    char cmd[80], searchStr[20], filename[20], mode;

    while (1) {
        printf("myShell$ ");
        fgets(cmd, sizeof(cmd), stdin);

        if (sscanf(cmd, "search %c %s %s", &mode, searchStr, filename) == 3) {
            search(mode, searchStr, filename);
        } else if (strcmp(cmd, "exit\n") == 0) {
            break;
        } else {
            printf("Usage: search <f/c/a> <string> <filename>\n");
        }
    }

    return 0;
}

