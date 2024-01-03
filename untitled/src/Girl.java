public class Girl extends Person{
    static double ageFactor = 1.3;
    public Girl(String aname){
        name = "Ms. " + aname;
    }
    public  String talk(){
        return "Hello! " + jump();
    }
    public String jump(){
        return "I am jumping.";
    }

    public static double lifeSpan(){
        return lifespan * ageFactor;
    }

}
