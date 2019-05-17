package basis.String.StringJoiner;

import java.util.StringJoiner;

/**
 * 功能：
 *
 * @author kmm on 2019/2/27
 */
public class StringJoinerTest {

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("Hollis");

        sj.add("hollischuang");
        sj.add("Java干货");
        System.out.println(sj.toString());

        StringJoiner sj1 = new StringJoiner(":","[","]");

        sj1.add("Hollis").add("hollischuang").add("Java干货");
        System.out.println(sj1.toString());
    }
}
