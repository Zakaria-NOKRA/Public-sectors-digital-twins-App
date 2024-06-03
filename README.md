PFA project
Conception

![Uploading Capture d’écran 2024-05-31 à 15.47.22.png…]()

```python

import re
cin_code = re.compile("[A-Z]{1,2}[0-9]+")
date = re.compile("[0-9]{2}\.[0-9]{2}\.[0-9]{2}")
name = re.compile("[A-Z]{3,}|[A-Z]{2,}\s[A-Z]+")


names = []
dates = []
for i in res:
  for j in i:
    if(re.match(cin_code,j[1])):
      cin = j[1]
    if(re.match(name,j[1]) and j[1] not in names):
        names.append(j[1])
    if(re.match(date,j[1])):
      dates.append(j[1])
```
