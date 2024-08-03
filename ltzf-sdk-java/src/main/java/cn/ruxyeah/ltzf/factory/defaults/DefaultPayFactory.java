package cn.ruxyeah.ltzf.factory.defaults;

import cn.ruxyeah.ltzf.factory.Configuration;
import cn.ruxyeah.ltzf.factory.PayFactory;
import cn.ruxyeah.ltzf.payments.app.AppPayService;
import cn.ruxyeah.ltzf.payments.app.IAppPayApi;
import cn.ruxyeah.ltzf.payments.h5.H5PayService;
import cn.ruxyeah.ltzf.payments.h5.IH5PayApi;
import cn.ruxyeah.ltzf.payments.jsapi.IJSPayApi;
import cn.ruxyeah.ltzf.payments.jsapi.JSPayService;
import cn.ruxyeah.ltzf.payments.jump_h5.IJumpH5PayApi;
import cn.ruxyeah.ltzf.payments.jump_h5.JumpH5PayService;
import cn.ruxyeah.ltzf.payments.nativepay.INativePayApi;
import cn.ruxyeah.ltzf.payments.nativepay.NativePayService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class DefaultPayFactory implements PayFactory {

    private final Configuration configuration;

    private final OkHttpClient httpClient;

    public DefaultPayFactory(Configuration configuration) {
        this.configuration = configuration;
        // 1. 日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 2. 开启 Http 客户端
        httpClient = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.SECONDS)
                .writeTimeout(configuration.getWriteTimeout(), TimeUnit.SECONDS)
                .readTimeout(configuration.getReadTimeout(), TimeUnit.SECONDS)
                .build();
    }

    @Override
    public NativePayService nativePayService() {
        // 构建API
        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);
        // 创建支付服务
        return new NativePayService(configuration, nativePayApi);
    }

    @Override
    public H5PayService h5PayService() {
        // 构建API
        IH5PayApi h5PayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IH5PayApi.class);
        // 创建支付服务
        return new H5PayService(configuration, h5PayApi);
    }

    @Override
    public AppPayService appPayService() {
        // 构建API
        IAppPayApi appPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IAppPayApi.class);
        // 创建支付服务
        return new AppPayService(configuration, appPayApi);
    }

    @Override
    public JSPayService jsPayService() {
        // 构建API
        IJSPayApi jsPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IJSPayApi.class);
        // 创建支付服务
        return new JSPayService(configuration, jsPayApi);
    }

    @Override
    public JumpH5PayService jumpH5PayService() {
        // 构建API
        IJumpH5PayApi jumpH5PayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IJumpH5PayApi.class);
        // 创建支付服务
        return new JumpH5PayService(configuration, jumpH5PayApi);
    }

}
