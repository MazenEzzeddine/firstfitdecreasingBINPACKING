package org.hps;

public class Partition implements Comparable<Partition> {
    private Long lag;
    public Partition(Long lag) {
        this.lag = lag;
    }

    public Long getLag() {
        return lag;
    }

    public void setLag(Long lag) {
        this.lag = lag;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "lag=" + lag +
                '}';
    }

    @Override
    public int compareTo(Partition o) {
        return Long.compare(this.lag , o.lag);
    }
}
