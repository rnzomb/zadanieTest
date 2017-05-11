package actions;

import models.Call;
import services.CallService;
import java.util.ArrayList;
import java.util.List;

public class ShowCallAction {
    private CallService callService;
    private List<Call> listCall;

    public String execute() throws Exception {
       // listCall = new ArrayList<Call>();
        listCall = callService.getAll ();
        return "SUCCESS";
    }

    public List<Call> getListCall() {
        return listCall;
    }

    public void setCallService(CallService callService) {
        this.callService = callService;
    }

}
