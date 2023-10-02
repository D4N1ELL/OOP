public class Car {
    float speed = 0;
    boolean isMoving = false;
    
    String carModel;
  
    public Car(String carModel){
        this.carModel = carModel;
    }

    public Car(String carModel, float speed){
        this.carModel = carModel;
        this.speed = speed;
        this.isMoving = speed > 0;
    }
}