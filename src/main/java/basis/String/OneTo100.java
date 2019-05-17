package basis.String;

import java.util.StringJoiner;

public class OneTo100 {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append(i).append('+');

        }
        System.out.println(builder.append(100).toString());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OneTo100.class.getSimpleName() + "[", "]")
                .toString();
    }
}
