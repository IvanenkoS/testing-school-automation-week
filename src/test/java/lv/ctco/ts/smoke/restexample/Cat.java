package lv.ctco.ts.smoke.restexample;

public class Cat {

    int id;
    String name;
    int age;
    String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat [id="+id+", name=" + name + ", age=" + age + ", color="+color+"]";
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }

    public void update(Cat cat){
        this.setId(cat.getId());
        this.setName(cat.getName());
        this.setAge(cat.getAge());
        this.setColor(cat.getColor());
    }
}