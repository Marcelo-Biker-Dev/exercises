package menu_interface;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class PromptViewTestDrive {

    public static void main(String[] args) {

        System.out.println("What's up bro... what's gonna be?");

        System.out.println("You can play against Player 2 (someone else from your ethernet) or may wanna try your luck against the best... myself");

        Prompt prompt = new Prompt(System.in, System.out);

        // options that you want to be presented are supplied in an array of strings
        String[] options = {"Player 2", "Server"};

        // create a menu with those options and set the message
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Escolha seu adversário");

        // show the menu to the user and get the selected answer
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Player 1 escolheu " + options[answerIndex - 1]);

        chooseOption();

        public void chooseOption() {

            String[] optiones = {"Pedra", "Papel", "Tesoura"};

            // create a menu with those options and set the message
            MenuInputScanner scannero = new MenuInputScanner(optiones);
            scannero.setMessage("Escolha sua opção");

            // show the menu to the user and get the selected answer
            //int answerIndex = prompt.getUserInput(scanner);

            System.out.println("Player 1 escolheu " + optiones[answerIndex - 1]);

            // Player 2 agora faz a escolha dele
            // O [answerIndex - 1] tem que comunicar com o "código do jogo" e passar as escolhas dos players
            // No código original do "Game: Pedra - Papel - Tesoura" as opçoes eram escolhidas pelos players através do "terminal=

            Prompt prompete = new Prompt(System.in, System.out);
        }

    }
}





        /*Prompt prompete = new Prompt(System.in, System.out);

        // accepts integers from 1 to 11
        IntegerInputScanner intBetween = new IntegerRangeInputScanner(1, 11);
        intBetween.setMessage("Say a number between 1 and 11");

        // will present an error message on validation fail (before re-asking the question)
        intBetween.setError("Sorry. This only goes up to 11.");

        System.out.println("Switching knob to position " +
                prompete.getUserInput(intBetween));*/
