PFA project
Conception
![WhatsApp Image 2024-05-29 à 12 57 11_0ce96f2a](https://github.com/Zakaria-NOKRA/PFA/assets/125411704/b8ee0c11-7271-409d-b3a8-b52a03584039)

``python

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
``
