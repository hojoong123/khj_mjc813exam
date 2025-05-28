package com.khj_mjc813exam;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMjcValidCheck {
    @Test
    public void testMjcValidCheck() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-3992")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("02-7487-0203")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("02-d35a-1s32")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);
    }
}
