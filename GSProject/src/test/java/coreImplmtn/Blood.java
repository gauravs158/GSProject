package coreImplmtn;

import coreImplmtn.AdjudicationModule.Ops.GetAdjudicationCaseDataDeterminationofTaxOps;
import coreImplmtn.AdjudicationModule.Ops.GetAdjudicationCaseDataMFYOps;
import coreImplmtn.AuditModule.Ops.GetAuditCaseDetailsOps;
import coreImplmtn.CommonModule.Ops.GetAllAlertComOps;
import coreImplmtn.CommonModule.Ops.GetAllCRNListOps;
import coreImplmtn.PaymentModule.Ops.PaymentGetFileCountOps;
import coreImplmtn.PaymentModule.Ops.PaymentGetFileDetailsOps;
import coreImplmtn.PaymentModule.Ops.PaymentReconOps;
import coreImplmtn.RegModule.Ops.GetARNUpdateApproveRegOps;
import coreImplmtn.RegModule.Ops.GetAlertRegOps;
import coreImplmtn.RegModule.Ops.GetAllApplicationsOps;
import coreImplmtn.RegModule.Ops.GetEntityOps;
import coreImplmtn.ReturnsModule.Ops.GetRecordFileOps;
import coreImplmtn.ReturnsModule.Ops.GetReturnComparisionReportOps;
import coreImplmtn.ReturnsModule.Ops.GetReturnFileCountOps;
import coreImplmtn.ReturnsModule.Ops.GetReturnFileDetailsOps;
import coreImplmtn.RfndModule.Ops.GetAllApplicationDetailsOps;
import coreImplmtn.RfndModule.Ops.GetAllApplicationDetailsRFD10Ops;
import coreImplmtn.RfndModule.Ops.GetAllApplicationListOps;
import coreImplmtn.RfndModule.Ops.GetBankValidationStatusOps;
import coreImplmtn.RfndModule.Ops.GetCaseDataOps;
import coreImplmtn.RfndModule.Ops.GetStatementDetailOps;

public class Blood {

	public GetAlertRegOps getGetAlertRegOpsObject() {
		return new GetAlertRegOps();
	}
	public GetAllApplicationsOps getGetAllApplOpsObject() {
		return new GetAllApplicationsOps();
	}
	public GetEntityOps getGetEntityOpsObject() {
		return new GetEntityOps();
	}
	public GetAllAlertComOps getGetAllAlertComOpsObject() {
		return new GetAllAlertComOps();
	}
	public GetAllCRNListOps getAllCRNListOpsObject() {
		return new GetAllCRNListOps();
	}
	public PaymentGetFileCountOps getPaymentGetFileCountOpsObject() {
		return new PaymentGetFileCountOps();
	}
	public PaymentGetFileDetailsOps getPaymentGetFileDetailsOpsObject() {
		return new PaymentGetFileDetailsOps();
	}
	public GetReturnFileCountOps getGetReturnFileCountOpsObject() {
		return new GetReturnFileCountOps();
	}
	public GetReturnFileDetailsOps getGetReturnFileDetailsOpsObject() {
		return new GetReturnFileDetailsOps();
	}
	public GetAdjudicationCaseDataMFYOps getGetAdjudicationCaseDataMFYOpsObject() {
		return new GetAdjudicationCaseDataMFYOps();
	}
	public GetAdjudicationCaseDataDeterminationofTaxOps getGetAdjudicationCaseDataDeterminationofTaxOpsObject() {
		return new GetAdjudicationCaseDataDeterminationofTaxOps();
	}
	public GetAuditCaseDetailsOps getAuditCaseDetailsOpsObject() {
		return new GetAuditCaseDetailsOps();
	}	
	public GetReturnComparisionReportOps getGetReturnComparisionReportOpsObject() {
		return new GetReturnComparisionReportOps();
	}	
	public GetRecordFileOps getGetRecordFileOpsObject() {
		return new GetRecordFileOps();
	}	
	public GetARNUpdateApproveRegOps getGetARNUpdateApproveRegOpsObject() {
		return new GetARNUpdateApproveRegOps();
	}	
	public PaymentReconOps getPaymentReconOpsObject() {
		return new PaymentReconOps();
	}	
	public GetAllApplicationListOps getAllApplicationListOpsObject() {
		return new GetAllApplicationListOps();
	}	
	public GetAllApplicationDetailsOps getAllApplicationDetailsOpsObject() {
		return new GetAllApplicationDetailsOps();
	}	
	public GetAllApplicationDetailsRFD10Ops getAllApplicationDetailsRFD10OpsObject() {
		return new GetAllApplicationDetailsRFD10Ops();
	}	
	public GetBankValidationStatusOps getBankValidationStatusOpsObject() {
		return new GetBankValidationStatusOps();
	}	
	public GetStatementDetailOps getStatementDetailOpsObject() {
		return new GetStatementDetailOps();
	}	
	public GetCaseDataOps getCaseDataOpsObject() {
		return new GetCaseDataOps();
	}
}
