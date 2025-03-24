package coreImplmtn;

import coreImplmtn.CommonModule.Ops.GetAllAlertComOps;
import coreImplmtn.CommonModule.Ops.GetAllCRNListOps;
import coreImplmtn.PaymentModuleOps.PaymentGetFileCountOps;
import coreImplmtn.PaymentModuleOps.PaymentGetFileDetailsOps;
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
	public PaymentGetFileCountOps getPaymentGetFileCountOpsObject() {
		return new PaymentGetFileCountOps();
	}
	public PaymentGetFileDetailsOps getPaymentGetFileDetailsOpsObject() {
		return new PaymentGetFileDetailsOps();
	}
	
}
