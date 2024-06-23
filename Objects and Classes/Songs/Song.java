public class Song {
    //(field): Type List, Name and Time (3:23)
    private String typeList;
    private String name;
    private String time;

    //constructor
    public Song (String typeList, String name, String time) {
        //new object
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    //getter for name
    public String getName() {
        return name;
    }

    //getter for typeList
    public String getTypeList() {
        return typeList;
    }
}
