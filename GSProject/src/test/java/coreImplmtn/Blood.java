package coreImplmtn;

import coreImplmtn.CommonModule.Ops.GetAllAlertComOps;
import coreImplmtn.CommonModule.Ops.GetAllCRNListOps;
import coreImplmtn.PaymentModule.Pojo.GetPaymentFileCountPojo;
import coreImplmtn.PaymentModule.Pojo.GetPaymentFileDetailsPojo;
import coreImplmtn.RegModule.Ops.GetAlertRegOps;
import coreImplmtn.RegModule.Ops.GetAllApplicationsOps;
import coreImplmtn.RegModule.Ops.GetEntityOps;

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
	public GetPaymentFileCountPojo getPaymentGetFileCountOpsObject() {
		return new GetPaymentFileCountPojo();
	}
	public GetPaymentFileDetailsPojo getPaymentGetFileDetailsOpsObject() {
		return new GetPaymentFileDetailsPojo();
	}
	
}
