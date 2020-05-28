/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.dragonsoft.node.adapter.comm;

import com.dragonsoft.pci.exception.InvokeServiceException;

import java.util.Map;

// Referenced classes of package com.dragonsoft.node.adapter.comm:
//            CommonAdapterSend, RequestContext, RbspService, IAdapterSend

public class RbspCall {

	protected RbspCall(RbspService service) {
		this.service = service;
	}

	public String invoke(Map params) {
		RequestContext context = getContext();
		if (params != null) {
			clearBasicParameter(params);
			context.setParams(params);
		}
		String result = null;
		try {
			IAdapterSend adapter = new CommonAdapterSend(context);
			result = adapter.sendService(context, service.getUser());
		} catch (InvokeServiceException e) {
			e.printStackTrace();
			e.getErrorCode();
			e.getErrorMessage();
		}
		return result;
	}

	public String invokeWithThrow(Map params) throws InvokeServiceException {
		RequestContext context = getContext();
		if (params != null) {
			clearBasicParameter(params);
			context.setParams(params);
		}
		String result = null;

		IAdapterSend adapter = new CommonAdapterSend(context);
		result = adapter.sendService(context, service.getUser());

		return result;
	}

	public void setUrl(String url) {
		getContext().setDestUrl(url);
	}

	public void setMethod(String method) {
		getContext().setMethod(method);
	}

	private RequestContext getContext() {
		return service.getContext();
	}

	private void clearBasicParameter(Map params) {
		String basicParams[] = { "SenderID", "ServiceID", "EndUser" };
		String arr$[] = basicParams;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			String param = arr$[i$];
			if (params.containsKey(param))
				params.remove(param);
		}

	}

	private RbspService service;
}