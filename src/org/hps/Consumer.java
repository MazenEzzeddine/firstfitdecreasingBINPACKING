package org.hps;

import java.util.ArrayList;

public class Consumer {
    private Long capacity;

    public Long getRemainingSize() {
        return remainingSize;
    }

    public void setRemainingSize(Long remainingSize) {
        this.remainingSize = remainingSize;
    }

    public ArrayList<Partition> getAssignedPartitions() {
        return assignedPartitions;
    }

    public void setAssignedPartitions(ArrayList<Partition> assignedPartitions) {
        this.assignedPartitions = assignedPartitions;
    }

    private Long remainingSize;
    private ArrayList<Partition> assignedPartitions;

    public Consumer(Long capacity) {
        this.capacity = capacity;
        this.remainingSize = capacity;
        assignedPartitions = new ArrayList<>();
    }


    public Long getCapacity() {
        return capacity;
    }


    public void  assignPartition(Partition partition) {
        assignedPartitions.add(partition);
        remainingSize -= partition.getLag();
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("Consumer{" +
                "capacity=" + capacity +
                "\nremainingCapacity=" + remainingSize +
                "\n");

        for (int i = 0; i < assignedPartitions.size() ; i++) {
            sb.append(",\n assigned partitions:" + assignedPartitions.get(i).toString());
        }

        sb.append("\n}");


        return sb.toString();

    }
}
