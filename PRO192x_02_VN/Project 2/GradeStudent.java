import java.text.DecimalFormat;
import java.util.Scanner;
public class GradeStudent {
    public static Scanner input = new Scanner(System.in);
    public static int numRangeInput, // so nhap vao trong gioi han
            weightMid, weightFin, weightHw; // trong so diem giua ky, cuoi ky va btvn
    public static double overPercen; // tong diem giua ky + cuoi ky + btvn co trong so
    public static DecimalFormat formatter = new DecimalFormat("#0.0");
    public static void main(String[] args) {
        begin();
        double weightScoMid = midTerm();
        double weightScoFin = finalTerm();
        double weightScoHw = homeWork();
        overPercen = weightScoMid + weightScoFin + weightScoHw;
        report();
    }
    public static void begin() {
        System.out.println("This program read exam/ homework scores and reports your overall course grade.");
        System.out.println();
    }
    // ham tra ve mot gia tri trong gioi han
    public static int numRange(int min, int max, String message) {
        boolean numRangeAgain = true;
        do {
            if (input.hasNextInt()) {
                numRangeInput = input.nextInt();
                if (numRangeInput >= min && numRangeInput <= max) {
                    numRangeAgain = false;
                } else {
                    System.out.println("(---It's outside the range " + min + " to " + max + " , retype---)");
                    System.out.print(message);
                }
            } else {
                input.next();
                System.out.println("(---Not a Number or Integer, retype---)");
                System.out.print(message);
            }
        } while (numRangeAgain);
        return numRangeInput;
    }
    // ham tra ve diem giua ky co trong so
    public static double midTerm() {
        System.out.println("Midterm:");
        System.out.print("Weight (0-100)? ");
        weightMid = numRange(0, 100, "Weight (0-100)? ");
        System.out.print("Score earned? ");
        int scoreEarn = numRange(0, Integer.MAX_VALUE, "Score earned? ");
        System.out.print("Were scores shifted (1=yes, 2= no)? ");
        int scoreShift = numRange(1, 2, "Were scores shifted (1=yes, 2= no)? "); // diem co duoc tang hay khong
        int shiftAmount; // so diem duoc tang
        if (scoreShift == 1) {
            System.out.print("Shift Amount? ");
            shiftAmount = numRange(0, Integer.MAX_VALUE, "Shift Amount? ");
        } else {
            shiftAmount = 0;
        }
        int totalPoint = scoreEarn + shiftAmount; // tong diem giua ky gom diem dat duoc va diem tang them
        if (totalPoint > 100) {
            //neu tong diem giua ky > 100
            System.out.println("(---Total point midterm is " + totalPoint + ". It has been greater than 100---)");
            totalPoint = 100;
        }
        double weightScoMid = (double) totalPoint / 100 * weightMid;
        System.out.println("Total points = " + totalPoint + " / 100");
        System.out.println("Weighted score = " + formatter.format(weightScoMid) + " / " + weightMid);
        System.out.println();
        return weightScoMid;
    }
    // ham tra ve diem cuoi ky co trong so
    public static double finalTerm() {
        System.out.println("Final:");
        System.out.print("Weight (0-100)? ");
        weightFin = numRange(0, 100-weightMid, "Weight (0-100)? ");
        System.out.print("Score earned? ");
        int scoreEarn = numRange(0, Integer.MAX_VALUE, "Score earned ");
        System.out.print("Were scores shifted (1=yes, 2= no)? ");
        int scoreShift = numRange(1, 2, "Were scores shifted (1=yes, 2= no)? "); // diem co duoc tang them hay khong
        int shiftAmount; // so diem duoc tang
        if (scoreShift == 1) {
            System.out.print("Shift Amount? ");
            shiftAmount = numRange(0, Integer.MAX_VALUE, "Shift Amount? ");
        } else {
            shiftAmount = 0;
        }
        int totalPoint = scoreEarn + shiftAmount; // tong diem cuoi ky gom diem dat duoc va diem tang them
        if (totalPoint > 100) {
            //neu tong diem giua ky > 100
            System.out.println("(---Total point midterm is " + totalPoint + ". It has been greater than 100---)");
            totalPoint = 100;
        }
        double weightScoFin = (double) totalPoint / 100 * weightFin; // diem cuoi ky co trong so
        System.out.println("Total points = " + totalPoint + " / 100");
        System.out.println("Weighted score = " + formatter.format(weightScoFin) + " / " + weightFin);
        System.out.println();
        return weightScoFin;
    }
    // ham tra ve diem btvn co trong so
    public static double homeWork() {
        System.out.println("Homework:");
        System.out.print("Weight (0-100)? ");
        weightHw = numRange(0, 100, "Weight (0-100)? ");
        boolean weighHwAgain = true;
        do {
            if ((weightMid + weightFin + weightHw) == 100) {
                weighHwAgain = false;
            } else {
                // neu tong 3 trong so khac 100
                System.out.println("(---total weight = " + (weightMid + weightFin + weightHw) + ". Not equal 100 ---)");
                System.out.print("Weight (0-100)? ");
                weightHw = numRange(0, 100, "Weight (0-100)? ");
            }
        } while (weighHwAgain);
        System.out.print("Number of assignments? ");
        int numAssign = numRange(0, Integer.MAX_VALUE, "Number of assignments? "); // so bai tap ve nha
        int score = 0, max = 0; // tong so diem btvn va tong so diem btvn max
        for (int i = 1; i <= numAssign; i++) {
            System.out.println("Assignment " + i + " score and max:");
            System.out.print("Score: ");
            int score_i = numRange(0, Integer.MAX_VALUE, "Score: "); // so diem cua moi btvn
            score += score_i;
            if (score > 150) {
                // neu tong diem cua cac btvn > 150
                score = 150;
                System.out.println("(---Score Assignment homework has been greater than 150---)");
            }
            System.out.print("Max: ");
            int max_i = numRange(0, Integer.MAX_VALUE, "Max: "); // so diem cua moi btvn max
            boolean guessMax = true;
            do {
                if (max_i < score_i) {
                    System.out.println("(---Max Assignment homework is less than Score Assignment homework, retype---)");
                    System.out.println("Assignment " + i + " score and max:");
                    System.out.println("Score: " + score_i);
                    System.out.print("Max: ");
                    max_i = numRange(0, Integer.MAX_VALUE, "Max: ");
                } else {
                    max += max_i;
                    if (max > 150) {
                        // neu tong diem cua cac btvn max > 150
                        max = 150;
                        System.out.println("(---Max Assignment homework has been greater than 150---)");
                    }
                    guessMax = false;
                }
            } while (guessMax);
        }
        System.out.print("How many sections did you attend? ");
        int section = numRange(0, Integer.MAX_VALUE, "How many sections did you attend? "); // so ngay duoc diem danh
        int sectionTotal = section * 5; // diem chuyen can
        if (sectionTotal > 30) {
            // neu diem chuyen can > 30
            sectionTotal = 30;
            System.out.println("(---Total section point has been greater than 30---)");
        }
        int totalPoint = score + sectionTotal; // tong so diem btvn gom diem btvn va diem chuyen can
        int totalPointMax = max + 30; // tong so diem btvn max co the dat duoc
        double weightScoHw = (double) totalPoint / totalPointMax * weightHw; // diem btvn co trong so
        System.out.println("Section points = " + sectionTotal + " / 30");
        System.out.println("Total points = " + totalPoint + " / " + totalPointMax);
        System.out.println("Weighted score = " + formatter.format(weightScoHw) + " / " + weightHw);
        System.out.println();
        return weightScoHw;
    }
    public static void report() {
        System.out.println("Overall percentage = " + formatter.format(overPercen));
        if (overPercen >= 85) {
            System.out.println("Your grade will be at least: 3.0");
        } else if (overPercen < 85 && overPercen >= 75) {
            System.out.println("Your grade will be: 2.0");
        } else if (overPercen < 75 && overPercen >= 60) {
            System.out.println("Your grade will be: 0.7");
        } else {
            System.out.println("Your grade will be: 0");
        }
    }
}
