#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct PHONE_RECORD {
	char name[50];
	char birthdate[12];
	char phone[15];
} *phonebook[10];


int loadCSV() {
	FILE *q = fopen("phonebook.csv", "rt");
	if (q == NULL) {
		printf("Error: phonebook.csv does not exist\n");
		return 2;
	}
	int i = 0;
	int num = 0;
	char obj[100] = "";
	char c;
	while(!feof(q) || i == 9) { //error possible at i==9
	c = fgetc(q);
	if(c == ','){
		if(num == 0){
			strcpy((phonebook[i]).name, obj);
			num++;
			obj[100] = "";
		}
		if(num == 1){
			strcpy((phonebook[i]).birthdate, obj);
			num++;
			obj[100] = "";
		}
	} else if(c == '\n'){
		strcpy((phonebook[i]).phone, obj);
		num = 0;
		i++;
		obj[100] = "";
	} else {
		strcat(obj, c);

		}
	 
	}
	fclose(fp);
	}

int saveCSV() {
	FILE* file = fopen("phonebook.csv", "w");
    for (int i = 0; i < num_records; i++) {
        fprintf(file, "%s,%s,%s\n", phonebook[i].name, phonebook[i].birthdate, phonebook[i].phone);
    }
    fclose(file);
}

int addRecord() {
	int i = 0;
	while ((phonebook[i]).name[0] != '\0') {
		i++;
	}
	if(i == 10){
		printf("Error: No more space in the CSV file.");
	return;
	}
	printf("Name: ");
	scanf("%s", (phonebook[i]).name);
	printf("Birth: ");
	scanf("%s", (phonebook[i]).name);
	printf("Phone: ");
	scanf("%s", (phonebook[i]).phone);
	}



int findRecord() {
    char name[100];
    printf("Find name: ");
    scanf("%s", name);
    for (int i = 0; i < num_records; i++) {
        if (strcmp(name, (phonebook[i]).name) == 0) {
            printf("----NAME--------- ------BIRTH------ -----PHONE-------\n");
            printf("%-15s %-15s %s\n", (phonebook[i]).name, (phonebook[i]).birthdate, (phonebook[i]).phone);
            return;
        }
    }
    printf("Does not exist\n");
}

int listRecords() {

	printf("----NAME--------- ------BIRTH------ -----PHONE-------");
	int i = 0;
	while ((phonebook[i]).name[0] != '\0'){
	printf("%-15s %-15s %s\n", (phonebook[i]).name, (phonebook[i]).birthdate, (phonebook[i]).phone);

	i++;
	}
}




