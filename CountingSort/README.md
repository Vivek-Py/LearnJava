# Counting Sort
This is a special sorting algorithm that only works efficiently in certain conditions. Counting sort can arrange elements when the elements exist between a certain range, and is efficient if the range is comparable to the number of elements.
 
For example, lets say we have 10^5 integers that can only range from 0 to 500, using QuickSort we can sort the same in O(nlog(n)) time complexity, but counting sort can perform the same in O(n + r) time complexity where 
n = no of elements in the array
r = range in which elements belong
 
## How does counting sort work?
Counting Sort works on the idea of frequency arrays (refer to [this link](https://github.com/insidetheradar/LearnJava/blob/master/FrequencyArray/README.md) for learning how and why frequency arrays are better).
As the range of values are fairly limited, instead of comparing and relocating the elements, we can just count how many occurances of a given number is present in the array, and place them all one after another.
 
Take this example,
[ 1, 0, 1, 1, 1, 0, 0, 0, 1 ]
 
The elements range from 0 to 1.
So we can have a frequency array which holds frequency of each of the elements.
|  0|1  | 
|--|--|
|  4| 5 |
Here, 0 has frequency 4 and 1 has frequency 5.
So, now we can iterate over an empty array and fill 4 '0's first and then fill next 5 cells with '1'.
 
This is the basis of counting sort.
 
## Key features and limitations
* It is a non comparing sort (meaning it doesn't compare elements with each other)
* Best case, average case and worse case complexity is O(n + r)
* This is a stable sort (refer here to learn more about [stable sorts](https://en.wikipedia.org/wiki/Category:Stable_sorts))
* This is only efficient for comparing integer arrays with a given range, where range should be comparable to length of array.
 
## Where can Counting Sort be useful?
* Binary array sorting
* sorting grades or marks (they tend to be within 0-10 and 0-100 respectively)
* any number distribution where the range of keys (elements) can be anticipated, and does not span a very wide range
 
## Can I use sort any other type of array with Counting Sort?
 
Yes, If you have a string array, you can generate the frequency table with HashMap instead of array, and the rest of the thing happens similarly. The complexity remains the same. (Only hashing complexity is added)