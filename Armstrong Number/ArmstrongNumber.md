##Armstrong Number
A positive integer of n digits is called an Armstrong number of order n (order is number of digits) if 
``abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ....``  
When checking whether the number is Armstrong number or not, it should be kept in mind that the number of terms that will be added are the number of digits in the that number.  
To check it's validity now, every digit's a<sup>b</sup> is calculated, where a is the digit from the number and power is the order of Armstrong number and summed up.
If this value is same as the number itself, then it is an Armstrong Number.
