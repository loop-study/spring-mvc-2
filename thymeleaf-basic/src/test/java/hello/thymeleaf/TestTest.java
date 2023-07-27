package hello.thymeleaf;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestTest {

    @Test
    void test() {
        // given
        String cnt = "0";

        // when
        boolean result = stringToInt(cnt) < 0;

        // then
//        assertThat(result).isTrue();
    }

    private int stringToInt(String cnt) {
        return Integer.parseInt(cnt);
    }
}
