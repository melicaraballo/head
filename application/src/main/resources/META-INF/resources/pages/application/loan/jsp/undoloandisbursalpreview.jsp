<%--
Copyright (c) 2005-2011 Grameen Foundation USA
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing
permissions and limitations under the License.

See also http://www.apache.org/licenses/LICENSE-2.0.html for an
explanation of the license and how it is applied.
--%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/tags/mifos-html" prefix="mifos"%>
<%@taglib uri="/tags/date" prefix="date"%>
<%@taglib uri="http://struts.apache.org/tags-html-el" prefix="html-el"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/sessionaccess" prefix="session"%>
<%@ taglib uri="/userlocaledate" prefix="userdatefn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tiles:insert definition=".view">
	<tiles:put name="body" type="string">
		<span id="page.id" title="UndoLoanDisbursalPreview"></span>
		<html-el:form action="/reverseloandisbaction">
		<c:set value="${session:getFromSession(sessionScope.flowManager,requestScope.currentFlowKey,'BusinessKey')}" var="BusinessKey" />
		<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bluetablehead05">
						<span class="fontnormal8pt"><html-el:link styleId="undoloandisbursalpreview.link.admin" href="reverseloandisbaction.do?method=cancel&currentFlowKey=${requestScope.currentFlowKey}">
								<mifos:mifoslabel name="loan.admin" />
							</html-el:link> / </span> <span class="fontnormal8ptbold"><mifos:mifoslabel name="loan.reverse" /> <mifos:mifoslabel name="${ConfigurationConstants.LOAN}" /> <mifos:mifoslabel name="loan.disbursal" /></span>
					</td>
				</tr>
			</table>
			<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="left" valign="top" class="paddingL10">
						<br>
						<table width="90%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left" valign="top">
									<span class="heading"><mifos:mifoslabel name="loan.reverse" /> <mifos:mifoslabel name="${ConfigurationConstants.LOAN}" /> <mifos:mifoslabel name="loan.disbursal" /> - </span><span class="headingorange"> <mifos:mifoslabel name="loan.preview" /></span>
								</td>
							</tr>
						</table>
						<br>
						<table width="96%" border="0" cellpadding="3" cellspacing="0">
							<tr>
								<td valign="top" class="fontnormal">
									<font color="#FF0000"> <mifos:mifoslabel name="loan.areyousure" /> <mifos:mifoslabel name="${ConfigurationConstants.LOAN}" /> <mifos:mifoslabel name="loan.alreadyDisbursed" />? <mifos:mifoslabel
											name="loan.ifyouclicksubmit" /> <mifos:mifoslabel name="${ConfigurationConstants.LOAN}" /> <mifos:mifoslabel name="loan.accountStatuschanged" /> <mifos:mifoslabel name="loan.clickcanceladmin" /></font>
								</td>
							</tr>
							<font class="fontnormalRedBold"> <span id="undoloandisbursalpreview.error.message"><html-el:errors bundle="loanUIResources" /></span> </font>
							<tr>
								<td width="100%" valign="top" class="drawtablerow">
									<p>
										<span class="fontnormalbold"><br> <c:out value="${BusinessKey.loanOffering.prdOfferingName}"/> - <mifos:mifoslabel name="loan.Account" /> 
										#<c:out value="${BusinessKey.globalAccountNum}"/><br> </span>
										<span class="fontnormalbold">
										<c:choose>
											<c:when test="${BusinessKey.customer.customerLevel.id==1}">
											<mifos:mifoslabel name="${ConfigurationConstants.CLIENT}" isColonRequired="Yes" />
											</c:when>
											<c:otherwise>
											<mifos:mifoslabel name="${ConfigurationConstants.GROUP}" isColonRequired="Yes" />
											</c:otherwise>
										</c:choose>
										</span> <c:out value="${BusinessKey.customer.displayName}"/>: <mifos:mifoslabel name="${ConfigurationConstants.ID}" /> <c:out value="${BusinessKey.customer.globalCustNum}"/>
										<br>
										<span class="fontnormalbold"><mifos:mifoslabel name="loan.loanOfficer" isColonRequired="Yes" /></span> <c:out value="${BusinessKey.personnel.displayName}"/>
										<br>
										<c:out value="${BusinessKey.office.officeName}"/>
										<c:if test="${BusinessKey.customer.customerLevel.id==1}">
										 / <c:out value="${BusinessKey.customer.parentCustomer.parentCustomer.displayName}"/>
										</c:if>
										 / 
										 <c:out value="${BusinessKey.customer.parentCustomer.displayName}"/>
									</p>
									<p>
										<span class="fontnormalbold"><mifos:mifoslabel name="loan.amountDisbursed" isColonRequired="Yes" /></span> <fmt:formatNumber value="${BusinessKey.loanAmount.amount}"/>
										<br>
										<span class="fontnormalbold"><mifos:mifoslabel name="loan.proposed_date" isColonRequired="Yes" /></span> <c:out value="${userdatefn:getUserLocaleDate(sessionScope.UserContext.preferredLocale,BusinessKey.disbursementDate)}" />
										<br>
										<span class="fontnormalbold"><mifos:mifoslabel name="loan.nopaymentsmade" isColonRequired="Yes" /></span> <fmt:formatNumber value="${session:getFromSession(sessionScope.flowManager,requestScope.currentFlowKey,'paymentssize')}" />
										<br>
										<span class="fontnormalbold"><mifos:mifoslabel name="loan.amt_paid" isColonRequired="Yes" /></span> <fmt:formatNumber value="${BusinessKey.loanSummary.totalAmntPaid.amount}"/>
										<br>
										<br>
									</p>
								</td>
							</tr>
						</table>
						<table width="96%" border="0" cellpadding="3" cellspacing="0">
							<tr>
								<td colspan="3" class="drawtablerowbold">
									<mifos:mifoslabel name="loan.paymentsmade" />
								</td>
							</tr>
							<tr>
								<td width="15%" class="drawtablerowbold">
									<mifos:mifoslabel name="loan.no" />
									.
								</td>
								<td width="40%" class="drawtablerowbold">
									<mifos:mifoslabel name="loan.date_paid" />
								</td>
								<td width="40%" class="drawtablerowbold">
									<mifos:mifoslabel name="loan.amount" />
								</td>
							</tr>
							<c:forEach varStatus="loopStatus1" items="${session:getFromSession(sessionScope.flowManager,requestScope.currentFlowKey,'payments')}" var="payment">
							<c:if test="${payment.totalValue > 0.0}">
							<bean:define id="ctr1" toScope="request" >
								<c:out value="${loopStatus1.index}" />
							</bean:define>
							<tr>
								<td width="15%" class="drawtablerow">
									<c:out value="${ctr1+1}" />
								</td>
								<td width="40%" class="drawtablerow">
									<c:out value="${userdatefn:getUserLocaleDate(sessionScope.UserContext.preferredLocale,payment.actionDate)}" />
								</td>
								<td width="40%" class="drawtablerow">
									<fmt:formatNumber value="${payment.total}" />
								</td>
							</tr>
							</c:if>
							</c:forEach>
						</table>
						<table width="95%" border="0" cellpadding="3" cellspacing="0">
							<tr>
								<td width="6%" valign="top" class="fontnormalbold">
									<mifos:mifoslabel name="loan.note" />
								</td>
								<td width="94%" align="left" valign="top" class="fontnormal" style="padding-left:4px;">
									<c:out value="${sessionScope.reverseloandisbactionform.note}"/>
								</td>
							</tr>
						</table>
						<table width="96%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center" class="blueline">
									&nbsp;
								</td>
							</tr>
						</table>
						<br>
						<table width="96%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center">
									<html-el:submit styleId="undoloandisbursalpreview.button.submit" property="continueButton" styleClass="buttn" >
										<mifos:mifoslabel name="loan.submit" />
									</html-el:submit>
									&nbsp;

									<html-el:button styleId="undoloandisbursalpreview.button.cancel" property="cancelButton" onclick="location.href='reverseloandisbaction.do?method=cancel&currentFlowKey=${requestScope.currentFlowKey}'" styleClass="cancelbuttn" >
										<mifos:mifoslabel name="loan.cancel" />
									</html-el:button>
								</td>
							</tr>
						</table>
						<br>
					</td>
				</tr>
			</table>
			<html-el:hidden property="currentFlowKey" value="${requestScope.currentFlowKey}" />
			<html-el:hidden property="method" value="update" />
		</html-el:form>
	</tiles:put>
</tiles:insert>
