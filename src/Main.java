import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();

        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) { //ввод и сохранение количества шагов в день
                System.out.println("Введите номер месяца от 0 (Январь) до 11 (Декабрь)");
                int month = scanner.nextInt();
                while (month > 11 || month < 0) {
                    System.out.println("Введено некорректное значение");
                    System.out.println("Введите номер месяца от 0 (Январь) до 11 (Декабрь)");
                    month = scanner.nextInt();
                }
                System.out.println("Введите число месяца от 1 до 30");
                int inputDate = scanner.nextInt();
                while (inputDate > 30 || inputDate < 1) {
                    System.out.println("Введено некорректное значение");
                    System.out.println("Введите число месяца от 1 до 30");
                    inputDate = scanner.nextInt();
                }
                System.out.println("Введите количество пройденных шагов");
                int inputSteps = scanner.nextInt();
                while (inputSteps < 0) {
                    System.out.println("Введено некорректное значение шагов");
                    inputSteps = scanner.nextInt();
                }
                stepTracker.stepOfDay(month, inputDate, inputSteps);
                System.out.println("Данные сохранены");
            } else if (userInput == 2){ // статистика за месяц
                System.out.println("Введите номер месяца от 0 (Январь) до 11 (Декабрь)");
                int month = scanner.nextInt();
                while (month > 11 || month < 0) {
                    System.out.println("Введено некорректное значение");
                    System.out.println("Введите номер месяца от 0 (Январь) до 11 (Декабрь)");
                    month = scanner.nextInt();
                }
                stepTracker.statistics(month);

            } else if (userInput == 3) {//изменение цели по количеству шагов в день
                System.out.println("Введите желаемую цель по количеству шагов в день");
                int targetSteps = scanner.nextInt();
                while (targetSteps < 0) {
                    System.out.println("Введено некорректное значение шагов");
                    targetSteps = scanner.nextInt();
                }
                System.out.println("Новая цель: " + stepTracker.saveTargetSteps(targetSteps) + " шагов в день");
            }
            printMenu(); // ещё раз печать меню
            userInput = scanner.nextInt(); // ещё считываем ввод пользователя
            }
        System.out.println("Программа завершена");
    }
        public static void printMenu(){ //печать меню
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Внести количество пройденных шагов за день");
            System.out.println("2. Посмотреть статистику за месяц");
            System.out.println("3. Изменить цель по количеству шагов за день");
            System.out.println("0. Выйти из приложения");
        }
    }

