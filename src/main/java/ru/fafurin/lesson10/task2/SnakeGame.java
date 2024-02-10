package ru.fafurin.lesson10.task2;

import java.util.Scanner;

public class SnakeGame {

    private final SnakeGameField gameField;
    private final Scanner scanner = new Scanner(System.in);
    private char snakeSymbol;

    private int fruitsCount;
    private int wallsCount;
    private char fruitSymbol;

    private char wallsSymbol;
    private int snakeLength;
    boolean isGameOver = false;
    private int[][] snake;
    private int[][] fruits;

    private int[][] walls;

    private boolean isSnakeEatenFruit = false;

    public SnakeGame() {
        System.out.println("Welcome to closed beta testing of Snake Game v. 0.1");
        this.gameField = new SnakeGameField();
        this.setGameSettings();
    }

    // устанавливаем начальную длину змейки
    // инициализируем массив для координат змейки
    // определяем символ для обозначения змейки
    // устанавливаем начальные координаты змейки
    private void setGameSettings() {
        this.snakeLength = 3;
        this.fruitsCount = 10;
        this.wallsCount = 5;
        this.snake = new int[this.snakeLength][2];
        this.fruits = new int[fruitsCount][2];
        this.walls = new int[wallsCount][2];
        this.snakeSymbol = (char) 149;
        this.fruitSymbol = (char) 211;
        this.wallsSymbol = (char) 182;
        this.generateCoordinates(this.fruits);
        this.generateCoordinates(this.walls);
        this.generateStartSnakePosition();
    }

    // метод меняет координаты в массиве змейки в соответствии с переданными значениями
    private void changeSnakeCoordinates(int rowIncrement, int colIncrement) {
        // проверяем не съела ли змейка фрукт
        this.removeEatenFruitFromArr(this.checkEatenFruitPosition());
        this.checkWallsPosition();
        int[][] tmpArr;
        // если змейка фрукт не съела, то моделируем движение без увеличения массива координат
        if (!isSnakeEatenFruit) {
            tmpArr = new int[this.snake.length - 1][2];

            for (int x = 0; x < tmpArr.length; x++) {
                tmpArr[x][0] = this.snake[x][0];
                tmpArr[x][1] = this.snake[x][1];
            }
            for (int x = 0; x < tmpArr.length; x++) {
                this.snake[x + 1][0] = tmpArr[x][0];
                this.snake[x + 1][1] = tmpArr[x][1];
            }

            // если змейка фрукт съела,
            // создаем новый массив на +1 элементов и копируем значения из старого,
            // при этом 0-элемент меняем в соответствии с переданными значениями
        } else {
            tmpArr = new int[this.snake.length][2];

            for (int x = 0; x < tmpArr.length; x++) {
                tmpArr[x][0] = this.snake[x][0];
                tmpArr[x][1] = this.snake[x][1];
            }

            this.snake = new int[this.snake.length + 1][2];

            for (int x = 0; x < tmpArr.length; x++) {
                this.snake[x + 1][0] = tmpArr[x][0];
                this.snake[x + 1][1] = tmpArr[x][1];
            }

            this.snake[0][0] = this.snake[1][0];
            this.snake[0][1] = this.snake[1][1];

            this.isSnakeEatenFruit = false;

        }
        this.snake[0][0] += rowIncrement;
        this.snake[0][1] += colIncrement;
        this.printSnake();
    }

    // выводим положение змейки на поле
    private void printSnake() {
        this.gameField.setField();
        for (int x = 0; x < this.snake.length; x++) {
            this.gameField.setValue(this.snake[x][0], this.snake[x][1], this.snakeSymbol);
        }
//        this.printFruits();
        this.printArr(this.fruits, this.fruitSymbol);
        this.printArr(this.walls, this.wallsSymbol);
        this.gameField.printField();
    }

    // метод для генерации начального положения змейки
    private void generateStartSnakePosition() {
        int rowIndex = this.gameField.getSize() / 2;
        int colIndex = this.gameField.getSize() / 2;
        for (int x = 0; x < snakeLength; x++) {
            this.snake[x][0] = rowIndex;
            this.snake[x][1] = colIndex++;
        }
    }

    // метод для генерации массивов координат фруктов и стен
    private void generateCoordinates(int[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            int row = this.getRandomIntBetweenRange(1, this.gameField.getSize() - 1, this.snake[0][0]);
            int col = this.getRandomIntBetweenRange(1, this.gameField.getSize() - 1, this.snake[0][0]);
            arr[x][0] = row;
            arr[x][1] = col;
        }
    }

    // метод для вывода положения фруктов и стен на поле
    private void printArr(int[][] arr, char symbol) {
        for (int x = 0; x < arr.length; x++) {
            this.gameField.setValue(arr[x][0], arr[x][1], symbol);
        }
    }

    // случайные координаты для генерации положения фруктов и стен на поле
    private int getRandomIntBetweenRange(int min, int max, int ignore) {
        int result = 1;
        boolean isContinue = true;
        while (isContinue) {
            result = (int) (Math.random() * ((max - min) + 1)) + min;
            if (result != ignore) isContinue = false;
        }
        return result;
    }

    // получаем индекс элемента массива фруктов, который проглотила змейка
    private int checkEatenFruitPosition() {
        int eatenFruitIndex = 404;
        for (int x = 0; x < this.fruits.length; x++) {
            if (this.snake[0][0] == this.fruits[x][0] &&
                    this.snake[0][1] == this.fruits[x][1]) {
                eatenFruitIndex = x;
                this.isSnakeEatenFruit = true;
            }
        }
        return eatenFruitIndex;
    }

    // проверяем не пересекла ли змейка стену
    private void checkWallsPosition() {
        for (int x = 0; x < this.walls.length; x++) {
            if (this.snake[0][0] == this.walls[x][0] &&
                this.snake[0][1] == this.walls[x][1]) {
                System.out.println("Wall!!!");
                System.out.println("The Game is Over!");
                System.exit(1);
            }
        }
    }

    // удаляем из массива фруктов съеденный змейкой и если фруктов не остается заканчиваем игру
    private void removeEatenFruitFromArr(int eatenFruitIndex) {
        if (this.fruits.length > 1 && eatenFruitIndex != 404) {
            this.fruits[eatenFruitIndex][0] = this.fruits[this.fruits.length - 1][0];
            this.fruits[eatenFruitIndex][1] = this.fruits[this.fruits.length - 1][1];
            int[][] tmpArr = new int[this.fruits.length - 1][2];
            for (int x = 0; x < this.fruits.length - 1; x++) {
                tmpArr[x][0] = this.fruits[x][0];
                tmpArr[x][1] = this.fruits[x][1];
            }
            this.fruits = tmpArr;
        } else if (eatenFruitIndex == 0) {
            System.out.println("You ate all the fruits and won!");
            System.exit(1);
        }
    }

    public void startGame() {
        this.printSnake();
        while (!isGameOver) {
            int key = this.playerMove();
            if (key != 0) {
                this.simulateSnakeMovement(key);
            } else isGameOver = true;
        }
    }

    private int playerMove() {
        System.out.println(this.fruitSymbol + " - eatable fruits, if eaten, the snake will increase");
        System.out.println(this.wallsSymbol + " - uneatable walls, if crossed, the game is over!\n");
        System.out.println("Where should the snake go?");
        System.out.println("Enter:");
        System.out.println("4 - to left");
        System.out.println("8 - to up");
        System.out.println("6 - to right");
        System.out.println("2 - to down");
        System.out.println("0 - exit");
        int key = scanner.nextInt();
        if (key != 2 && key != 4 && key != 6 && key != 8 && key != 0) {
            System.out.println("Wrong number!");
            key = scanner.nextInt();
        }
        this.clearScreen();
        return key;
    }

    // по полученным значениям от пользователя симулируем движение змейки
    private void simulateSnakeMovement(int key) {
        switch (key) {
            case 2 -> changeSnakeCoordinates(1, 0);
            case 4 -> changeSnakeCoordinates(0, -1);
            case 6 -> changeSnakeCoordinates(0, 1);
            case 8 -> changeSnakeCoordinates(-1, 0);
        }
    }

    private void clearScreen() {
        for (int x = 0; x < 50; x++) {
            System.out.println(" ");
        }
    }

}


