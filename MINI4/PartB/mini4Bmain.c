#include <stdio.h>
#include "mini4Bphone.c"

int menu() {
    int choice;
    printf("Phonebook Menu: (1)Add, (2)Find, (3)List, (4)Quit> ");
    scanf("%d", &choice);
    return choice;
}

int main() {
    int choice;
    int size;
    printf("Size of phonebook: ");
    scanf("%d", &size);
    phonebook = (struct PHONE_RECORD*) malloc(sizeof(struct PHONE_RECORD)*size);
    if (phonebook == NULL){
        printf("Array to large! Program terminated.\n");
        return 2;
    }
    loadCSV(size);
    phonebook->name[0] = '\0';
    phonebook->birthdate[0] = '\0';
    phonebook->phone[0] = '\0';
    while (1) {
        choice = menu();
        if (choice == 1) {
            addRecord(size);
        } else if (choice == 2) {
            findRecord();
        } else if (choice == 3) {
            listRecords();
        } else if (choice == 4) {
            saveCSV();
            printf("End of phonebook program\n");
            break;
        } else {
            printf("Invalid choice\n");
        }
    }
    free(phonebook);
    return 0;
}
