class Product {
    private int ID;
    private String name;
    private int numberOfItems;

    public Product() {
    }

    public Product(int ID, String name, int numberOfItems) {
        this.ID = ID;
        this.name = name;
        this.numberOfItems = numberOfItems;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
