package com.hzit.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import javax.swing.text.html.FormSubmitEvent;
import java.util.Random;

/**
 * @description: 发送手机验证码的工具类
 * @author: Altman
 * @date: 2018-05-02 21:03
 */
public class PhoneMessageUtil {

    /**
     * @description: 发送验证码
     * @param:  yanZhengMa验证码，  telphone接收验证码的电话号码
     * @return: boolean
     * @author: Altman
     * @date: 2018-05-02 21:08
    **/
    public boolean sandMassage(String yanZhengMa, String telphone) {
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIHsLVzSBm2G8a", "99CL6YJY260YF07Vu6JLr8J7qxq1IV");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", telphone);
        request.putQueryParameter("SignName", "合众商城");
        //request.putQueryParameter("TemplateCode", "SMS_170156047");
        request.putQueryParameter("TemplateCode", "SMS_169904124"); //# SMS_169899226   SMS_169904124 SMS_170156047
        request.putQueryParameter("TemplateParam", "{\"code\":" + yanZhengMa + "}");
        try {

            // client.getAcsResponse(request);
            //client.getAcsResponse(request)
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            System.out.println(data);
            if (data.contains("OK")) {
                return true;
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @description: 生成随机密码
     * @param:  pwd_len密码总长度
     * @return: String
     * @author: Altman
     * @date: 2018-05-02 21:08
    **/
    public String genRandomNum(int pwd_len) {
        // String re="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&]).{10,}";
        @SuppressWarnings("unused")
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z0-9@#$%]{8,16}$";
        //35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 9;
        int i;  //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
        char[] upChar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'};
        char[] numChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] speChar = {'!', '@', '#', '$', '%'};

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        count=0;
        while (count < pwd_len) {
            //生成随机数，取绝对值，防止生成负数，
            i = Math.abs(r.nextInt(maxNum));  //随机生成0-9
            if (i >= 0 && i < numChar.length) {
                pwd.append(numChar[i]);
                char c = pwd.charAt(0);
                if(c=='0'){
                    pwd.deleteCharAt(0);
                    pwd.insert(0,'1');
                }
                count++;
            }
        }

       return pwd.toString();
    }

}
