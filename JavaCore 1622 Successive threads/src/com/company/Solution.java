package com.company;

/*

1622 Sequential threads

1. In the run method, after all actions set a delay of 10 milliseconds. Print "Thread interrupted" if the thread is interrupted.
2. Make all threads run sequentially: first for thread # 1, count from COUNT to 1, then for thread # 2 from COUNT to 1, etc.
Example:
# 1: 4
#thirteen
...
# 1: 1
# 2: 4
...

Requirements:
1. The program must create 4 objects of type SleepingThread.
2. The main method should call join on each SleepingThread thread created.
3. The run method must use Thread.sleep (10).
4. The output of the program must comply with the condition.
5. If the SleepingThread thread is interrupted, it should display the message "Thread interrupted."


 */



public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new SleepingThread().join();

            //напишите тут ваш код
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countDownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDownIndex == 0) return;
                //напишите тут ваш код
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                }
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}



