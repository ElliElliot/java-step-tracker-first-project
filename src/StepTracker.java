public class StepTracker {
    MonthData[] monthToData;
    int target = 10000;
    int saveStep;
    int sumDays;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int j = 0; j < monthToData.length; j++) {
            monthToData[j] = new MonthData();
        }
    }
    int stepOfDay (int month, int inputDate, int inputSteps){//сохранение количества пройденных шагов за день
        saveStep = inputSteps;
        monthToData[month].days[inputDate-1] = saveStep;
        return saveStep;
    }
        void statistics(int month) {//вывод статистики
            Converter converter = new Converter();
            int currentCounter = 0;
            int maxCounter = 0;
            int sum = 0;
            int maximumSteps = 0;
            double averageSteps = 0;
            for (int i = 0; i < 30; i++) {
                sumDays =  monthToData[month].days[i];
                sum = sumDays+sum; // Считаем сумму шагов в месяце
                if (maximumSteps < sumDays){// поиск максимального значения шагов
                    maximumSteps = sumDays;
                }
                if (sumDays >= target){ // Ищем лучшую серию
                    currentCounter = currentCounter + 1;
                    if(currentCounter == i+1){ // если выполняется план на 30 дней
                        maxCounter=currentCounter;
                    } //
                }
                if(sumDays < target) {
                    if (currentCounter > maxCounter) {
                        maxCounter = currentCounter;
                    }
                    currentCounter = 0;
                }
                System.out.print((i+1) + " день: " + sumDays + ", "); // Вывод дней и шагов
            }
            System.out.println("\nВсего шагов за месяц: " + sum);
            System.out.println("Наибольшее количество шагов: " + maximumSteps);
            averageSteps = sum / 30; // среднее количество шагов
            System.out.println("Среднее количество шагов: " + Math.round(averageSteps));
            System.out.println("Пройденная дистанция в километрах: " + converter.distanseOfMonth(sum));
            System.out.println("Всего сожжено килокалорий: " + converter.caloriesOfMonth(sum));
            System.out.println("Лучшая серия: " + maxCounter);

    }

    int saveTargetSteps(int targetSteps) {//запись новой цели
        target = targetSteps;
        return target;
    }

    class MonthData {
        int []days = new int[30]; // Инициализация массива дней
    }
}