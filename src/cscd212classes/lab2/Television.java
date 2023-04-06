package cscd212classes.lab2;

import java.util.Objects;

public class Television {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        this(make, model, smart, screenSize, resolution);
    }
    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

        if (resolution > 4000) {
            fourK = true;
        }
        else fourK = false;
    }

    public int compareTo(final Television another) {
        return this.make.compareTo(another.make);
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() +
                this.model.hashCode() +
                this.resolution +
                Boolean.hashCode(this.smart) +
                Boolean.hashCode(fourK)
                ;
    }

    @Override
    public String toString() {
        String str = "";

        str += make + "-" +
                model + ", " +
                screenSize;

        if (smart == true)
            str += " smart";

        str += " tv with ";

        if (fourK == true) {
            str += "4k resolution";
        }else str += resolution + " resolution";

        return str;
    }
}
