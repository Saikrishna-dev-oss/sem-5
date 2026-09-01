# Best First Search
def best_first_search(start, goal, graph, h):
    open = [start]

    visited = set()

    while open:

        minimum = open[0]
        for ele in open:
            if h[ele] < h[minimum]:
                minimum = ele

        open.remove(minimum)
        print(minimum, end = " ")

        if minimum == goal:
            print("\nGoal Reached !!\n")
            return

        visited.add(minimum)

        for child in graph[minimum]:
            if child not in visited and child not in open:
                open.append(child)        


graph = {
    'A' : ['S', 'B', 'C'],
    'S': [],
    'B': ['D', 'H'],
    'C': [],
    'D': [],
    'H': ['F','G'],
    'F': [],
    'G': ['E'],
    'E': [],
}
# graph = {
#     'S' : ['A', 'B', 'C'],
#     'A': [],
#     'B': ['D', 'H'],
#     'C': [],
#     'D': [],
#     'H': ['F','G'],
#     'F': [],
#     'G': ['E'],
#     'E': [],
# }

h = {
    'S': 10,
    'A': 9,
    'B': 7,
    'C': 8,
    'D': 8,
    'H': 6,
    'F': 6,
    'G': 3,
    'E': 0,
}

start = input("Enter the Starting Node: ").upper()
goal = input("Enter the Goal Node: ").upper()
best_first_search(start, goal, graph, h)