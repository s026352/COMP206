#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct PHONE_RECORD {
    char name[50];
    char birthdate[12];
    char phone[15];
} phonebook[10];


int loadCSV() {
    FILE *q = fopen("phonebook.csv", "r");
    if (q == NULL) {
      //  printf("Phonebook.csv does not exist\n");
        return 2;
    }
    int i = 0;
    int num = 0;
    char s[99];
    char *obj;
    while(fgets(s, 99, q) != NULL){
	if(i == 10){
	    break;
	}
	obj = strtok(s, ",");
	strcpy(phonebook[i].name, obj);
	obj = strtok(NULL, ",");
	strcpy(phonebook[i].birthdate, obj);
	obj = strtok(NULL, "\n");
	strcpy(phonebook[i].phone, obj);
	i++;
	}

    fclose(q);
    return 0;
}

int saveCSV() {
    FILE* file = fopen("phonebook.csv", "w");
    int num = 0;
    while ((phonebook[num]).name[0] != '\0') {
        num++;
    }
    for (int i = 0; i < num; i++) {
        fprintf(file, "%s,%s,%s\n", (phonebook[i]).name, (phonebook[i]).birthdate, (phonebook[i]).phone);
    }
    fclose(file);
    return 0;
}

int addRecord() {
    int i = 0;
    while ((phonebook[i]).name[0] != '\0') {
        i++;
    }
    if(i == 10){
        printf("Error: No more space in the CSV file.\n");
        return 2;
    }
    char temp[100];
    char s1[100];
    char s2[100];
    char s3[100];
    printf("Name: ");
    scanf("%*c%[^\n]",(phonebook[i]).name);
    printf("Birth: ");
    scanf("%s", (phonebook[i]).birthdate);
    printf("Phone: ");
    scanf("%s", (phonebook[i]).phone);
return 0;
}



int findRecord() {
    char name[100];
    printf("Find name: ");
    scanf("%s", name);
    int num = 0;
    while ((phonebook[num]).name[0] != '\0') {
        num++;
    }
    for (int i = 0; i < num; i++) {
        if (strcmp(name, (phonebook[i]).name) == 0) {
            printf("----NAME--------- ------BIRTH------ -----PHONE-------\n");
            printf("%-15s %-15s %-15s\n", (phonebook[i]).name, (phonebook[i]).birthdate, (phonebook[i]).phone);
            return 0;
        }
    }
    printf("Does not exist\n");
    return 1;
}

int listRecords() {
    int num = 0;
    while ((phonebook[num]).name[0] != '\0') {
        num++;
    }
    if(num == 0){
        printf("Phonebook.csv does not exist\n");
        return 1;
    }
    printf("----NAME--------- ------BIRTH------ -----PHONE-------\n");
    int i = 0;
    while ((phonebook[i]).name[0] != '\0'){
        printf("%-15s%-15s%-15s\n", (phonebook[i]).name, (phonebook[i]).birthdate, (phonebook[i]).phone);

        i++;
    }
    return 0;
}




