package com.arikko.prev_final_exam_solution;

public class DummyMonitor extends Monitor {
    private int ppi;

    public DummyMonitor(int ppi) {
        this.ppi = ppi;
    }

    public DummyMonitor(String model, String resolution, String diagonal, float price, int ppi) {
        super(model, resolution, diagonal, price);
        this.ppi = ppi;
    }

    public int getPpi() {
        return ppi;
    }

    public void setPpi(int ppi) {
        this.ppi = ppi;
    }

    @Override
    public String toString() {
        return "DummyMonitor{" +
                "ppi=" + ppi +
                '}';
    }
}
