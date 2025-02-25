package cn.ruxyeah.ltzf.payments.jsapi;

import cn.ruxyeah.ltzf.payments.jsapi.model.GetRefundOrderResponse;
import cn.ruxyeah.ltzf.payments.jsapi.model.PrepayResponse;
import cn.ruxyeah.ltzf.payments.jsapi.model.QueryOrderByOutTradeNoResponse;
import cn.ruxyeah.ltzf.payments.jsapi.model.RefundOrderResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IJSPayApi {

    @FormUrlEncoded
    @POST("api/wxpay/jsapi")
    Call<PrepayResponse> prepay(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("total_fee") String totalFee,
            @Field("body") String body,
            @Field("openid") String openid,
            @Field("timestamp") String timestamp,
            @Field("notify_url") String notifyUrl,
            @Field("return_url") String returnUrl,
            @Field("attach") String attach,
            @Field("time_expire") String timeExpire,
            @Field("sign") String sign
    );

    @FormUrlEncoded
    @POST("api/wxpay/get_pay_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<QueryOrderByOutTradeNoResponse> getPayOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );

    @FormUrlEncoded
    @POST("api/wxpay/refund_order")
    Call<RefundOrderResponse> refundOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("refund_fee") String refundFee,
            @Field("refund_desc") String refundDesc,
            @Field("notify_url") String notifyUrl,
            @Field("sign") String sign
    );

    @FormUrlEncoded
    @POST("api/wxpay/get_refund_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<GetRefundOrderResponse> getRefundOrder(
            @Field("mch_id") String mchId,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );

}
