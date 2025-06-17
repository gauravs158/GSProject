package coreImplmtn;

import coreImplmtn.AdjudicationModule.Ops.GetAdjudicationCaseDataDeterminationofTaxOps;
import coreImplmtn.AdjudicationModule.Ops.GetAdjudicationCaseDataMFYOps;
import coreImplmtn.AuditModule.Ops.GetAuditCaseDetailsOps;
import coreImplmtn.CommonModule.Ops.GetAllAlertComOps;
import coreImplmtn.CommonModule.Ops.GetAllCRNListOps;
import coreImplmtn.PaymentModule.Ops.PaymentGetFileCountOps;
import coreImplmtn.PaymentModule.Ops.PaymentGetFileDetailsOps;
import coreImplmtn.RegModule.Ops.GetAlertRegOps;
import coreImplmtn.RegModule.Ops.GetAllApplicationsOps;
import coreImplmtn.RegModule.Ops.GetEntityOps;
import coreImplmtn.ReturnsModule.Ops.GetReturnFileCountOps;
import coreImplmtn.ReturnsModule.Ops.GetReturnFileDetailsOps;

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
	
}
