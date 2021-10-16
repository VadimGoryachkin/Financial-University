# Задание №1

{
  print(67**3-112**2)
  print(log10(125))
  print(log(81, 3))
}

# Задание №2

{
  flights_d <- c(140, 150, 100, 90, 230, 240, 165)
  flights_a <- c(65, 145, 80, 87, 220, 268, 216)
  print(flights_d[2]) # 2.1
  print(flights_d[1]-flights_a[1]) # 2.2
  print(sum(flights_d)) # 2.3
  print(which(flights_a<=220)) # 2.4
}

# Задание №3

{
  pos <- c(4.765, 3.230, 1.256, 1.780, 2.583, 2.781, 3.945, 2.345)
  print(length(pos)) # 3.1
  print(paste("Самая тяжелая посылка -", max(pos))) # 3.1
  print(paste("Самая легкая посылка -", min(pos)))
  pos.round <- floor(pos) # 3.2
  print(pos.round)
  pos_g <- pos*1000 # 3.3
  print(pos_g)
}

# Задание №4

{
  milk <- c(89.5, 50.5, 31.5, 21.0, 22.1, 27.4)
  middle <- sum(milk)/length(milk) # 4.1
  print(middle)
  disp <- sum((milk-middle)**2)/(length(milk)-1)
  print(paste("Выборочная дисперсия равна:", disp)) # 4.2
}

# Задание №5

{
  print(euro["FIM"]*100)
  print(euro["BEF"]*50)
  max.eur <- 0
  for (i in 1:length(euro)){
    if (euro[i]>max.eur){
      max.eur <- euro[i]
    }
  }
  print(max.eur)
}

# Задание №6

{
  country <- rep(c("France", "Italy", "Spain"), each=5)
  country # 6.1
  year <- rep(c(2000,2001,2002,2003,2004), times=3)
  year # 6.2
}

