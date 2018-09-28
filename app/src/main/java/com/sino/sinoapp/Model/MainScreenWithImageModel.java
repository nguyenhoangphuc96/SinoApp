package com.sino.sinoapp.Model;

import java.util.List;

public class MainScreenWithImageModel {
    private Integer id;
    private String name;
    private String ages;
    private String height;
    private String weight;
    private String mesure3ring;
    private String price;
    private String avatar;
    private List<String> listImage;

    public MainScreenWithImageModel(Integer id, String name, String ages, String height, String weight, String mesure3ring, String price, String avatar, List<String> listImage) {
        this.id = id;
        this.name = name;
        this.ages = ages;
        this.height = height;
        this.weight = weight;
        this.mesure3ring = mesure3ring;
        this.price = price;
        this.avatar = avatar;
        this.listImage = listImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMesure3ring() {
        return mesure3ring;
    }

    public void setMesure3ring(String mesure3ring) {
        this.mesure3ring = mesure3ring;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getListImage() {
        return listImage;
    }

    public void setListImage(List<String> listImage) {
        this.listImage = listImage;
    }
}
