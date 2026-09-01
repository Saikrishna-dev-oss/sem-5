# DFS BFS Implementation
def dfs(graph, visited, stack):
    
    while stack:

        current = stack.pop()      # Take the top node

        if current not in visited:

            visited.append(current)

            for neighbour in reversed(graph[current]):
                if neighbour not in visited:
                    stack.append(neighbour)

    print("DFS: ", *visited)

def bfs(graph, visited, queue):
    while queue:
        current = queue.pop(0)      # Take the top node
        if current not in visited:
            visited.append(current)

            for neighbour in graph[current]:
                if neighbour not in visited:
                    queue.append(neighbour)

    print("BFS: ", *visited)


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

stack = [start]      # Nodes yet to be explored
visited = []         # Nodes already visited
dfs(graph, visited, stack)

queue = [start]      # Nodes yet to be explored
visited = []         # Nodes already visited
bfs(graph, visited, queue)
