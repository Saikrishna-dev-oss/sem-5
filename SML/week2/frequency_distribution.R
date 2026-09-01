x = c(79, 70, 85, 64, 41, 69, 66, 28, 89, 47, 88, 72, 21, 81, 75, 72, 55, 35, 56, 80, 68, 52, 49, 35, 20, 30, 23, 48, 90, 24, 58, 65, 29, 50, 67, 37, 42, 36, 86, 63, 78, 84, 60, 22, 57, 61, 32, 27, 73, 31)
x
range(x)

breaks = seq(20, 100, by = 10)
breaks
C_I = cut(x, breaks, right = FALSE)
C_I

freq = table(C_I)
freq
C_I

cbind(freq)

rel_freq = table(C_I)/length(C_I)
rel_freq
cbind(rel_freq)


cum_freq = cumsum(freq)
cum_freq

cbind(cum_freq)


cbind(freq, rel_freq, cum_freq)
