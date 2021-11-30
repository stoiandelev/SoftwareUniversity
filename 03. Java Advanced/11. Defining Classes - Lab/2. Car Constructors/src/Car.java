public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(){
    }

    public Car(String brand){
        this(brand, "unknown", -1);
    }

    public Car(String brand, String model){
        this(brand, model, -1);
    }

    public Car(String brand, int horsePower){
        this(brand,"unknown",horsePower);
    }

    public Car(String brand, String model, int horsePower){
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand)   {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.getBrand()
                ,this.getModel(),this.getHorsePower());
    }


    public String carInfo(){
        return toString();
    }
}
