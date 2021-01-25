package adapter.demo1;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOuterUser {
    @Override
    public Map getUserBaseInfo() {
        HashMap<String, String> baseInfoMap = new HashMap<>();
        baseInfoMap.put("userName","混世魔王");
        baseInfoMap.put("mobileNumber","员工电话号码");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap<String, String> officeInfoMap = new HashMap<>();
        officeInfoMap.put("officeTelNumber","员工办公电话");
        officeInfoMap.put("jobPosition","个人职位的boss");
        return officeInfoMap;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap<String, String> homeInfoMap = new HashMap<>();
        homeInfoMap.put("homeTelNumber","员工家庭电话");
        homeInfoMap.put("homeAddress","员工家庭地址");
        return null;
    }
}
