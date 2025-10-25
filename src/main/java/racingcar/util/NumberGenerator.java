package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
