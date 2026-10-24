# WEEK-11
## A-STAR Search

graph = {
    'A': {'B': 1, 'C': 4},
    'B': {'C': 2, 'D': 5},
    'C': {'D': 1},
    'D': {}
}
h = {'A': 5, 'B': 3, 'C': 1, 'D': 0}

open_list = ['A']
cost = {'A': 0}
parent = {}

while open_list:
    best = open_list[0]
    for node in open_list:
        if cost[node] + h[node] < cost[best] + h[best]:
            best = node
            
    open_list.remove(best)

    if best == 'D':
        break

    for neighbor in graph[best]:
        new_cost = cost[best] + graph[best][neighbor]
        if neighbor not in cost or new_cost < cost[neighbor]:
            cost[neighbor] = new_cost
            parent[neighbor] = best
            if neighbor not in open_list:
                open_list.append(neighbor)

path = ['D']
while path[-1] != 'A':
    path.append(parent[path[-1]])
path.reverse()

print("Path:", path)
print("Cost:", cost['D'])