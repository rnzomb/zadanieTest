package services;

import models.Call;
import mapperInterfaces.CallMapper;
import org.apache.ibatis.session.SqlSession;


import java.util.List;


public class CallService {
    private CallMapper callMapper;
    private SqlSession sqlSession;

    public CallService() throws Exception {
    }

    public void setCallMapper(CallMapper callMapper) {
        this.callMapper = callMapper;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Call> getCallById(int callId){
        callMapper = sqlSession.getMapper (CallMapper.class);
        return callMapper.getCallById (callId);
    }

    public List<Call> getAll() {
        List<Call> callList = callMapper.getAll();
        return callList;
    }

    public void insertCall(Call call) {
        callMapper = sqlSession.getMapper(CallMapper.class);
        callMapper.insertCall(call);
    }

}
