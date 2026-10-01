# R vectors containing the data from the image columns
Age = c(35, 36, 34, 35, 36, 32, 35, 38, 39, 34, 32, 31, 35, 36, 32)
Elevation = c(1.5, 1.2, 2.1, 2.3, 2.5, 1.6, 1.5, 1.4, 2.3, 2.5, 2.6, 1.2, 1.3, 1.8, 1.9)
Rainfall = c(110, 115, 80, 89, 78, 54, 86, 110, 118, 119, 200, 240, 210, 110, 118)
Specific_Gravity = c(0.63, 0.59, 0.56, 0.55, 0.54, 0.59, 0.56, 0.46, 0.63, 0.60, 0.63, 0.58, 0.55, 0.57, 0.62)
Diameter = c(18.1, 19.6, 16.6, 16.4, 16.9, 17.0, 20.0, 16.6, 16.2, 18.5, 18.7, 19.4, 17.6, 18.3, 18.8)

MLR = lm(Diameter ~ Age + Elevation + Rainfall + Gravity)

summary(MLR)

# Outliers Identification
plot(MLR)


## Multi Collinearity

install.packages("caTools")
install.packages("car")
install.packages("quantmod")
install.packages("MASS")
install.packages("corrplot")

library(caTools)
library(car)
library(quantmod)
library(MASS)
library(corrplot)

vif(MLR)

## Compute the Residuals

Residuals = resid(MLR)
Predicted = predict(MLR)
Residuals
Predicted
plot(Residuals, Predicted)

## Test For Normality
plot(MLR, 2)

shapiro.test(Residuals)
