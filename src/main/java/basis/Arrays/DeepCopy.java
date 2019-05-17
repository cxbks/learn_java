package basis.Arrays;

import basis.Object.Clothes;

public class DeepCopy {
    public static void main(String[] args) {
        Clothes[] c1 = {new Clothes("red", 'L'), new Clothes("blue", 'M')};
        Clothes[] c2 = new Clothes[c1.length];
        for (int i = 0; i < c1.length; i++) {
            c2[i] = new Clothes(c1[i].color, c1[i].size);
        }
        c1[0].color = "yellow";
        System.out.println(c2[0].color);
    }
}
