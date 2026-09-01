#BFS
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F', 'G'],
    'D': [],
    'E': [],
    'F': [],
    'G': []
}

start = input("Enter starting node: ").capitalize()

queue = [start]      # Nodes yet to be explored
visited = []

while queue:

    current = queue.pop(0)      # Remove first element

    if current not in visited:

        visited.append(current)

        for neighbour in graph[current]:
            if neighbour not in visited:
                queue.append(neighbour)

print(*visited)