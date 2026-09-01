
cityA = rnorm(32, 0, 15)
cityB = rnorm(36, 0, 12)

z.test(cityA, cityB, mu = 0, sigma.x = 15, sigma.y = 12, alternative = "two.sided")
