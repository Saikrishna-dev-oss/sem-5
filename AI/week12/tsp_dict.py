# Traveling Salesman Problem (TSP) using Depth-First Search (DFS) with pruning

def tsp_dfs(city, count, cost, path, graph, visited):
    global best_cost, best_path

    # Prune paths that already match or exceed the best found
    if cost >= best_cost:
        return

    # Base case: visited all cities, return to start city (1)
    if count == n:
        if 1 in graph[city]:
            total_cost = cost + graph[city][1]
            if total_cost < best_cost:
                best_cost = total_cost
                best_path = path + [1]
        return

    # Explore unvisited neighbors
    for neighbor, weight in graph[city].items():
        if neighbor not in visited:
            visited.add(neighbor)
            tsp_dfs(neighbor, count + 1, cost + weight, path + [neighbor], graph, visited)
            visited.remove(neighbor)
graph = {
    1: {2: 10, 3: 15, 4: 20},
    2: {1: 10, 3: 35, 4: 25},
    3: {1: 15, 2: 35, 4: 30},
    4: {1: 20, 2: 25, 3: 30},
}

n = len(graph)
visited = set([1])  # Start at city 1

best_cost = float('inf')
best_path = []


tsp_dfs(city=1, count=1, cost=0, path=[1], graph=graph, visited=visited)

print("Best Route:", best_path)
print("Minimum Distance:", best_cost)