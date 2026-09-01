library(AR)


simulation = AR.Sim(n = 10,
                    f_X = function(y){dunif(y, min = 0, max = 1)},
                    Y.dist = "norm",
                    Y.dist.par = c(10, 6),
                    Rej.Num = TRUE,
                    Rej.Rate = TRUE,
                    Acc.Rate = TRUE)
simulation
