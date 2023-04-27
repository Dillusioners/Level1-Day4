import json
import requests
import random


def generate(url):
    response = requests.get(url)
    
    if response.status_code == 200:
        data = json.loads(response.text)
        return data['data']
        
    else:
        return 0
        
def main():
    url = 'https://would-you-rather-api.abaanshanid.repl.co/'
    data = generate(url)
    while True:
        print('Would you rather: ')
        print(data[17:].title())
        choice = input('\nChoose 1 for first option, 2 for second, 0 to exit: ')
        if choice[0] == 0:
            break
        
        elif choice[0] == '1' or choice[0] == '2':
            robo = str(random.randint(1, 3))
            
            if(robo == choice):
                print('I agree with you.\n')
            
            else:
                print('Phak u\n')
            
        else:
            print('Donot be oversmart here!')
    
if __name__ == '__main__':
    main()
