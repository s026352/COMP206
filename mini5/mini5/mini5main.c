//Creater: Bohan Wang, Yanlin Zhu, Yiqi Liu
//Date	 : 2023/04/12



#include<stdio.h>
#include<string.h>
#include "mini5phone.h" // includes the mini4phone library for phonebook functionality

// A helper method to display the menu of the phonebook

int menu() {
    int selection;
    char garbage[5];

    printf("Phonebook Menu: (1)Add, (2)Delete/Clear (3)Find, (4)List, (5)Quit > ");
    scanf("%d", &selection);
    fgets(garbage,4,stdin);

    return selection;
}

// A helper method to giving output when the user pick DElete or Clear

int DorC() {    
    char cho[20];
    scanf("%s",cho);

    if (strcmp(cho,"C") == 0){
    		return 1;
    }

    if (strcmp(cho,"D") == 0){
		return 2;
    }

	return 0;
  
}

// A helper method to giving output when the user confirm the Clear commmand

int YorN() {
	char cho[20];
	scanf("%s",cho);

	if (strcmp(cho,"Y") == 0){
		return 1;
	}

	return 0;
}

// The main function that will opertating the whole process of the phonebook program

int main() {
        int choice, record;
        char name[50], birth[50], phone[50];
        int dorc;
       	char nm2[50];
	loadCSV("phonebook.csv");// Load the phonebook data from the CSV file

	// Loop to prompt the user for a menu selection until they select 'Quit'
	do {
		choice = menu(); // Prompt the user for a menu selection

		switch(choice) {
			case 1:
				printf("Name: ");  fgets(name,49,stdin);  name[strlen(name)-1]   = '\0';
				printf("Birth: "); fgets(birth,12,stdin); birth[strlen(birth)-1] = '\0';
				printf("Phone: "); fgets(phone,14,stdin); phone[strlen(phone)-1] = '\0';

				record = addRecord(name, birth, phone);// Add a new phonebook record

				if (record != 0) printf("CSV if out of space\n");// Error message if the phonebook is full

				break;
          		case 2:
				printf("(D)elete or (C)lear > ");
                		dorc = DorC();// Prompt the user for a 'Delete' or 'Clear' selection

				// If the user selected 'Clear'
				if(dorc == 2) {
                    			printf("Delete name: ");
					scanf("%*c%[^\n]",nm2);// Read in the name to delete
                   			record = delete(nm2);// Delete the record from the phonebook

                    			if (record == -1) printf("Sorry not found\n");// Error message if the record doesn't exist

                    			if (record == 1) printf("Empty!\n");// Error message if the phonebook is empty

                		}

				// If the user selected 'Clear'
                		else if (dorc == 1){
        				printf("Are you sure (Y/N) > ");

					if(YorN()){// Prompt the user for a 'Yes' or 'No' selection
                        			clear();// Delete all records from the phoneboo
					}

                        	} else {printf("Invalid selection \n");}

				break;

			case 3:
			// Find record by name
				struct PHONE_NODE *temp = HEAD;
				printf("Find name: "); fgets(name,49,stdin); name[strlen(name)-1] = '\0';
				record = findRecord(name);

				if(record == -1){
					printf("Does not exist\n");

				} else {
					for (int i=0; i<record; i++){
						temp = temp->next;
					}
					// Print the found record
					printHeading();
					printContent(temp->name, temp->birthdate, temp->phone);
				}

				break;

			case 4:
			    // List all records in the phonebook
				record = listRecords();

				if (record != 0) printf("Phonebook.csv does not exist\n");

				break;

 			case 5:
				break;

			default:
				printf("Sorry wrong selection!\n");
		}
	} while(choice != 5);

	saveCSV("phonebook.csv");

	printf("End of phonebook program\n");

	return 0;
	
}
