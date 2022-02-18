# Задание №1

{
  z <- seq(-10, 10, 0.2) 
  plot(z, z**2, type = "l")
  lines(z, z**3, col="orange")
  legend(0, 70, 
         c("x**2", "x**3"), 
         lwd = c(1, 1), 
         col = c("black", "orange"), 
         cex = 0.7)
}

# Задание №2

{
  mycars <- mtcars
  hist(mtcars$hp, main = "Horsepowers", col = "red", 
       xlab = "horsepowers", ylab = "amount")
  abline(v = mean(mycars$hp), col = "limegreen", 
         lty = 4, lwd = 7)
  abline(v = median(mycars$hp), col = "blue", 
         lty = 3, lwd = 7)
}

# Задание №3

{
  dat <- read.csv("C:/Users/Vadim/Desktop/financials.csv")
  tab <- table(dat$Sector)
  proc <- paste0(round((tab / sum(tab) * 100),2), "%")
  colors <- c("red", "green", "blue", "brown", 
                 "orange", "yellow",
                 "purple", "magenta", "black",
                 "white", "cyan")
  pie(tab, main = "S&P 500", col = colors, labels = proc)
  legend(x=-1.2, y = -0.8, names(tab), cex = 0.7, 
         fill = colors, ncol = 3, bty = "n")
}