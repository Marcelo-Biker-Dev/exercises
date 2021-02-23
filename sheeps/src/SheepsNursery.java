public class SheepsNursery {

    private Sheep[] sheeps;

    public void createNewSheep(int sheepsQuantity) {
        sheeps = new Sheep[sheepsQuantity];
        boolean noBlackSheep = true;
        for (int i = 0; i < sheepsQuantity; i++) {
            int random = (int) (Math.random() * 10);
            if ((random >= 9) && noBlackSheep) {
                sheeps[i] = new BlackSheep();
                noBlackSheep = false;
                continue;
            }
            sheeps[i] = new WhiteSheep();
        }
    }

    public void printSheeps(int sheepsQuantity) {
        for (int i = 0; i < sheepsQuantity; i++) {
            System.out.println("Sheep #" + i + " = " + sheeps[i].getColor() + "; it makes " + sheeps[i].getSound());
        }
    }

    public void changeColor(int sheepsQuantity) {
        for (int i = 0; i < sheepsQuantity; i++) {
            sheeps[i].setColor("Pink");
            sheeps[i].setSound("Pink, it's the color of passion...");
            System.out.println("Sheep #" + i + " = " + sheeps[i].getColor() + "; it sings: " + sheeps[i].getSound());
        }
    }
}
