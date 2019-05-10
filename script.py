import requests
import random
import time
import queue

API = "http://ec2-18-217-63-232.us-east-2.compute.amazonaws.com:8080/api/v1/entry"

locations = ["San Jose", "Paradise", "San Juan", "Alameda", "Alpine", "Contra Costa", "Del Norte", "Fresno", "Los Angeles", "Napa", "Nevada", 
			"Sacramento", "San Francisco", "San Mateo", "Santa Clara", "Santa Cruz", "San Benito", "Santa Barbara", "San Bernardino", "San Diego", "Inyo",
			"Kings", "Modoc", "Mono"]
areas = ["medical", "fire", "shelter", "food"]
contents = {
	"medical": [
				"Help me!", 
				"Send medical help immediately", 
				"Need assistance for the injured", 
				"Urgent medical assisstance needed", 
				"Need a team of doctors asap"
			],
 	"fire": [
 				"Stuck in fire", 
 				"Building on fire", 
 				"Fire outbreak", 
 				"Fire department help needed urgently", 
 				"Fire emergency in the area"
			], 
 	"shelter": [
 				"Shelter needed for survivors", 
 				"Shelter needed for evacuators", 
 				"Shelter urgently needed for rescued people"
			],
    "food": [
    			"Food needed for rescued group", 
    			"Supply of food needed urgently", 
    			"Urgent need of food supplies in the area"
			]
}
sources = ["twitter", "facebook", "helpline"]
counter = {}

cases_sent = queue.Queue(maxsize=10)

while True:

	if cases_sent.full():
		case = cases_sent.get()
		data = {
			'location': case.split('|')[1],
			'area': case.split('|')[0],
	        'source': case.split('|')[2],
	        'isrescued': 'true'
		}
		data['content'] = 'Rescued from ' + case.split('|')[0]
		print(str(data))
		r = requests.post(url = API, json = data)
		print(str(r.status_code) + "\n")

	data = {
		'location': locations[random.randint(0, len(locations) - 1)],
		'area': areas[random.randint(0, 3)],
        'source': sources[random.randint(0, 2)],
        'isrescued': 'false'
	}
	data['content'] = contents[data['area']][random.randint(0, len(contents[data['area']]) - 1)]
	key = data['area'] + "|" + data['location'] + "|" + data['source']
	
	cases_sent.put(key)

	r = requests.post(url = API, json = data)
	print(str(r.status_code) + "\n")
	print (str(data))

	time.sleep(5)
