phonebook: mini5main.o mini5phone.o
	gcc -o phonebook mini5main.o mini5phone.o

mini5main.o: mini5main.c mini5phone.h 
	gcc -c mini5main.c

mini5phone.o: mini5phone.c mini5phone.h
	gcc -c mini5phone.c

.PHONY: backup
backup:
	@mkdir -p backup
	@cp *.c *.h backup/

.PHONY: clean
clean:
	rm -f *.o
	rm -f phonebook
