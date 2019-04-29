import requests
import random
import time
import sys

API = "http://localhost:8080/api/v1/entry"

locations = ["San Jose", "Paradise", "Los Angeles", "San Juan"]
areas = ["Medical", "Fire", "Shelter"]
contents = {
	"Medical": ["Help me!", "Send medical help immediately", "Need assistance for the injured", "Urgent medical assisstance needed", "Need a team of doctors asap"],
 	"Fire": ["Stuck in fire", "Building on fire", "Fire outbreak", "Fire department help needed urgently", "Fire emergency in the area"], 
 	"Shelter": ["Shelter needed for survivors", "Shelter needed for evacuators", "Shelter urgently needed for rescued people"],
    "Food": ["Food needed for rescued group", "Supply of food needed urgently", "Urgent need of food supplies in the area"]
}
sources = ["Twitter", "Facebook", "Helpline"]

count = 2

for i in range(count):
	data = {
		'location': locations[random.randint(0, 3)],
		'area': areas[random.randint(0, 2)],
        'source': sources[random.randint(0, 2)]
	}
	data['content'] = contents[data['area']][random.randint(0, len(contents[data['area']]) - 1)]

	print (str(data))

	r = requests.post(url = API, json = data)
	print(str(r.status_code) + "\n")
	time.sleep(1)
