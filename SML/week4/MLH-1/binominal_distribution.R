x = c(9,2,5,3,1,5,2,4,2,1,3,5,6,1,1)
phat = mean(x) / length(x)
phat

meanhat = length(x) * phat
meanhat

varhat = length(x) * phat * (1 - phat)
varhat
