public class GravityDevice {
    //может нужно передавать локацию или чела
    private boolean isEnabled = false;

    public void changeState(Location location, String name) {
        isEnabled = !isEnabled;

        if (isEnabled) {
            System.out.println(name + " включает прибор невесомости");
            location.setGravityEnabled(false);
        } else {
            System.out.println(name + " выключает прибор невесомости");
            location.setGravityEnabled(true);
        }
    }
}
