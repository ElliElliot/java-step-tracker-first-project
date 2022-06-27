class Converter {
    double step = 0.000075;
    double calories = 50;
    double distanseOfMonth (int sum){//пройденная дистанция
        double distanse = (step * sum);
        return distanse;
    }
    double caloriesOfMonth (int sum){//количество сожженных каллорий
        double kcal = (calories * sum) /1000;
        return kcal;
    }
}
