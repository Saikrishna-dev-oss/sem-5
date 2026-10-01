# 8. Classification with SVM in R
install.packages("e1071")
library("e1071")

x = matrix(rnorm(60), 30, 2)
y = rep(c(-1, 1), c(15, 15))
x[y == 1,] = x[y == 1,] + 1 
data = data.frame(x, y = as.factor(y)) 
svm = svm(y ~ ., data = data, kernel = "linear",cost=10) 
summary(svm) 

plot(svm, data)
