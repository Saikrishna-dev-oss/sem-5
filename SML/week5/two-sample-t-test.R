HorseA = c(28, 30, 32, 33, 33, 29 , 34)
HorseB = c(29, 30, 30, 24, 27, 29)

t.test(HorseA, HorseB, mu = 0, alternative = "two.sided")
