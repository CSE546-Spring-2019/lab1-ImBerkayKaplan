# makefile for count.c

CC = gcc

all: count

count: count.c
	$(CC) count.c -o count

clean:
	rm count
