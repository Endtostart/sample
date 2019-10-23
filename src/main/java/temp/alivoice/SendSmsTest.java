package temp.alivoice;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSmsTest {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("default", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("ModifySmsTemplate");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("TemplateCode", "4444");

//        CommonResponse response = client.getCommonResponse(request);
//        client.getAcsResponse();

    }
}
