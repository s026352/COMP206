// Bohan Wang 261023725 Electrical Engineering bohan.wang@mail.mcgill.ca
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {
	if (argc != 3) return 1;

	char *w1 = argv[1];   // assign new pointers
	char *w2 = argv[2];
	if (strlen(w1) != strlen(w2)) { // check if the same length
		printf("Not an anagram\n");
		return 1;}
	for (int i = 0; i < strlen(w1); i++) { // pick the char in the first word, count in both words and compare.
		int num1 = 0;
		int num2 = 0;
		for (int j = 0; j < strlen(w1); j++){
			if (w1[i] == w1[j]) num1 += 1;//count
		}
			
		for (int k = 0; k < strlen(w1); k++){
			if (w1[i] == w2[k]) num2 += 1; //count
			}
		if (num1 != num2) {// compare
			printf("Not an anagram\n");
			return 1;
		}
	}

	printf("Anagram\n"); //passing condition
	return 0;

}


	
	
