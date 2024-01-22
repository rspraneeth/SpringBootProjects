package com.rsp.bo;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
//    lob - large objects, blob - binary lob, clob - character lob
//    blob - image, audio, video, clob - text-file, xml-file

    @Lob
    @Column(length = 100000)
    private byte[] image;

    @Lob
    private char[] textFile;

    public JobSeeker() {
        System.out.println("Zero param constructor JobSeeker");
    }

    public JobSeeker(String name, String city, byte[] image, char[] textFile) {
        this.name = name;
        this.city = city;
        this.image = image;
        this.textFile = textFile;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", image=" + Arrays.toString(image) +
                ", textFile=" + Arrays.toString(textFile) +
                '}';
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public char[] getTextFile() {
        return textFile;
    }

    public void setTextFile(char[] textFile) {
        this.textFile = textFile;
    }
}
