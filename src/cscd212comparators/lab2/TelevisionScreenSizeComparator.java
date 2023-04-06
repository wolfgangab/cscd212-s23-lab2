package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {
    @Override
    public int compare(final Television t1, final Television t2) {
        if(t1 == null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
           return t1.getScreenSize() - t2.getScreenSize();
    }
}
