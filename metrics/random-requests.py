import random
import itertools
import requests
import time
import random

choices = ["Alberto", "Pier", "Viki"]

for i in itertools.count():

    sleep_duration = random.random()
    if sleep_duration < 0.8:
        choice = random.choice(choices)
        print(f'Greeting {choice} and getting adverts')
        requests.get(f'http://localhost:8080/greet?name={choice}')
        requests.get('http://localhost:8080/adverts')
    else:
        print('Triggering errors')
        requests.post('http://localhost:8080/error')
        requests.post('http://localhost:8080/error2')

    print(f'Sleeping for {sleep_duration}')
    time.sleep(sleep_duration)