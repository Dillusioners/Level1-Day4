import random as ra
def display():
	print('#'*20)
	print('HELP THE FROG GO HOME!')
	print('#'*20)
	print('Can you help this frog go home??')
	print('The frog only jumps to the left,right and front and is also blind. Watch out for pits tho!It has only 5 lives')


def main():
	display()
	directionList = ['left','right','front']
	jumps = ra.randint(20,51)
	lives = 5
	i = 1
	bCheck = True
	while i <= jumps:
		print(jumps - i,"more steps to go!!")
		if jumps - i <= 10:
			print("Good going we're almost there!")
		try:
			direction = input('Which side do you think the frog should jump ? : ')
			direction = direction.lower()
			if direction not in directionList:
				print("The frog can only jump to the left,right and front!")
				continue
			else:
				DirectionOfPit = ra.choice(directionList)
				if direction != DirectionOfPit:
					print("Good! Our little friend is safe. The pit was to the",DirectionOfPit)
					i+=1
				else:
					print("Oh no! The frog fell in the pit it has",lives,"lives left. Stay safe!")
					lives -= 1
					i+=1
					if lives == 0:
						print("GAME OVER\nAlas! The frog is dead")
						bCheck = False
						break
		except Exception as e:
			print("OOPS Something went wrong :(")
			exit()

	if bCheck:
		print("The frog reached home!! Thank you sir!")

if __name__ == '__main__':
	main()
					


