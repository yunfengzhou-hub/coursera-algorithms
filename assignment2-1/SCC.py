# expected answer: 434821, 968, 459, 313, 211

t = 0
s = ""

explored = {}
adjList = {}

def DFS(i):
    explored[i] = True
    if i in adjList:
        for j in adjList[i]:
            if j not in explored:
                DFS(j)

f = open("SCC.txt")
for line in f.readlines():
    v1,v2 = line.split()
    if v1 in adjList:
        adjList[v1].append(v2)
    else:
        adjList[v1]=[v2]

# print(adjList["1"])


for i in range(875714,0,-1):
    if str(i) not in explored:
        s = str(i)
        DFS(str(i))

print(len(explored))