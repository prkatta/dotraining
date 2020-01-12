

def factorial( ):
	n = int(input("enter an int "))
	fact = 1
	for factor in range (n, 1, -1):
		fact = fact * factor
	print("the answer is: ", fact)

	
factorial( )
