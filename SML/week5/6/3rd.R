data("marketing", package = "datarium") 
head(marketing) 
tail(marketing)
View(marketing)

model = lm(sales ~ youtube + facebook + newspaper, data = marketing)
summary(model)

plot(model)

plot(model, 2)

Residuals = resid(model)
shapiro.test(Residuals)

