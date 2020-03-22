package string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 功能:
 *
 * @author kmm on 2020-01-21
 */
@Slf4j
public class StringTest {

    @Test
    public void subStringMethod(){
        String str = "1001024279";
        System.out.println(str.substring(4));
    }
}
