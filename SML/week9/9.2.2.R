install.packages("factoextra") 
library(factoextra) 
fviz_nbclust(PCA_Data, kmeans, method = "wss", k.max = 11) 
clust=kmeans(PCA_Data,2) 
clust 
fviz_cluster(clust,PCA_Data)

