#include <stdlib.h>
#include <stdio.h>


int main(int argc, char *argv[]) {
	if (argc != 3) return 1;

	char* str = argv[1];
	int num = atoi(argv[2]);
	
	char *ptr1 = str;
	while (*ptr1 != '\0') {
		ptr1++;
	}

	for(int i = 0; i < num; i++) {
		char *ptr2 = str;
		while (*ptr2 != '\0') {
			*ptr1 = *ptr2;
			ptr1++;
			ptr2++;
		}
	}

printf("%s\n",str);
return 0;

}
