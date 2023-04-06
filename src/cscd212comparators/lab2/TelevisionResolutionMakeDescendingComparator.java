package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator <Television> {
    @Override
    public int compare(final Television t1, final Television t2) {
        if (t1.getResolution() == t2.getResolution()) {
            return t1.getMake().compareTo(t2.getMake());
        }
        if (t1.getResolution() > t2.getResolution()) {
            return -1;
        }
        return 1; // if t1.getResolution() < t2.getResolution
    }
}
