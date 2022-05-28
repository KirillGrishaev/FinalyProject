package ru.shop.models;
public class Habar {
    private int article;
    private String name;
    private String type;
    private int cost;
    private double weight;
    private String rare;
    public Habar(){}
    public Habar(int article,String name, String type, int cost, double weight, String rare){
        this.article = article;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.weight = weight;
        this.rare = rare;
    }
    public int getArticle() {
        return article;
    }
    public void setArticle(int article) {
        this.article = article;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getRare() {
        return rare;
    }
    public void setRare(String rare) {
        this.rare = rare;
    }
    @Override
    public String toString() {
        return "Habar{" +
                "article=" + article +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", rare='" + rare + '\'' +
                '}';
    }
}