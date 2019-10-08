## Checking Prime Number in Java
To check if a number is prime or not in java, there are a few things that need to be taken care of, with respect to number 'n'.  
First is that 'n', if prime should not be divisible by any number greater than or equal to 2.  
Second is that, 'n' can never be divisible by any number greater than the square root of n.  
Now, a loop can be ran with lower limit as '2' and upper limit as square root of n and it can be checked if any number from lower limit to upper limit can be a number which can divide the number 'n'.   
A boolean can be kept which can be toggled if any number satisfies the condition which can divide the number 'n'. Also, break the loop if this condition is satisfied.
Finally, the boolean field can be checked to know whether or not the number was prime.  

According to the following code snippet, if the method returns true then the number is prime, else not.
```java
public static boolean isPrime(double n) {
    boolean prime = true;
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n%i==0) {
        prime = false;
        break;
      }
    }
    return prime;
  }
```