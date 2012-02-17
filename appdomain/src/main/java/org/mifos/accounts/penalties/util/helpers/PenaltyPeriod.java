/*
 * Copyright (c) 2005-2011 Grameen Foundation USA
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * See also http://www.apache.org/licenses/LICENSE-2.0.html for an
 * explanation of the license and how it is applied.
 */

package org.mifos.accounts.penalties.util.helpers;

import org.mifos.config.LocalizedTextLookup;
import org.mifos.framework.exceptions.PropertyNotFoundException;

public enum PenaltyPeriod implements LocalizedTextLookup {
    INSTALLMENTS(1, "PenaltyPeriod-NumberOfInstallments"),
    DAYS(2, "PenaltyPeriod-NumberOfDays"),
    NONE(3, "PenaltyPeriod-None");

    Short value;
    String messageKey;

    private PenaltyPeriod(int value, String key) {
        this.value = (short) value;
        this.messageKey = key;
    }

    public Short getValue() {
        return value;
    }

    public static PenaltyPeriod getPenaltyPeriod(Short value) throws PropertyNotFoundException {
        for (PenaltyPeriod period : PenaltyPeriod.values()) {
            if (period.getValue().equals(value)) {
                return period;
            }
        }
        throw new PropertyNotFoundException("PenaltyPeriod");
    }

    @Override
    public String getPropertiesKey() {
        return messageKey;
    }
}
