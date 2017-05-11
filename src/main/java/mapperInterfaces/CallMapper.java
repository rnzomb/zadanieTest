package mapperInterfaces;

import models.Call;

import java.util.List;

public interface CallMapper {

    void insertCall(Call call);
    List<Call> getCallById(int callId);
    List<Call> getAll();

}

