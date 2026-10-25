# !pip install pyDatalog
# Install if needed:
# pip install networkx matplotlib

import networkx as nx
import matplotlib.pyplot as plt

# --- Define family relationships (facts) ---
relations = [
    ("Robert", "William", "father"),
    ("Helen", "William", "mother"),
    ("Robert", "Susan", "father"),
    ("Helen", "Susan", "mother"),
    ("William", "James", "father"),
    ("Anna", "James", "mother"),
    ("Mark", "Laura", "father"),
    ("Susan", "Laura", "mother")
]

# --- Create a directed graph to represent relationships ---
G = nx.DiGraph()

# Add nodes and labeled edges
for parent, child, rel in relations:
    G.add_node(parent)
    G.add_node(child)
    G.add_edge(parent, child, relation=rel)

# --- Plot the Semantic Network ---
pos = nx.spring_layout(G, k=0.8, seed=42)  # layout for clear spacing
plt.figure(figsize=(8,6))
nx.draw(G, pos, with_labels=True, node_size=3000, node_color="#b3d9ff", font_size=10, font_weight='bold', arrowsize=20)
edge_labels = nx.get_edge_attributes(G, 'relation')
nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels, font_color='red', font_size=9)

plt.title("Semantic Network for Family Relationships (AI Demonstration)", fontsize=12, fontweight='bold')
plt.show()
