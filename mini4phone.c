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

int loadCSV(char *filename){
    char line[50+12+15+2];
    char *na;
    char *bd;
    char *pn;
    struct PHONE_NODE *t = HEAD;

    FILE *csv = fopen(filename,"r");
    if(csv == NULL){
        isEmptyCSV = 1;
        return 1;
    }

    isEmptyCSV = 0;
    t = (struct PHONE_NODE *) malloc(sizeof(struct PHONE_NODE));
    fgets(line,sizeof(line),csv);

    while(fgets(line, sizeof(line),csv)) {
        na = strtok(line, ",");
        bd = strtok(NULL, ",");
        pn = strtok(NULL, ",");
        *(pn + strlen(pn) - 1) = '\0';
        addRecord(na,bd,pn);
    }
    fclose(csv);
    return 0;
}


int saveCSV(char *filename) {
	FILE *p = fopen(filename,"wt");
	struct PHONE_NODE *temp = HEAD;

	if (p == NULL) return 1; // error code

	if (temp == NULL) return 2; // error code

	fprintf(p,"name,birthdate,phone\n");

	while(temp!=NULL){
		fprintf(p,"%s,%s,%s\n", temp->name, temp->birthdate, temp->phone);
		temp = temp->next;
	}

	fclose(p);

	return 0;
}
//fixed
int addRecord(char name[], char birth[], char phone[]) {
	struct PHONE_NODE *temp = HEAD;
	struct PHONE_NODE *new = (struct PHONE_NODE *)malloc(sizeof(struct PHONE_NODE)); 

	strcpy(new->name, name);
	strcpy(new->birthdate, birth);
	strcpy(new->phone, phone);
	isEmptyCSV = 0;

        if(temp==NULL){
		HEAD = new;
	        new->next = NULL;
		return 0;
	}	

	while(1){
		if(temp->next==NULL){
			temp->next = new;
			new->next = NULL;
			return 0;
		}
		temp = temp->next;
	}
}

int findRecord(char name[]) {
	int i = 0;
	struct PHONE_NODE* temp = HEAD;
	if(HEAD==NULL){
		return -1;
	}

	while(1){
		if (strcmp(temp->name, name) == 0){
		        return i;
		}else{
			temp = temp->next;
		}
		i++;
	}

	return -1;
}
int delete(char name[]) {
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



int clear() {
    struct PHONE_NODE* temp = HEAD;
    while (temp != NULL) {
        struct PHONE_NODE* current = temp;
        temp = temp->next;
        free(current);
    }
    HEAD = NULL;

    return 0;
}


void printHeading() {
	 printf("---- NAME ---- ---- BIRTH DATE ---- ---- PHONE ----\n");
}

void printContent(char *name, char *bith, char *phone) {
	printf("%-14s %-20s %-10s\n", name, bith, phone);
}

int listRecords() {
	struct PHONE_NODE* temp = HEAD;

	if (isEmptyCSV) return 1;

	printHeading();

	while(temp != NULL){
		printContent(temp->name, temp->birthdate, temp->phone);
		temp = temp->next;
	}
        //clear() implemneted	
	return 0;	
}

