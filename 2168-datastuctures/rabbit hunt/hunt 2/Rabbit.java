public class Rabbit extends Animal {

    private int currentDirection;

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    int decideMove() {
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.FOX) {
                if (canMove(Model.turn(i, 3)))
                    return Model.turn(i, 3);
                else if ((canMove(Model.turn(i, -3))))
                    return Model.turn(i, -3);
                else if ((canMove(Model.turn(i, 2))))
                    return Model.turn(i, 2);
                else if ((canMove(Model.turn(i, -2))))
                    return Model.turn(i, -2);
                else {
                    currentDirection = Model.random(Model.MIN_DIRECTION,
                            Model.MAX_DIRECTION);
                    for (int j = 0; j < 8; j++) {
                        if (canMove(currentDirection))
                            return currentDirection;
                        else
                            currentDirection = Model.turn(currentDirection, 1);
                    }


                }
            }
        }
        return Model.STAY;
    }
}
