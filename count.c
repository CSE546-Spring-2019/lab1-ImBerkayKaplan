#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#define BUFFERSIZE 100

// Opens a file and does the necessary error checking. Returns the file pointer or prints an error statement if file could not be opened.
FILE* openfile(char *name, char *permission){
    FILE *file = fopen(name, permission);
    if(file == NULL){
        perror("Could not open file.\n");
        exit(-1);
    }
    return file;
}

// Count the number of strings in the chunk as well as the total size of the file. Returns a sized-two array that the first element is the total size of the file while the second element is how many times the searchString appears in the file
int* countstring(FILE *input, unsigned char *searchString){

    // Initialize the counters of for loop, the result array to be returned, and initialize both elements of the result to 0
    size_t size = 0;
    int i = 0, j = 0, *result, keepgoing = 0;
    result[0] = 0;
    result[1] = 0;

    // Read input file by 100 bytes each time
    unsigned char buffer[BUFFERSIZE];

    // Keep reading the input file until all is read
    while ((size = fread(buffer, 1, sizeof(buffer), input)) > 0){

        // Record the totalSize of the input file
        result[0] = size + result[0];
      
        // Go through the chunk of 100 bytes char array
        for(i = 0; i<strlen(buffer); i++){

	// If the first element of the searchString matches with the current buffer element or the keepgoing is non-zero, go into the if statement
            if((buffer[i] == (searchString[0]&0xff)) || (keepgoing && i == 0)){
		
	        // Go through the searchString
                for(j = 0; j < strlen(searchString) && (j+i) < strlen(buffer); j++){

	            // If the characters of the text and the searchString matches, increment keepgoing or break
	            if(buffer[i+j] == (searchString[keepgoing]&0xff)){
		        keepgoing++;
		        if(keepgoing == strlen(searchString)){
		            result[1]++;
		            keepgoing = 0;
		            break;
		        }
	            }else{
		        keepgoing = 0;
		        break;
	            }
                }
            }
        }

    // Clear the buffer to get another chunk correctly
    memset(buffer, 0, strlen(buffer));
    }
    return result;
}

int main(int argc, char *argv[]){

    // Check if the correct number of arguments has been entered
    if(argc != 4){
        perror("Please enter 3 arguments.\n");
        exit(-1);
    }

    // Check if the size of the searchString is greater than 20 bytes
    if(strlen(argv[2])>20){
        perror("Size of input string is greater than 20 bytes.\n");
        exit(-1);
    }

    // The searchString that will be counted
    unsigned char *searchString = (char *)malloc(20);
    searchString = (unsigned char*) argv[2];

    // Open the files with proper permission and check if it is successfully opened
    FILE *input = openfile(argv[1],"rb"), *output = openfile(argv[3], "w");

    // Returns an array sized 2. First element is the size of the file, and second is how many times the string occurs in the text
    int *result = countstring(input, searchString);

    // Write the size of the file to the output file and the screen
    char temp[BUFFERSIZE] = "count ";
    sprintf(temp, "Size of the file is %d\n", result[0]);
    fwrite(temp, 1, sizeof(temp), output);
    printf("%s", temp);

    // Write the number of matches to the output file and the screen
    memset(temp, 0, sizeof(temp));
    sprintf(temp, "Number of matches = %d\n", result[1]);
    fwrite(temp, 1, sizeof(temp), output);
    printf("%s", temp);

    // Close the files
    fclose(input);
    fclose(output);

    return 0;
}
