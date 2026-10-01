x = matrix(rnorm(100), 50, 2) 
y = rep(c(-1, 1), c(25, 25)) 
x[y == 1,] = x[y == 1,] + 1 
data = data.frame(x, y = as.factor(y)) 
svm = svm(y ~ ., data = data, kernel = "linear",cost=10) 
summary(svm)
plot(svm, data)
  