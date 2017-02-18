/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatroubleshootingtask.deadlocks;

import java.util.stream.Stream;

/**
 *
 * @author Andrii_Kozak1
 */
public class Part4RealisticDeadlock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       final String a = "A";
       final String b = "B";
       Stream.of(
       new Lock1then2("AthenB",a,b),
       new Lock1then2("BthenA",b,a),
       new Lock1("Auser1",a),
       new Lock1("Auser2",a),
       new Lock1("Auser3",a),
       new Lock1("Buser1",b),
       new Lock1("Buser2",b),
       new Lock1("Buser3",b),       
       new StackTraceCatcher(1200,"Part4RealisticDeadlock.txt")
       ).map(Thread::new).forEach(Thread::start);
    }
    
}
