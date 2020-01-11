#!/usr/bin/python

# Strings can be converted to numbers and vice versa with a functional
# notation.
a = "459"
b = "1891"
c1 = a + b
c2 = int(a) + int(b)
print(a,b,c1,c2)
print()

# The input method reads a line as a string.  Then you can process the
# string.
in1 = input("Please enter a string: ")
print("A string:", in1)
in2 = input("Please enter an integer: ")
in3 = input("Please enter another integer: ")
print("The sum is:", int(in2)+int(in3))
print("The concatination is:", in2+in3)