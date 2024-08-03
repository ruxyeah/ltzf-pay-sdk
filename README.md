# 项目介绍
该应用是一个方便使用的支付SDK应用，对接了蓝兔支付，你可以在上边更改或扩展其他支付渠道
* 蓝兔支付官网API接口分析，包括；扫码支付、H5支付、公众号支付、小程序支付、订单退款、查询订单、支付通知等功能。
* 通过 okhttp3、retrofit2 框架，对接官网 http api 接口。框架的能力可以让支付对接更加标准、清晰，易扩展。
* 不同的支付方式会有自己的签名字段，所以通过聚合支付对象，提供签名处理。
* 每个支付方式提供独立的接口实现，保证单一职责，不同的支付就是每一个单独的策略实现。
* 提供工厂服务，封装支付 API 服务的创建，统一管理。
* 通过 SpringBoot 工程，配置支付 sdk 对接使用。
* 使用 natapp 内网穿透工具，验证支付回调。

# 1. sdk工程

![](http://ruxyeah.cn/images/project/pay-sdk/ltzfsdk.png)

# 2. sdk使用

![](http://ruxyeah.cn/images/project/pay-sdk/ltzfsdk.png)
