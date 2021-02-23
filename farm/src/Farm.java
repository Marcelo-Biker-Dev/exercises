public class Farm {
    boolean farmAvailability = true;
    boolean isSheep;
    boolean isWolf;
    boolean noWolf = true;

    public boolean sell() {
        isSheep = false;
        isWolf = false;
        int random = (int) (Math.random() * 10);
        if ((random >= 9) && noWolf) {
            noWolf = false;
            return isWolf = true;
        } else {
            return isSheep = true;
        }
    }

    public boolean closeDoor() {
        System.out.println("Farm is definitely closed!");
        return farmAvailability = false;
    }
}
