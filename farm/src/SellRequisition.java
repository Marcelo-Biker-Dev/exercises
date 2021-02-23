public class SellRequisition {
    int[] sellRequisitions;
    Animal[] animals;
    Farm farm;

    public void tryToBuy() {
        farm = new Farm();
        if (farm.farmAvailability) {
            sellRequisitions = new int[Main.sellRequisitions];
            animals = new Animal[sellRequisitions.length];
            for (int i = 0; i < sellRequisitions.length; i++) {
                farm.sell();
                if (farm.isWolf == true) {
                    animals[i] = new Wolf();
                } else if (farm.isSheep == true) {
                    animals[i] = new Sheep();
                }
            }
                countAnimals();
        } else {
            System.out.println("Farm is closed!!");
        }
    }

    private void countAnimals() {
        for (int i = 0; i < sellRequisitions.length; i++) {
            System.out.println("Animal #" + i + " makes " + animals[i].makeSound());
        }
            sentWolfBack();
    }

    private void sentWolfBack() {
        for (int i = 0; i < sellRequisitions.length; i++) {
            if (animals[i].makeSound().equals("Auuuuu!")) {
                System.out.println("Animal #" + i + " was a wolf, so it was returned to the farm.");
                farm.closeDoor();
            }
        }
    }
}
