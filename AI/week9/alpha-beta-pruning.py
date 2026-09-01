# Alpha Beta Pruning

def alphabeta(node, alpha, beta, maxplayer):

    if type(node) == int:
        return node

    if maxplayer:
        value = -float('inf')

        for child in node:
            value = max(value, alphabeta(child, alpha, beta, False))
            alpha = max(alpha, value)

            if alpha >= beta:
                break

        return value

    else:
        value = float('inf')

        for child in node:
            value = min(value, alphabeta(child, alpha, beta, True))
            beta = min(beta, value)

            if alpha >= beta:
                break

        return value


tree = [
    [[2, 3], [5, 9]],
    [[0, 1], [7, 5]]
]

alpha = -float('inf')
beta = float('inf')

print("Best value =", alphabeta(tree, alpha, beta, True))
