package actions;

import com.google.gson.Gson;
import models.Call;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import services.CallService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SaveCSVAction {
    private CallService callService;
    private InputStream inputStream;
    private String filename;


    public String execute() throws UnsupportedEncodingException {
        List<Call> listCall = callService.getAll ();
        Gson gson = new Gson ();
        String jsonString = gson.toJson (listCall);

        String jsonFormatted = "{\"csv\": " + jsonString + "}";
        JSONObject objectResult = new JSONObject (jsonFormatted);
        JSONArray arrayResultData = objectResult.getJSONArray ("csv");

        String csvFile = CDL.toString (arrayResultData);

        Date date = new Date ();
        SimpleDateFormat myFormat = new SimpleDateFormat ("yyyyMMdd");

        filename = "all_records_" + myFormat.format (date) + ".csv";
        inputStream = new ByteArrayInputStream (csvFile.getBytes ("UTF-8"));

        return "SUCCESS";
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFilename() {
        return filename;
    }

    public void setCallService(CallService callService) {
        this.callService = callService;
    }

}
