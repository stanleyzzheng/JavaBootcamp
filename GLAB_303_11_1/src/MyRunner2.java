public class MyRunner2 {
    public static void main(String[] args){
        GMultipleDatatype<String, Integer> mobj = new GMultipleDatatype<>("Per Scholas", 11025);
        System.out.println(mobj.getValueOne());
        System.out.println(mobj.getValueTwo());
        GMultipleDatatype<String, String> mobj2 = new GMultipleDatatype<>("Per Scholas" ,"Non profit");
        System.out.println(mobj2.getValueOne());
        System.out.println(mobj2.getValueTwo());
    }
}
