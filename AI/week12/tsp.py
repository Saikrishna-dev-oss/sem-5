# Traveling Salesman Problem (TSP)

# graph = {
#     1: {2: 10, 3: 15, 4: 20},
#     2: {1: 10, 3: 35, 4: 25},
#     3: {1: 15, 2: 35, 4: 30},
#     4: {1: 20, 2: 25, 3: 30}
# }
graph = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0],
]

n = len(graph)
visited = [False] * n

visited[0] = True
best_cost = float('inf')
best_path = []




def tsp_dfs(city, count, cost, path):
    global best_cost, best_path

    if cost >= best_cost:
        return

    if count == n:
        total_cost = cost + graph[city][0]
        if total_cost < best_cost:
            best_cost = total_cost
            best_path = path + [0]
        return
    
    # Try every Unvisited City
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            tsp_dfs(i, count + 1, cost + graph[city][i], path + [i])
            visited[i] = False

tsp_dfs(0, 1, 0, [0])
print("Best Route: ", best_path)
print("Minimum Distance: ", best_cost)

    

