package org.hps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int consumerCount = 0;
    static ArrayList<Consumer> consumers = new ArrayList<>();
    static Partition[] partitions = new Partition[3];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the lag for the " + i + "th partition");
            partitions[i] = new Partition(input.nextLong());
        }

      /*  System.out.println(Arrays.toString(partitions));
        Arrays.sort(partitions);
        System.out.println(Arrays.toString(partitions));
        Arrays.sort(partitions, Collections.reverseOrder());
        System.out.println(Arrays.toString(partitions));*/
        firstFitDecreasing();
        System.out.println(Arrays.toString(consumers.toArray()));

    }


    static void firstFitDecreasing() {
        //sort the array in Decreasing order
        Arrays.sort(partitions, Collections.reverseOrder());
        consumers.add(new Consumer(10L));
        consumerCount++;
        Consumer consumer = null;

        for (Partition partition : partitions) {
            for (Consumer cons : consumers) {
                if (cons.getRemainingSize() >= partition.getLag()) {
                    cons.assignPartition(partition);
                    //cons.setRemainingSize(cons.getRemainingSize()- partition.getLag());
                    // we are done with this partition, go to next
                    break;
                }
                //we have iterated over all the consumers hoping to fit that partition, but nope
                //we shall create a new consumer
                if (cons == consumers.get(consumers.size() - 1)) {
                    consumer = new Consumer(10L);
                    consumer.assignPartition(partition);
                    consumerCount++;
                }
            }

            // account for a consumers added for the last partition
            if (consumer != null) {
                consumers.add(consumer);
                consumer = null;
            }

        }
        //TODO look at the case when a lag does not fit any consumer

    }


}

