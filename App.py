import requests
import json

r = requests.get('https://api.openweathermap.org/data/2.5/weather?q=Hanover,de&appid=4727c8383bacbff7ac85de94ec48c85c')
r.json()
content = str(r.content, 'utf-8')
print (content)
data = json.loads(content)
print ("Temperatur="+str(data["main"]["temp"]))