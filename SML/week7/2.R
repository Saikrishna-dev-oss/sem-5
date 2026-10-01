install.packages("packagename") 
mydata = read.csv("https://stats.idre.ucla.edu/stat/data/binary.csv") 

View(mydata)

summary(mydata)

str(mydata)

mydata$rank = factor(mydata$rank)
mydata$admit = factor(mydata$admit)

mylogit = glm(admit ~ gre + gpa + rank, data = mydata, family = "binomial")
summary(mylogit)
