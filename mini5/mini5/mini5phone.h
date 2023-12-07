struct PHONE_NODE {
	char name[50];
	char birthdate[12];
	char phone[15];
	struct PHONE_NODE *next;
};

extern struct PHONE_NODE *HEAD;

int addRecord();

int loadCSV();

int saveCSV(char *filename);

int findRecord(char name[]);

int delete(char name[]);

int clear();

int listRecords();

void printHeading();

void printContent(char *name, char *bith, char *phone);
