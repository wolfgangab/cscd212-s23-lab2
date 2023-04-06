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
        if(model == null ||model.isEmpty() || make == null || make.isEmpty() || resolution < 720 || screenSize < 32)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

        if (resolution > 2000) {
            fourK = true;
        }
        else fourK = false;
    }

    public int compareTo(final Television another) {
        if(another == null || another.getScreenSize() < 32 || another.getResolution() < 720 || another.make == null || another.make.isEmpty() || another.model == null || another.model.isEmpty())
            throw new IllegalArgumentException("null parameter in the compareTo method");
        if (this.make.equals(another.make)) {
            if (this.model.equals(another.model)) {
                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Television)) return false;
        Television that = (Television) o;
        if(that == null || that.getScreenSize() < 32 || that.getResolution() < 720 || that.make == null || that.make.isEmpty() || that.model == null || that.model.isEmpty())
            throw new IllegalArgumentException("Unexpected exception type thrown");
        return this.fourK == that.fourK && this.resolution == that.resolution && this.screenSize == that.screenSize && this.smart == that.smart && Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model);
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
                Boolean.hashCode(this.fourK);
    }

    @Override
    public String toString() {
        String str = "";

        str += make + "-" +
                model + ", " +
                screenSize + " inch";

        if (smart == true)
            str += " smart";

        str += " tv with ";

        if (fourK == true) {
            str += "4K resolution";
        }else str += resolution + " resolution";
        return str;
    }
}
