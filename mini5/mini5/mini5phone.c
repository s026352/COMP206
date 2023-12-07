// Creater: Bohan Wang, Yiqi Liu, Yanlin Zhu
// Date	  : 2023/04/12

#include<stdio.h>
#include<string.h>
#include <stdlib.h>

struct PHONE_NODE {
	char name[50];
	char birthdate[12];
	char phone[15];
	struct PHONE_NODE *next;
};

int addRecord(char *x, char *y, char *z);
int isEmptyCSV = 1; // assume empty
struct PHONE_NODE *HEAD;

// Function to load data from CSV file
int loadCSV(char *filename){
   	char line[50+12+15+2];// buffer for each line in the CSV file
  	char *na;// pointer to store name
 	char *bd;// pointer to store birth date
   	char *pn;// pointer to store phone number
   	struct PHONE_NODE *t = HEAD;// pointer to the current node

   	FILE *csv = fopen(filename,"r");

   	if(csv == NULL){
       		isEmptyCSV = 1;
       		return 1;// return error code if file cannot be }
        }

   	isEmptyCSV = 0; // mark CSV as not empty
   	t = (struct PHONE_NODE *) malloc(sizeof(struct PHONE_NODE));// allocate memory for the current node
   	fgets(line,sizeof(line),csv);// skip the first line (header) of the CSV file


   	while(fgets(line, sizeof(line),csv)) {// read each line of the CSV file
       		na = strtok(line, ",");// get the name from the line
        	bd = strtok(NULL, ",");// get the birth date from the line
        	pn = strtok(NULL, ",");// get the phone number from the line
        	*(pn + strlen(pn) - 1) = '\0';// remove the newline character at the end of the phone number
        	addRecord(na,bd,pn);// add the record to the linked list
   	}

   	fclose(csv);// close the CSV file
   	return 0;
}

// Function to save data to CSV file
int saveCSV(char *filename) {
	FILE *p = fopen(filename,"wt");// open file for writing
	struct PHONE_NODE *temp = HEAD;// pointer to the current node


	if (p == NULL) return 1;// return error code if file cannot be opened

	if (temp == NULL) return 2; // return error code if list is empty
	fprintf(p,"name,birthdate,phone\n");// write the header of the CSV file

	while(temp!=NULL){
		// write the record to the CSV file
		fprintf(p,"%s,%s,%s\n", temp->name, temp->birthdate, temp->phone);
		temp = temp->next;// move to the next node
	}

	fclose(p);// close the file

	return 0;
}
// Function to add a new record to the linked list
int addRecord(char name[], char birth[], char phone[]) {
	struct PHONE_NODE *temp = HEAD;
	struct PHONE_NODE *new = (struct PHONE_NODE *)malloc(sizeof(struct PHONE_NODE)); // define and allocate memory for the new node

	strcpy(new->name, name);// copy the name to the new node
	strcpy(new->birthdate, birth);// copy the birth date to the new node
	strcpy(new->phone, phone);// copy the phone number to the new node
	isEmptyCSV = 0;// mark CSV as not empty

        if(temp==NULL){
		HEAD = new;// if the list is empty, make the new node the head
	        new->next = NULL;
		return 0;
	}	

	while(1){// Traverse the list until the end and add new record

		if(temp->next==NULL){
			temp->next = new;
			new->next = NULL;
			return 0;
		}
		temp = temp->next;
	}
}
// Find the index of a record in linked list based on name
int findRecord(char name[]) {
	int i = 0;
	struct PHONE_NODE* temp = HEAD;

	if(HEAD==NULL){
		return -1;
	}

	while(temp!=NULL){// Traverse the list until record with matching name is found

		if (strcmp(temp->name, name) == 0){
		        return i;
		} else {
			temp = temp->next;// Move to next node
		}
		i++;
	}

	return -1;
}

int delete(char name[]) {// The delete() function removes a node from the linked list based on the given name.
// If the list is empty, it returns 1. If the name is not found in the list, it returns -1.
    struct PHONE_NODE* prev = NULL;
    struct PHONE_NODE* curr = HEAD;

    if (HEAD == NULL) {
        // list is empty
        return 1;
    }

    while (curr != NULL && strcmp(curr->name, name) != 0) {
        prev = curr;
        curr = curr->next;
    }

    if (curr == NULL) {
        // name not found
        return -1;
    }

    if (prev == NULL) {
        // the first node is being removed
        HEAD = curr->next;
    } else {
        // remove the current node
        prev->next = curr->next;
    }

    free(curr); // free memory

    return 0;
}



int clear() {// The clear() function removes all nodes from the linked list and frees the memory allocated for them.
    struct PHONE_NODE* temp = HEAD;//Updates the HEAD pointer to NULL.

    while (temp != NULL) {
        struct PHONE_NODE* current = temp;
        temp = temp->next;
        free(current);//Free every memory location
    }

    HEAD = NULL;

    return 0;
}


void printHeading() {// The printHeading() function prints the heading of the table for displaying records.
	 printf("---- NAME ---- ---- BIRTH DATE ---- ---- PHONE ----\n");
}

void printContent(char *name, char *bith, char *phone) {// The printContent() function prints the name, birth date, and phone number of a record in a formatted manner.
	printf("%-14s %-20s %-10s\n", name, bith, phone);
}

int listRecords() {// The listRecords() function displays all the records in the linked list by iterating through each node for each node.
        struct PHONE_NODE* temp = HEAD;

	if (isEmptyCSV) return 1; //If the list is empty, it returns 1. The function also calls clear() function implemented to free the memory.

	printHeading();

	while(temp != NULL){
		printContent(temp->name, temp->birthdate, temp->phone);
		temp = temp->next;
	}

        //clear() implemneted	
	return 0;	
}


