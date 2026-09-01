car_age = c(5,7,8,7,2,2,9,4,11,12,9,6)
car_age

carSpeed = c(99,86,87,88,111,103,87,94,78,77,85,86)
carSpeed

plot(car_age, carSpeed, main = "Observation of Cars", xlab = "Car Age", ylab = "Cr Speed")
abline(lm(carSpeed ~ car_age), col = "red")


