import java.util.Scanner;

public class Game {
    Player player1 = new Player();
    Player player2 = new Player();
    public Game() {
    }
    public void onStart () {
        System.out.println("Введите ваше имя: ");
        Scanner scanner = new Scanner(System.in);
        player1.setName(scanner.nextLine());
        System.out.print("Здравствуйте, " + player1.getName() + '!');
        System.out.println("А вашего оппонента? ");
        player2.setName(scanner.nextLine());
        Unit[] units;
        units = player1.getUnits();
        for (int i = 0; i < 3; i++) {
            System.out.println("1-й игрок, выберете 3-х юнитов в порядке, в котором они будут атаковать: \n" +
                    "K - Knight" + "\tW - Wizard" + "\tT - Terminator");
            first:
            switch (scanner.nextLine()) {
                case "K":
                    units[i] = new Unit();
                    break;
                case "T":
                    units[i] = new Terminator();
                    break;
                case "W":
                    units[i] = new Wizard();
                    break;
                default:
                    System.out.println("Введите корректное значение!");
                    i -= 1;
                    break first;
            }
        }
        player1.setUnits(units);
        units = player2.getUnits();
        for (int i = 0; i < 3; i++) {
            System.out.println("2-й игрок, выберете 3-х юнитов в порядке, в котором они будут атаковать: \n" +
                    "K - Knight" + "\tW - Wizard" + "\tT - Terminator");
            second:
            switch (scanner.nextLine()) {
                case "K":
                    units[i] = new Unit();
                    break;
                case "T":
                    units[i] = new Terminator();
                    break;
                case "W":
                    units[i] = new Wizard();
                    break;
                default:
                    System.out.println("Введите корректное значение!");
                    i -= 1;
                    break second;
            }
        }
        player2.setUnits(units);
        Scenary scenary = new Scenary();
        for (int i = 0; i < 1; i++) {
            System.out.println("Выберите модель управления: \n" +
                    "A - Auto" + "\tHA - HalfAuto" + "\tM - Manual");
            manual:
            switch (scanner.nextLine()) {
                case "A", "HA":
                    i -= 1;
                    System.out.println("Не реализовал. Выбери другой");
                    break manual;
                case "M":
                    scenary.setScenary(1);
                    break;
                default:
                    i -= 1;
                    System.out.println("Давай что-нибудь корректное. Попробуй ещё раз.");
                    break manual;
            }
        }
    }


    //     .:::.::.    .::::.       :^^^^:          ::::::::::.:::.
    //     :~Y&@&!.    .P#J^.    ~Y5?!~~!?55~      .^~P&J????G&#7^.
    //        ~B@G:   .JY:     :P@Y.      .Y@G^       !&.    P@B
    //          J@&7 7P!      :#@P          G@#:      7B     P@B
    //           ~#@#Y        Y@@7          7@@Y      Y5     P@B
    //           .5B@#!       Y@@7          7@@5      B!     P@B
    //          7P! !&@5.     ~@@5          Y@@~     ?B.     P@B
    //        ^PJ.   :5@#!     !&@?        !@#!     ~B^      P@B
    //     :~5@7      .G@@5^.   :JB5!^::^!YG?.   .^Y#7:^^^^^~#@&^.
    //    .^!!!^.    .:~~!!~:      ^~!!!!~:     .B@#J!~~~~~~~!?P&&^
    //                                          .#?             ~#~
    //                                          .!               ~^

    public void turn () {
        Unit [] units1 = player1.getUnits();
        Unit [] units2 = player2.getUnits();
        int attackUnit1 = 0;
        int attackUnit2 = 0;
        Scanner scanner = new Scanner(System.in);
        int a = 1;
        int b = 10;
        int Critical_Hit = a + (int) (Math.random() * b);
        int Parry_Chance = a + (int) (Math.random() * b);
        metka:
        while (true) {
            boolean flag = true;
            if (attackUnit1 == 3) {
                attackUnit1 = 0;
            }
            if (attackUnit2 == 3) {
                attackUnit2 = 0;
            }
            //int player1U = 0;
            //int player2U = 1;

            while (flag) {
                while (true) {
                    if (units1[attackUnit1].getHealth() <= 0) {
                        attackUnit1 += 1;
                    }
                    if (attackUnit1 == 3) {
                        attackUnit1 = 0;
                    }
                    else {
                        break;
                    }
                }
                Critical_Hit = a + (int) (Math.random() * b);
                Parry_Chance = a + (int) (Math.random() * b);
                System.out.println("Player 1, выбери противника, кторого хочешь атаковать");
                if (units2[0].getHealth() > 0) {
                    System.out.println("1)" + units2[0]);
                }
                if (units2[1].getHealth() > 0) {
                    System.out.println("2)" + units2[1]);
                }
                if (units2[2].getHealth() > 0) {
                    System.out.println("3)" + units2[2]);
                }
                switch (scanner.nextLine()) {
                    case "1":
                        if (units2[0].getHealth() <= 0) {
                            flag = true;
                            System.out.println("This unit is dead. Choice another");
                        }
                        else {
                            if (Critical_Hit <= 2 && Parry_Chance > 2) {
                                units1[attackUnit1].attack(units2[0]);
                                units1[attackUnit1].attack(units2[0]);
                                System.out.println("Critical Hit!");
                                flag = false;
                            }
                            else if (Critical_Hit > 2 && Parry_Chance <= 2) {
                                System.out.println("Parry!");
                                flag = false;
                            }
                            else {
                                units1[attackUnit1].attack(units2[0]);
                                flag = false;
                            }
                        }
                        break;
                    case "2":
                        if (units2[1].getHealth() <= 0) {
                            flag = true;
                            System.out.println("This unit is dead. Choice another");
                        }
                        else {
                            if (Critical_Hit <= 2 && Parry_Chance > 2) {
                                units1[attackUnit1].attack(units2[1]);
                                units1[attackUnit1].attack(units2[1]);
                                System.out.println("Critical Hit!");
                                flag = false;
                            }
                            else if (Critical_Hit > 2 && Parry_Chance <= 2) {
                                System.out.println("Parry!");
                                flag = false;
                            }
                            else {
                                units1[attackUnit1].attack(units2[0]);
                                flag = false;
                            }
                        }
                        break;
                    case "3":
                        if (units2[2].getHealth() <= 0) {
                            flag = true;
                            System.out.println("This unit is dead. Choice another");
                        }
                        else {
                            if (Critical_Hit <= 2 && Parry_Chance > 2) {
                                units1[attackUnit1].attack(units2[2]);
                                units1[attackUnit1].attack(units2[2]);
                                System.out.println("Critical Hit!");
                                flag = false;
                            }
                            else if (Critical_Hit > 2 && Parry_Chance <= 2) {
                                System.out.println("Parry!");
                                flag = false;
                            }
                            else {
                                units1[attackUnit1].attack(units2[0]);
                                flag = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Некорректные данные. Даже не пытайся");
                        flag = true;
                        break;
                }
            }
            if (units2[2].getHealth() <= 0 && units2[1].getHealth() <= 0 && units2[2].getHealth() <= 0) {
                System.out.println("Player 1 wins! Fatality");
                break metka;
            }
            attackUnit1 += 1;
            flag = true;
            while (flag) {
                while (true) {
                    if (units2[attackUnit2].getHealth() <= 0) {
                        attackUnit2 += 1;
                    }
                    if (attackUnit2 == 3) {
                        attackUnit2 = 0;
                    }
                    else {
                        break;
                    }
                }
                Critical_Hit = a + (int) (Math.random() * b);
                Parry_Chance = a + (int) (Math.random() * b);
                System.out.println("Player 2, выбери противника, кторого хочешь атаковать");
                if (units1[0].getHealth() > 0) {
                    System.out.println("1)" + units1[0]);
                }
                if (units1[1].getHealth() > 0) {
                    System.out.println("2)" + units1[1]);
                }
                if (units1[2].getHealth() > 0) {
                    System.out.println("3)" + units1[2]);
                }
                switch (scanner.nextLine()) {
                    case "1":
                        if (units1[0].getHealth() <= 0) {
                            flag = true;
                            System.out.println("This unit is dead. Choice another");
                        }
                        else {
                            if (Critical_Hit <= 2 && Parry_Chance > 2) {
                                units2[attackUnit2].attack(units1[0]);
                                units2[attackUnit2].attack(units1[0]);
                                System.out.println("Critical Hit!");
                                flag = false;
                            }
                            else if (Critical_Hit > 2 && Parry_Chance <= 2) {
                                System.out.println("Parry!");
                                flag = false;
                            }
                            else {
                                units2[attackUnit2].attack(units1[0]);
                                flag = false;
                            }
                        }
                        break;
                    case "2":
                        if (units1[1].getHealth() <= 0) {
                            flag = true;
                            System.out.println("This unit is dead. Choice another");
                        }
                        else {
                            if (Critical_Hit <= 2 && Parry_Chance > 2) {
                                units2[attackUnit2].attack(units1[1]);
                                units2[attackUnit2].attack(units1[1]);
                                System.out.println("Critical Hit!");
                                flag = false;
                            }
                            else if (Critical_Hit > 2 && Parry_Chance <= 2) {
                                System.out.println("Parry!");
                                flag = false;
                            }
                            else {
                                units2[attackUnit2].attack(units1[1]);
                                flag = false;
                            }
                        }
                        break;
                    case "3":
                        if (units1[2].getHealth() <= 0) {
                            flag = true;
                            System.out.println("This unit is dead. Choice another");
                        }
                        else {
                            if (Critical_Hit <= 2 && Parry_Chance > 2) {
                                units2[attackUnit2].attack(units1[2]);
                                units2[attackUnit2].attack(units1[2]);
                                System.out.println("Critical Hit!");
                                flag = false;
                            }
                            else if (Critical_Hit > 2 && Parry_Chance <= 2) {
                                System.out.println("Parry!");
                                flag = false;
                            }
                            else {
                                units2[attackUnit2].attack(units1[2]);
                                flag = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Некорректные данные. Сам дурак");
                        flag = true;
                        break;
                }
            }
            if (units1[2].getHealth() <= 0 && units1[1].getHealth() <= 0 && units1[2].getHealth() <= 0) {
                System.out.println("Player 2 wins! Fatality");
                break metka;
            }
            attackUnit2 += 1;
        }
    }
}

