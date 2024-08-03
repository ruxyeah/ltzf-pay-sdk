package cn.ruxyeah.ltzf.test;

import cn.ruxyeah.ltzf.factory.Configuration;
import cn.ruxyeah.ltzf.factory.PayFactory;
import cn.ruxyeah.ltzf.factory.defaults.DefaultPayFactory;
import cn.ruxyeah.ltzf.payments.app.AppPayService;
import cn.ruxyeah.ltzf.payments.app.model.PrepayRequest;
import cn.ruxyeah.ltzf.payments.app.model.PrepayResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class AppPayServiceTest {

    private AppPayService appPayService;

    @Before
    public void init() {
        Configuration configuration = new Configuration(
                "1104268",
                "1673424392",
                "6d3e889f359fcb83d150e9553a9217b9");

        PayFactory payFactory = new DefaultPayFactory(configuration);
        this.appPayService = payFactory.appPayService();
    }

    @Test
    public void test_prepay() throws Exception {
        // 1. 请求参数
        PrepayRequest request = new PrepayRequest();
        request.setAppId("wxfa7dbd439a7773b0");
        request.setMchid("1673424392");
        request.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        request.setTotalFee("0.01");
        request.setBody("QQ公仔");
        request.setNotifyUrl("https://gaga.plus/api");

        // 2. 创建支付订单
        PrepayResponse response = appPayService.prepay(request);

        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("应答结果: {}", JSON.toJSONString(response));
    }

}
