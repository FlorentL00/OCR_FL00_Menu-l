package com.florentL00.florent;

import java.util.Scanner;

public class Order {

    Scanner sc = new Scanner(System.in);

    /**
     * Display all available menus in the restaurant.
     */
    public void displayAvailableMenu() {
        System.out.println("Choix menu");
        System.out.println("1 - poulet");
        System.out.println("2 - boeuf");
        System.out.println("3 - végétarien");
        System.out.println("Que souhaitez-vous comme menu?");
    }

    /**
     * Display a selected menu.
     *
     * @param nbMenu The selected menu.
     */
    public void displaySelectedMenu(int nbMenu) {
        switch (nbMenu) {
            case 1:
                System.out.println("Vous avez choisi comme menu : poulet");
                break;
            case 2:
                System.out.println("Vous avez choisi comme menu : boeuf");
                break;
            case 3:
                System.out.println("Vous avez choisi comme menu : végétarien");
                break;
            default:
                System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
                break;
        }
    }

    /**
     * Run asking process for a menu.
     */
    public void runMenu() {
        this.displayAvailableMenu();
        int nbMenu;
        do {
            nbMenu = sc.nextInt();
            this.displaySelectedMenu(nbMenu);
            switch (nbMenu) {
                case 1:
                    displayAvailableSide(true);
                    int nbSide;
                    do {
                        nbSide = sc.nextInt();
                        displaySelectedSide(nbSide, true);
                    } while (nbSide < 1 || nbSide > 3);
                    displayAvailableDrink();
                    int nbDrink;
                    do {
                        nbDrink =sc.nextInt();
                        displaySelectedDrink(nbDrink);
                    } while (nbDrink <1 || nbDrink > 3);
                    break;
                case 2:
                    displayAvailableSide(true);
                    do {
                        nbSide = sc.nextInt();
                        displaySelectedSide(nbSide, true);
                    } while (nbSide < 1 || nbSide > 3);
                    break;
                case 3:
                    displayAvailableSide(false);
                    do {
                        nbSide = sc.nextInt();
                        displaySelectedSide(nbSide, false);
                    } while (nbSide < 1 || nbSide > 2);
                    displayAvailableDrink();
                    do {
                        nbDrink =sc.nextInt();
                        displaySelectedDrink(nbDrink);
                    } while (nbDrink <1 || nbDrink > 3);
                    break;
            }
        } while (nbMenu < 1 || nbMenu >3);
    }

    /**
     * Run asking process for several menus
     */
    public void runMenus(){
        System.out.println("Combien souhaitez vous commander de menu ?");
        int menuQuantity = sc.nextInt();
        for (int i = 0; i < menuQuantity; i++){
            this.runMenu();
        }
    }

    /**
     * Display a selected side depending on all sides enable or not.
     * All sides = vegetables, fries and rice.
     * Not all sides = rice or not.
     * @param nbSide         the selected side.
     * @param allSidesEnable enable display for all sides or not.
     */
    public void displaySelectedSide(int nbSide, boolean allSidesEnable) {
        if (allSidesEnable) {
            switch (nbSide) {
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement : légumes frais");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement : frites");
                    break;
                case 3:
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                    break;
            }
        } else {
            switch (nbSide) {
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement : pas de riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                    break;
            }
        }
    }

    /**
     * Display a selected drink.
     * @param nbDrink The selected drink
     */
    public void displaySelectedDrink(int nbDrink) {
        switch (nbDrink){
            case 1:
                System.out.println("Vous avez choisi comme boisson : eau plate");
                break;
            case 2:
                System.out.println("Vous avez choisi comme boisson : eau gazeuse");
                break;
            case 3:
                System.out.println("Vous avez choisi comme boisson : soda");
                break;
            default:
                System.out.println("Vous n'avez pas choisi de boisson parmi les choix proposés");
                break;
        }
    }

    /**
     * Display all available sides depending on all sides enable or not.
     * All sides = vegetables, frites and rice
     * No all sides = rice or not
     * @param allSidesEnable enable display for all side or not
     */
    public void displayAvailableSide(boolean allSidesEnable){
        System.out.println("Choix accompagnement");
        if (allSidesEnable) {
            System.out.println("1 - légumes frais");
            System.out.println("2 - frites");
            System.out.println("3 - riz");
        } else {
            System.out.println("1 - riz");
            System.out.println("2 - pas de riz");
        }
        System.out.println("Que souhaitez-vous comme accompagnement ?");
    }

    /**
     * Display all available drinks in the restaurant
     */
    public void displayAvailableDrink(){
        System.out.println("Choix boisson");
        System.out.println("1 - eau plate");
        System.out.println("2 - eau gazeuse");
        System.out.println("3 - soda");
        System.out.println("Que souhaitez-vous comme boisson ?");
    }

    /**
     * Display a question about category in the standard input, get response and display it.
     * @param category The category of the question.
     * @param responses Available response.
     */
    public void askSomething(String category, String[] responses){
        System.out.println("Choix " + category);
        for (int i = 1; i <= responses.length; i++) {
            System.out.println(i + " - " + responses[i - 1]);
        }
        System.out.println("Que souhaitez-vous comme " + category + " ?");
        int nbResponse;
        boolean responseIsGood;
        do {
            nbResponse = sc.nextInt();
            if (nbResponse >= 1 && nbResponse <= responses.length){
                responseIsGood = true;
            } else {
                responseIsGood = false;
            }
            if (responseIsGood == true) {
                System.out.println("Vous avez choisi comme " + category + " : " + responses[nbResponse -1]);
            } else {
                boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));
                if (isVowel == true) {
                    System.out.println("Vous n'avez pas choisi d' " + category + " parmi les choix proposés");
                }  else {
                    System.out.println("Vous n'avez pas choisi de " + category + " parmi les choix proposés");
                }
            }
        } while (responseIsGood == false);
    }
}