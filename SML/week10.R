install.packages("e1071")
library("e1071")

# Example-1
x = matrix(rnorm(400), 200, 2) 
y = rep(c(-1, 1), c(100, 100)) 
x[y == 1,] = x[y == 1,] + 1 
data = data.frame(x, y = as.factor(y)) 
svm = svm(y ~ ., data = data, kernel = "radial",gamma=1, cost=1) 
summary(svm) 

plot(svm, data)

# Example-2
x = matrix(rnorm(300), 150, 2) 
y = rep(c(-1, 1), c(75, 75)) 
x[y == 1,] = x[y == 1,] + 1 
data = data.frame(x, y = as.factor(y)) 
svm = svm(y ~ ., data = data, kernel = "radial",gamma=1, cost=10) 
summary(svm) 
plot(svm, data)

