package com.kopever.framework.core.validation;

import jakarta.validation.groups.Default;

public interface ValidationGroup {

    interface Create extends Default {
    }

    interface Update extends Default {
    }

    interface Delete extends Default {
    }

    interface Query extends Default {
    }

}
