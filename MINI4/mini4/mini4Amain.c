#include <stdio.h>
#include "mini4Aphone.c"

int menu() {
    int choice;
    printf("Phonebook Menu: (1)Add, (2)Find, (3)List, (4)Quit> ");
    scanf("%d", &choice);
    return choice;
}

int main() {
    int choice;
    loadCSV();
    choice = menu();
    while(choice != 4){
        if(choice == 1){
            addRecord();
        } else if(choice == 2){
            findRecord();
        } else if(choice == 3){
            listRecords();
        } else{
            printf("invalid input\n");
        }
        choice = menu();
    }
    printf("End of phonebook program\n");
    saveCSV();
    return 0;
}
