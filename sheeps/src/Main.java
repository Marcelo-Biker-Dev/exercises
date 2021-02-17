public class Main {
    public static void main(String[] args) {

        Sheep[] sheeps = new Sheep[100];

        for (int i = 0; i < sheeps.length - 1; i++) {
            sheeps[i] = new Sheep("white", "meeeeeh");
        }
        sheeps[99] = new Sheep("black", "muuuuuuuh");


        for (int i = 0; i < sheeps.length; i++) {
            System.out.println("Sheep #" + i + " = " + sheeps[i].getColor() + " makes " + sheeps[i].getSound());
        }

        for (Sheep sheep : sheeps) {
            sheep.setColor("pink");
            sheep.setSound("miau");
        }

        for (int i = 0; i < sheeps.length; i++) {
            System.out.println("Sheep #" + i + " = " + sheeps[i].getColor() + " makes " + sheeps[i].getSound());

        }
    }

}
