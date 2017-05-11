package actions;

import com.google.gson.Gson;
import models.Call;
import services.CallService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class ShowCallIdAction {
    private InputStream inputStream;
    private CallService callService;
    private int callId;

    public String execute() throws Exception {
        List<Call> listCallId = callService.getCallById (this.callId);
        Gson gson = new Gson ();
        String jsonResult = gson.toJson (listCallId);
        inputStream = new ByteArrayInputStream (jsonResult.getBytes ("UTF-8"));
        return "SUCCESS";

    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public void setCallService(CallService callService) {
        this.callService = callService;
    }

}

