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

package org.mifos.test.acceptance.framework.loan;

import org.mifos.test.acceptance.framework.AbstractPage;
import org.testng.Assert;

import com.thoughtworks.selenium.Selenium;

public class CreateLoanAccountsEntryPage extends AbstractPage {

    public CreateLoanAccountsEntryPage(Selenium selenium) {
        super(selenium);
        verifyPage("CreateMultipleLoanAccountsSearchResults");
    }

    public void selectClients(int clientNumber, String expectedClientName) {
        Assert.assertEquals(selenium.getText("CreateMultipleLoanAccountsSearchResults.clientName." + clientNumber), expectedClientName);
        selenium.check("CreateMultipleLoanAccountsSearchResults.checkbox." + clientNumber);
    }

    public void updateLoanPurposeForClient(int clientNumber, String loanPurpose){
        selenium.select("clientDetails[" + clientNumber + "].businessActivity", loanPurpose);
    }

    public CreateLoanAccountsSuccessPage submitAndNavigateToCreateMultipleLoanAccountsSuccessPage() {
        selenium.click("CreateMultipleLoanAccountsSearchResults.button.submit");
        waitForPageToLoad();
        return new CreateLoanAccountsSuccessPage(selenium);
    }

    public CreateLoanAccountsSuccessPage saveAndNavigateToCreateMultipleLoanAccountsSuccessPage() {
        selenium.click("CreateMultipleLoanAccountsSearchResults.button.saveForLater");
        waitForPageToLoad();
        return new CreateLoanAccountsSuccessPage(selenium);
    }

    public void verifyPage() {
        this.verifyPage("CreateMultipleLoanAccountsSearchResults");
    }

    public String getNoOfInstallments(Integer row){
        return selenium.getTable("SearchClients."+row+".4");
    }

    public void verifyNoOfInstallments(Integer row, String noOfInstallments){
        Assert.assertEquals(getNoOfInstallments(row), noOfInstallments);
    }

}
