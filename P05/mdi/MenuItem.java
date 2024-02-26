package mdi;


// This class manages a single line of the menu with its associated method
class MenuItem implements Runnable {
    public MenuItem(Object menuText, Runnable menuResponse) {
        this.menuText = menuText;
        this.menuResponse = menuResponse;
    }
   @Override
    public String toString() {
        return menuText.toString();
    }
    @Override
    public void run() {
        menuResponse.run();
    }
    private Object menuText;        // The text displayed to the user
    private Runnable menuResponse;  // run() is called on this object when selected
}

