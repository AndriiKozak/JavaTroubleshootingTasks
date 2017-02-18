/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatroubleshootingtask.deadlocks;

/**
 *
 * @author Andrii_Kozak1
 */
public class Lock1then2 implements Runnable {

    private final Object first;
    private final Object second;
    private final String name;

    public Lock1then2(String name, Object first, Object second) {
        this.first = first;
        this.second = second;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (first) {
            try {
                System.out.println(name + " locked " + first);
                Thread.sleep(1000);
                System.out.println(name + "trying to lock " + second);
                synchronized (second) {
                    System.out.println(name + "locked " + second);
                }
                System.out.println(name + "released" + second);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println(name + "released" + first);
    }

}
