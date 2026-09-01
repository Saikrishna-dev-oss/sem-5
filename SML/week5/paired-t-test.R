beforeTraining = c(12, 14, 11, 8, 7, 10, 3, 0, 5, 6)
afterTraining = c(15, 16, 10, 7, 5, 12, 10, 2, 3, 8)

t.test(beforeTraining, afterTraining, paired = TRUE, alternative = "two.sided")
