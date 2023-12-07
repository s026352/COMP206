// Bohan Wang 261023725 Electrical Engineering bohan.wan@mail.mcgill.ca
#include<stdio.h>

int main() {
	int a,b,c,d; //declare the varables
	char num[100];
	printf("Please input three numbers: ");
	fgets(num,100,stdin);
	int input = sscanf(num,"%d %d %d %d", &a, &b, &c, &d);
	if(input != 3) return 206;
	if(a != 0 && b % a == 0 && c % a == 0) { // divisible condition
		if (a<b && b<c) {    //compare if its increasing
			printf("Divisible & Increasing\n");
			return 0;
		}else{
			printf("Divisible & Not increasing\n");
			return 2;
		}

	} else { // not divisible condition
		if (a<b && b<c) {
			printf("Not divisible & Increasing\n");
			return 1;
		}else{ //same as above
			printf("Not divisible & Not increasing\n");
			return 3;
		}
	}
}
