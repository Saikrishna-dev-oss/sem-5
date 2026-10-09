install.packages("factoextra")


library(factoextra)
fviz_nbclust(week9_2_1, kmeans, method = "wss", k.max = 8)

clust = kmeans(week9_2_1, 2)
clust

fviz_cluster(clust, week9_2_1)

