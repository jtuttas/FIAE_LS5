import requests
import json

r = requests.get('http://192.168.178.87:8080/get?pressure')
r.json()
content = str(r.content, 'utf-8')
#print (content)
data = json.loads(content)
print ("Pressure="+str(data["buffer"]["pressure"]["buffer"][0])+" mBar")