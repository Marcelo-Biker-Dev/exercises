public class Main {
    public static int sheepsQuantity = 100;

    public static void main(String[] args) {
        SheepsNursery sheep = new SheepsNursery();

        sheep.createNewSheep(sheepsQuantity);
        sheep.printSheeps(sheepsQuantity);
        sheep.changeColor(sheepsQuantity);

    }
}
