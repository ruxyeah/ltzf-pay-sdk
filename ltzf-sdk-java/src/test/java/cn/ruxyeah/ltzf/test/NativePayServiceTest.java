package cn.ruxyeah.ltzf.test;

import cn.ruxyeah.ltzf.factory.Configuration;
import cn.ruxyeah.ltzf.factory.PayFactory;
import cn.ruxyeah.ltzf.factory.defaults.DefaultPayFactory;
import cn.ruxyeah.ltzf.payments.nativepay.NativePayService;
import cn.ruxyeah.ltzf.payments.nativepay.model.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rux
 * @description
 * @create 2024-04-13 18:22
 */
@Slf4j
public class NativePayServiceTest {

    private NativePayService nativePayService;

    @Before
    public void init() {
        Configuration configuration = new Configuration(
                "1104268", "1673424392", "6d3e889f359fcb83d150e9553a9217b9"
        );

        PayFactory payFactory = new DefaultPayFactory(configuration);
        this.nativePayService = payFactory.nativePayService();
    }

    @Test
    public void test_prepay() throws Exception {
        // 1. 请求参数
        PrepayRequest request = new PrepayRequest();
        request.setMchid("1673424392");
        request.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        request.setTotalFee("0.01");
        request.setBody("QQ公仔");
        request.setNotifyUrl("https://gaga.plus/");

        // 2. 创建支付订单
        PrepayResponse response = nativePayService.prepay(request);

        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("应答结果:{}", JSON.toJSONString(response));

    }
    @Test
    public void test_queryOrderByOutTradeNo() throws Exception {
        QueryOrderByOutTradeNoRequest request = new QueryOrderByOutTradeNoRequest();
        request.setMchid("1673424392");
        request.setOutTradeNo("31443088");
        QueryOrderByOutTradeNoResponse response = nativePayService.queryOrderByOutTradeNo(request);
        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("应答结果: {}", JSON.toJSONString(response));
    }

    @Test
    public void test_refundOrder() throws Exception {
        RefundOrderRequest request = new RefundOrderRequest();
        request.setMchid("1673424392");
        request.setOutTradeNo("31443088");
        request.setOutRefundNo(RandomStringUtils.randomNumeric(8));
        request.setRefundFee("0.01");
        request.setRefundDesc("测试退款");
        request.setNotifyUrl("https://gaga.plus/api");

        Object response = nativePayService.refundOrder(request);
        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("应答结果: {}", JSON.toJSONString(response));
    }

    @Test
    public void test_getRefundOrder() throws Exception {
        GetRefundOrderRequest request = new GetRefundOrderRequest();
        request.setMchid("1673424392");
        request.setOutRefundNo("86549206");

        GetRefundOrderResponse response = nativePayService.getRefundOrder(request);
        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("应答结果: {}", JSON.toJSONString(response));
    }

}
