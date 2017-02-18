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
public class Part2DeadlockWith4SharedResources {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String a = "A";
        final String b = "B";
        final String c = "C";
        final String d = "D";
        Stream.of(
                new Lock1then2("AthenB", a, b),
                new Lock1then2("BthenC", b, c),
                new Lock1then2("CthenD", c, d),
                new Lock1then2("DthenA", d, a),
                new StackTraceCatcher(1200, "Part2DeadlockWith4SharedResources.txt")
        ).map(Thread::new).forEach(Thread::start);
    }

}
