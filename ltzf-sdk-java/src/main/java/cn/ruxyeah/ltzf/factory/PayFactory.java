package cn.ruxyeah.ltzf.factory;

import cn.ruxyeah.ltzf.payments.app.AppPayService;
import cn.ruxyeah.ltzf.payments.h5.H5PayService;
import cn.ruxyeah.ltzf.payments.jsapi.JSPayService;
import cn.ruxyeah.ltzf.payments.jump_h5.JumpH5PayService;
import cn.ruxyeah.ltzf.payments.nativepay.NativePayService;

public interface PayFactory {

    NativePayService nativePayService();

    H5PayService h5PayService();

    AppPayService appPayService();

    JSPayService jsPayService();

    JumpH5PayService jumpH5PayService();

}
