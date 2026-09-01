library(AR)


simulation = AR.Sim(n = 5,
                    f_X = function(y){dunif(y, min = 0, max = 1)},
                    Y.dist = "unif",
                    Y.dist.par = c(0, 1),
                    Rej.Num = TRUE,
                    Rej.Rate = TRUE,
                    Acc.Rate = TRUE
                    )
simulation
