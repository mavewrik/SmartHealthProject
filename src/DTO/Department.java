package DTO;

public class Department {

    private String id;
    private String name;
    private String hod;

    public Department(){
        this.id = " ";
        this.name = " ";
        this.hod = " ";
    }

    public Department(String id,String name,String hod){
        this.id = id;
        this.name = name;
        this.hod = hod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHod() {
        return hod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }
}
