package test.assertk.assertions

import assertk.assert
import assertk.assertions.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class ComparableTest {
    //region isGreaterThan
    @Test fun isGreaterThan_greater_value_passes() {
        assert(2).isGreaterThan(1)
    }

    @Test fun isGreaterThan_non_greater_value_fails() {
        val error = assertFails {
            assert(0).isGreaterThan(0)
        }
        assertEquals("expected to be greater than:<0> but was:<0>", error.message)
    }
    //endregion

    //region isLessThan
    @Test fun isLessThan_lesser_value_passes() {
        assert(1).isLessThan(2)
    }

    @Test fun isLessThan_non_lesser_value_fails() {
        val error = assertFails {
            assert(0).isLessThan(0)
        }
        assertEquals("expected to be less than:<0> but was:<0>", error.message)
    }
    //endregion

    //region isGreaterThanOrEqualTo
    @Test fun isGreaterThanOrEqualTo_greater_value_passes() {
        assert(2).isGreaterThanOrEqualTo(1)
    }

    @Test fun isGreaterThanOrEqualTo_equal_value_passes() {
        assert(2).isGreaterThanOrEqualTo(2)
    }

    @Test fun isGreaterThanOrEqualTo_lesser_value_fails() {
        val error = assertFails {
            assert(0).isGreaterThanOrEqualTo(2)
        }
        assertEquals("expected to be greater than or equal to:<2> but was:<0>", error.message)
    }
    //endregion

    //region isLessThanOrEqualTo
    @Test fun isLessThanOrEqualTo_lesser_value_passes() {
        assert(1).isLessThanOrEqualTo(2)
    }

    @Test fun isLessThanOrEqualTo_equal_value_passes() {
        assert(2).isLessThanOrEqualTo(2)
    }

    @Test fun isLessThanOrEqualTo_greater_value_fails() {
        val error = assertFails {
            assert(2).isLessThanOrEqualTo(0)
        }
        assertEquals("expected to be less than or equal to:<0> but was:<2>", error.message)
    }
    //endregion

    //region isBetween
    @Test fun isBetween_inside_range_passes() {
        assert(1).isBetween(0, 2)
    }

    @Test fun isBetween_lower_bound_passes() {
        assert(0).isBetween(0, 2)
    }

    @Test fun isBetween_upper_bound_passes() {
        assert(2).isBetween(0, 2)
    }

    @Test fun isBetween_below_lower_bound_fails() {
        val error = assertFails {
            assert(-1).isBetween(0, 2)
        }
        assertEquals("expected to be between:<0> and <2> but was:<-1>", error.message)
    }

    @Test fun isBetween_above_upper_bound_fails() {
        val error = assertFails {
            assert(3).isBetween(0, 2)
        }
        assertEquals("expected to be between:<0> and <2> but was:<3>", error.message)
    }
    //endregion

    //region isStrictlyBetween
    @Test fun isStrictlyBetween_inside_range_passes() {
        assert(0 + 1).isStrictlyBetween(0, 2)
    }

    @Test fun isStrictlyBetween_lower_bound_fails() {
        val error = assertFails {
            assert(0).isStrictlyBetween(0, 2)
        }
        assertEquals("expected to be strictly between:<0> and <2> but was:<0>", error.message)
    }

    @Test fun isStrictlyBetween_upper_bound_fails() {
        val error = assertFails {
            assert(2).isStrictlyBetween(0, 2)
        }
        assertEquals("expected to be strictly between:<0> and <2> but was:<2>", error.message)
    }

    @Test fun isStrictlyBetween_below_lower_bound_fails() {
        val error = assertFails {
            assert(0 - 1).isStrictlyBetween(0, 2)
        }
        assertEquals("expected to be strictly between:<0> and <2> but was:<-1>", error.message)
    }

    @Test fun isStrictlyBetween_above_upper_bound_fails() {
        val error = assertFails {
            assert(2 + 1).isStrictlyBetween(0, 2)
        }
        assertEquals("expected to be strictly between:<0> and <2> but was:<3>", error.message)
    }
    //endregion
}