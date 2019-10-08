## Boyer Moore Search Algorithm

The algorithm needs to preprocess only the pattern, and not the whole text.
The algorithm will run faster as the length of the pattern increases.

Faster than brute force search because it allows skipping multiple chatacters
at once.

First create ShiftTable.
ShiftTable will contain only unique chars

value in Shifttable = MAX(1, lengthOfPatter - actualIndex - 1)

when creating the table, start processing the search patter from left to right.
if there are multiple occurences of a character in the pattern, the value stored
in the table corresponds to the rightmost occurance of that character in the 
pattern.

For the characters which are not present in the table, the number of shifts
to be made is equal to lengthOfPattern.
