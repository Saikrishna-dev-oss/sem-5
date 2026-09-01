#DFS
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

while stack:

    current = stack.pop()      # Take the top node

    if current not in visited:

        visited.append(current)

        for neighbour in reversed(graph[current]):
            if neighbour not in visited:
                stack.append(neighbour)

print(*visited)



# s = []
# visited = []

# def dfs(graph, start):
    
#     visited.append(start)

#     s.append(start)
    
#     for ele in graph[start]:

#         if ele not in visited:
#             s.append(ele)
#             for val in graph[ele]:
#                 if val not in visited:
#                     s.append(val)
#     print(s)


# def bfs(graph, start):
    
#     visited.append(start)

#     s.append(start)

#     for ele in graph[start]:

#         if ele not in visited:
#             s.append(ele)

#             for val in graph[ele]:
#                 if val not in visited:
#                     s.append(val)
#     print(s)


# graph = {
#     'A' : ['B', 'C'],
#     'B' : ['D', 'E'],
#     'C' : ['F', 'G'],
#     'D' : [],
#     'E' : [],
#     'F' : [],
#     'G' : [],
    
# }

# start = input("Enter the Start Node: ")
# dfs(graph, start)

