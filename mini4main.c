#include<stdio.h>
#include<string.h>
#include "mini4phone.c"


int menu() {
	int selection;
	char garbage[5];

	printf("Phonebook Menu: (1)Add, (2)Delete/Clear (3)Find, (4)List, (5)Quit > ");
	scanf("%d", &selection);
	fgets(garbage,4,stdin);

	return selection;
}
int DorC() {
	char cho[20];
    	scanf("%s", cho);
	if (strcmp(cho,"C") == 0){
    		return 1;
    	}
	if (strcmp(cho,"D") == 0){
		return 2;
	}
	return 0;
	}
int YorN() {
	char cho[20];
	scanf("%s",cho);
	if (strcmp(cho,"Y") == 0){
		return 1;
	}
	return 0;
	}

int main() {
	int choice, record;
	char name[50], birth[50], phone[50];

        int dorc;
       	char nm2[50];
	loadCSV("phonebook.csv");
	do {
		choice = menu();

		switch(choice) {
			case 1:
				printf("Name: ");  fgets(name,49,stdin);  name[strlen(name)-1]   = '\0';
				printf("Birth: "); fgets(birth,12,stdin); birth[strlen(birth)-1] = '\0';
				printf("Phone: "); fgets(phone,14,stdin); phone[strlen(phone)-1] = '\0';

				record = addRecord(name, birth, phone);
				if (record != 0) printf("CSV if out of space\n");

				break;
          		case 2:
				printf("(D)elete or (C)lear > ");
                		dorc = DorC();
				if(dorc == 2) {
                    			printf("Delete name: ");// fgets(nm2,49,stdin);  nm2[strlen(nm2)-1]   = '\0';
					scanf("%*c%[^\n]",nm2);
                   			record = delete(nm2);
                    			if (record == -1) printf("Does not exist\n");
                    			if (record == 1) printf("Empty!\n");
                		}
                		else if (dorc == 1){
        				printf("Are you sure (Y/N) > ");
					if(YorN()){
                        			clear();
					}
                        	} else {printf("abc");}

				break;
			case 3:
				struct PHONE_NODE *temp = HEAD;
				printf("Find name: "); fgets(name,49,stdin); name[strlen(name)-1] = '\0';
				record = findRecord(name);

				if (record == -1) printf("Does not exist\n");
				else {
					for (int i=0; i<record; i++){
						temp = temp->next;
					}
					printHeading();
					printContent(temp->name, temp->birthdate, temp->phone);
				}

				break;
			case 4:
				record = listRecords();

				if (record != 0) printf("Phonebook.csv does not exist\n");
			
				break;

			case 5:
				break;

			default:
				printf("Invalid menu selection\n");
		}
	} while(choice != 5);

	saveCSV("phonebook.csv");

	printf("End of phonebook program\n");

	return 0;
}

