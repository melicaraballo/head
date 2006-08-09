package org.mifos.application.accounts.loan.business;

import java.sql.Timestamp;

import org.mifos.application.accounts.business.AccountBO;
import org.mifos.application.personnel.business.PersonnelBO;
import org.mifos.framework.business.PersistentObject;
import org.mifos.framework.util.helpers.Money;

public class LoanActivityEntity extends PersistentObject {

	private final Integer id;

	private final AccountBO account;

	private final PersonnelBO personnel;

	private final String comments;

	private final Money principal;

	private final Money principalOutstanding;

	private final Money interest;

	private final Money interestOutstanding;

	private final Money fee;

	private final Money feeOutstanding;

	private final Money penalty;

	private final Money penaltyOutstanding;

	private final Timestamp trxnCreatedDate;

	protected LoanActivityEntity() {
		this.id = null;
		this.personnel = null;
		this.comments = null;
		this.principal = null;
		this.principalOutstanding = null;
		this.interest = null;
		this.interestOutstanding = null;
		this.fee = null;
		this.feeOutstanding = null;
		this.penalty = null;
		this.penaltyOutstanding = null;
		this.trxnCreatedDate = null;
		this.account = null;
	}

	public LoanActivityEntity(AccountBO account,PersonnelBO personnel, String comments,
			Money principal, Money principalOutstanding, Money interest,
			Money interestOutstanding, Money fee, Money feeOutstanding,
			Money penalty, Money penaltyOutstanding ) {
		this.id = null;
		this.personnel = personnel;
		this.comments = comments;
		this.principal = principal;
		this.principalOutstanding = principalOutstanding;
		this.interest = interest;
		this.interestOutstanding = interestOutstanding;
		this.fee = fee;
		this.feeOutstanding = feeOutstanding;
		this.penalty = penalty;
		this.penaltyOutstanding = penaltyOutstanding;
		this.trxnCreatedDate = new Timestamp(System.currentTimeMillis());
		this.account = account;
	}
	
	public LoanActivityEntity(AccountBO account,PersonnelBO personnel,Money principal,Money interest,Money fee,Money penalty,LoanSummaryEntity loanSummary,String comments) {
		trxnCreatedDate = new Timestamp(System.currentTimeMillis());
		this.id = null;
		this.principal=principal;
		this.interest=interest;
		this.account=account;
		this.personnel=personnel;
		this.fee=fee;
		this.penalty=penalty;
		this.comments=comments;
		this.feeOutstanding=loanSummary
				.getOriginalFees().subtract(
						loanSummary.getFeesPaid());
		this.interestOutstanding=loanSummary
				.getOriginalInterest().subtract(
						loanSummary.getInterestPaid());
		this.penaltyOutstanding=loanSummary
				.getOriginalPenalty().subtract(
						loanSummary.getPenaltyPaid());
		this.principalOutstanding=loanSummary
				.getOriginalPrincipal().subtract(
						loanSummary.getPrincipalPaid());
	}


	public AccountBO getAccount() {
		return account;
	}

	public String getComments() {
		return comments;
	}

	public Money getFee() {
		return fee;
	}

	public Money getFeeOutstanding() {
		return feeOutstanding;
	}

	public Integer getId() {
		return id;
	}

	public Money getInterest() {
		return interest;
	}

	public Money getInterestOutstanding() {
		return interestOutstanding;
	}

	public Money getPenalty() {
		return penalty;
	}

	public Money getPenaltyOutstanding() {
		return penaltyOutstanding;
	}

	public PersonnelBO getPersonnel() {
		return personnel;
	}

	public Money getPrincipal() {
		return principal;
	}

	public Money getPrincipalOutstanding() {
		return principalOutstanding;
	}

	public Timestamp getTrxnCreatedDate() {
		return trxnCreatedDate;
	}

}
