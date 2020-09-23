package zy.demo.entity;

public class Nation {
    private int id;
    private String name;
    private int male_population;
    private int male_rate;
    private int female_populaton;
    private int female_rate;

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

    public int getMale_population() {
        return male_population;
    }

    public void setMale_population(int male_population) {
        this.male_population = male_population;
    }

    public int getMale_rate() {
        return male_rate;
    }

    public void setMale_rate(int male_rate) {
        this.male_rate = male_rate;
    }

    public int getFemale_populaton() {
        return female_populaton;
    }

    public void setFemale_populaton(int female_populaton) {
        this.female_populaton = female_populaton;
    }

    public int getFemale_rate() {
        return female_rate;
    }

    public void setFemale_rate(int female_rate) {
        this.female_rate = female_rate;
    }

    @Override
    public String toString() {
        return "正在打印："+this.name;
    }
}
