package number;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yang on 2017/10/20.
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian() + " <---> 1.0");
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian() + " <---> 1.5");
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian() + " <---> 2.0");
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian() + " <---> 2.5");
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian() + " <---> 3.0");
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian() + " <---> 3.5");
    }
}

class MedianFinder {
    private PriorityQueue<Integer> smallPart; //小的那一半数，最大堆
    private PriorityQueue<Integer> largePart; //大的那一半数，最小堆

    /** initialize your data structure here. */
    public MedianFinder() {
        this.smallPart = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        this.largePart = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. 先将num放入小的那一半里
        smallPart.add(num);
        // 2. 再从小的那一半里拿一个最大的放入大的那一半里
        largePart.add(smallPart.poll());
        // 3. 如果大的那一半的个数大于小的那一半，就从大的那一半里取出最小值放入小的那一半
        if (smallPart.size() < largePart.size()) {
            smallPart.add(largePart.poll());
        }
    }

    public double findMedian() {
        if (smallPart.size() == largePart.size()) {
            return ((double)smallPart.peek() + largePart.peek()) / 2.0;
        } else {
            return smallPart.peek();
        }
    }
}
