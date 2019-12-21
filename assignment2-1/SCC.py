f = open("SCC.txt")
adjList = {}
for line in f.readlines():
    v1,v2 = line.split()
    if v1 in adjList:
        adjList[v1].append(v2)
    else:
        adjList[v1]=[v2]

print(adjList["1"])