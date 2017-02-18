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
public class Lock1 implements Runnable {

    private final Object first;
    private final String name;

    public Lock1(String name, Object first) {
        this.first = first;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(name + "trying to lock " + first);
            synchronized (first) {
                System.out.println(name + "locked " + first);
            }
            System.out.println(name + "released" + first);
        } catch (InterruptedException ex) {
        }
    }

}
