package com.arikko.prev_final_exam_solution;


import java.io.Serializable;

public class Monitor implements Serializable {
    private String model, resolution, diagonal;
    private float price;

    public Monitor() {
    }

    public Monitor(String model, String resolution, String diagonal, float price) {
        this.model = model;
        this.resolution = resolution;
        this.diagonal = diagonal;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal=" + diagonal +
                ", price=" + price +
                '}';
    }

    public Integer getPPI() {
        int ppi = 0;

        String diagonal = this.getDiagonal();
        String resolution = this.getResolution();
        if (diagonal.equals("17 Inches")) {
            if (resolution.equals("HD")) {
                ppi = 86;
            } else if (resolution.equals("HD+")) {
                ppi = 108;
            } else if (resolution.equals("Full-HD")) {
                ppi = 130;
            } else {
                ppi = 173;
            }
        } else if (diagonal.equals("19 Inches")) {
            if (resolution.equals("HD")) {
                ppi = 77;
            } else if (resolution.equals("HD+")) {
                ppi = 97;
            } else if (resolution.equals("Full-HD")) {
                ppi = 116;
            } else {
                ppi = 155;
            }
        } else if (diagonal.equals("22 Inches")) {
            if (resolution.equals("HD")) {
                ppi = 67;
            } else if (resolution.equals("HD+")) {
                ppi = 83;
            } else if (resolution.equals("Full-HD")) {
                ppi = 100;
            } else {
                ppi = 134;
            }
        } else {
            if (resolution.equals("HD")) {
                ppi = 61;
            } else if (resolution.equals("HD+")) {
                ppi = 76;
            } else if (resolution.equals("Full-HD")) {
                ppi = 92;
            } else {
                ppi = 122;
            }
        }

        return ppi;
    }
}
