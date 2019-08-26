package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

/**
 * Create by HuangJian on 2019/1/4
 * 服务端接口聚集地
 */
public class ServerInterfaceContant {

    //private static final String Domain = "https://40.73.102.193";
    //public static final String Domain = "http://130.252.200.68:8010";//http
    //public static final String Domain = "http://130.252.103.10:8010";//http
    private static final String Domain = "https://112.64.187.2:10002";//https

    //获取本地时间与服务端时间的时间差接口
    public static final String appGetTimeDifference = Domain + "/appgate/system/getTimeDiff";

    //登录接口1——用户名密码登录
    public static final String appLogin4UserNameUserPwd = Domain + "/appgate/login/validate";

    //登录接口2——手机验证码登录
    public static final String appLogin4MobilePhoneVerificationCode = Domain + "/appgate/login" +
            "/code/check";

    //客户登录重发短信接口
    public static final String appLoginResendSMS = Domain + "/appgate/login/code/resend";

    //指纹识别登录功能接口
    public static final String appLogin4FingerprintIdentification = Domain + "/appgate/login" +
            "/fingerprint";

    //手势密码登录功能接口
    public static final String appLogin4GesturePassword = Domain + "/appgate/login/gesture";

    //获取客户信息功能接口
    public static final String appGetUserInfo = Domain + "/appgate/customer/info";


    //5.43	设置并启停手势密码登录功能接口
    public static final String appGesturePasswordSettings = Domain + "/appgate/profile/gesture" +
            "/setting";


    //5.44	启停指纹密码登录功能接口
    public static final String appOpenAndCloseFingerprints = Domain + "/appgate/profile" +
            "/fingerprint/setting";

    //账户充值确认功能接口
    public static final String appAccountRechargePayment = Domain + "/appgate/order/deposit" +
            "/confirm";

    //内部账户转账受理功能接口
    public static final String appInternalAccountTransfer = Domain + "/appgate/order" +
            "/internaltransfer/accept";

    //内部账户转账确认功能接口
    public static final String appInternalAccountTransferConfirmation = Domain + "/appgate/order" +
            "/internaltransfer/confirm";

    //regist Short Message Verification Code接口
    public static final String appCustomerRegistrationSendingSMSVerificationCode = Domain +
            "/appgate/register/code/send";

    //check Verification
    public static final String appCustomerRegistrationCheckMessageVerification = Domain +
            "/appgate/register/code/verify";

    //客户注册确认密码
    public static final String appcCustomerRegistrationConfirmationPassword = Domain + "/appgate" +
            "/register/password/confirm";

    //客户注册详细信息
    public static final String appCustomerRegistrationDetails = Domain + "/appgate/register" +
            "/detail/confirm";

    //客户注册输入邮箱
    public static final String appCustomerRegistrationInputMailbox = Domain + "/appgate/register" +
            "/email/confirm";

    //客户注册选择居住国
    public static final String appCustomerRegistrationChoosesCountryOfResidence = Domain +
            "/appgate/register/resident/country/confirm";

    //resend message
    public static final String appCustomerRegistrationAndResendingSMS = Domain + "/appgate" +
            "/register/code/resend";

    //sel country code
    public static final String appGetCountryCode = Domain + "/appgate/system/country";

    //查询订单接口
    public static final String appGetOrderInfo = Domain + "/appgate/order/main/query";

    //获取交易类型的服务费
    public static final String appGetFeeAmountInfo = Domain + "/appgate/order/prepare/query";

    //支付路由查询功能接口
    public static final String appGetPaymentRouting = Domain + "/appgate/order/route/query";

    //客户登出功能接口
    public static final String appCustomerLogout = Domain + "/appgate/logout";

    //根据订单id查询订单信息
    public static final String appSelOrderInfo4OrderId = Domain + "/appgate/order/info/query";

    //交易类风控短信发送功能接口
    public static final String appTransactionTypeWindControlSMSSending = Domain + "/appgate" +
            "/customer/transaction/sms/code/send";

    //个人信息管理验密登录接口
    public static final String appPersonalInformationManagementConfidentialLogin = Domain +
            "/appgate/profile/login";

    //激活邮箱发送邮箱验证码接口
    public static final String appActivateMailbox2SendMailboxVerificationCode = Domain +
            "/appgate/profile/email/active/code/send";

    //激活邮箱
    public static final String appActivateMailbox = Domain +
            "/appgate/profile/email/active";

    //修改邮箱发送邮箱验证码
    public static final String appModifyMailboxSendMailboxVerificationCode = Domain + "/appgate" +
            "/profile/email/modify/code/send";

    //修改邮箱发送邮箱验证码
    public static final String appModifyMailbox = Domain + "/appgate/profile/email/modify";

    //设置支付密码
    public static final String appSettingPaymentPassword = Domain + "/appgate/profile/pin/setting";

    //修改支付密码功能接口
    public static final String appModifyPaymentPassword = Domain + "/appgate/profile/pin/modify";

    //重置支付密码发送邮箱验证码功能接口
    public static final String appResetPaymentPassword2SendEmailVerificationCode = Domain +
            "/appgate/profile/pin/reset/email/code/send";

    //重置支付密码验证邮箱验证码
    public static final String appResetPaymentPasswordVerificationEmailVerificationCode =
            Domain + "/appgate/profile/pin/reset/email/code/check";

    //重置支付密码发送短信验证码
    public static final String appResetPaymentPassword2SendSMSVerificationCode = Domain +
            "/appgate/profile/pin/reset/sms/code/send";

    //重置支付密码验证短信验证码
    public static final String appResetPaymentPasswordVerificationSMSVerificationCode = Domain +
            "/appgate/profile/pin/reset/sms/code/check";

    //重置支付密码确认
    public static final String appResetPaymentPasswordConfirmation = Domain + "/appgate/profile" +
            "/pin/reset/confirm";

    //修改登录密码接口
    public static final String appModifyLoginPassword = Domain + "/appgate/profile/password/modify";

    //重置登录密码发送短信验证码
    public static final String appResetLoginPassword2SendSMSAuthenticationCode = Domain +
            "/appgate/profile/password/reset/sms/code/send";

    //重置登录密码验证短信验证码
    public static final String appResetLoginPassword2VerifySMSAuthenticationCode = Domain +
            "/appgate/profile/password/reset/sms/code/check/";

    //重置登录密码确认功能接口
    public static final String appResetLoginPasswordConfirmation = Domain + "/appgate/profile" +
            "/password/reset/confirm";

    //5.39	收款人列表查询功能接口
    public static final String appPayeeListQuery = Domain + "/appgate/customer/beneficiary/list";

    //5.41	收款人删除功能接口
    public static final String appPayeeDelete = Domain + "/appgate/customer/beneficiary/delete";

    //5.49	历史订单过滤条件查询功能接口
    public static final String appHistoricalOrderFilterQuery = Domain + "/appgate/order" +
            "/transaction/filter/query";

    //5.50	历史订单交易列表查询功能接口
    public static final String appHistoricalOrderTransactionListQuery = Domain + "/appgate/order" +
            "/transaction/list/query";

    //5.51	历史订单交易详情接口查询功能接口
    public static final String appHistoricalOrderTransactionDetails = Domain + "/appgate/order" +
            "/transaction/detail/query";

    //5.52	账户升级功能接口
    public static final String appAccountUpgrade = Domain + "/appgate/customer/account/upgrade";

    //5.53	查询通知列表功能接口
    public static final String appQueryNotificationList = Domain + "/appgate/noticecenter/notice" +
            "/list/query";

    //5.54	二维码扫码登录确认功能接口
    public static final String appQRCodeSweepingLogonConfirmation = Domain + "/appgate/login" +
            "/qrcode/verify";

    //5.55	二维码扫码登录功能接口
    public static final String appQRCodeSweepingLogonCheck = Domain + "/appgate/login/qrcode/check";

    //5.56	根据二维码内容查询订单信息功能接口
    public static final String appQueryOrderInformationBasedQRCodeContent = Domain + "/appgate" +
            "/order/detail/query";

    //5.57	消费订单支付确认功能接口
    public static final String appConfirmationOfConsumerOrderPayment = Domain + "/appgate/order" +
            "/consume/confirm";

    //5.58	银联充值流程受理订单功能接口
    public static final String appUnionPayRechargeProcessAcceptsOrders = Domain + "/appgate/order" +
            "/topup/accept";


    //5.59	银联充值check3ds功能接口
    public static final String appUnionPayRechargeCheck3ds = Domain + "/appgate/order/topup/cup" +
            "/check3ds";

    //5.60	根据交易ID查询订单信息功能接口
    public static final String appCheckOrderInformationBasedOnTransactionID = Domain + "/appgate" +
            "/order/topup/cup/order/query";

    //5.61	银联充值信用卡支付确认功能接口
    public static final String appConfirmationOfUnionPayCreditCardPayment = Domain + "/appgate" +
            "/order/topup/cup/credit/pay";

    //5.62	银联充值借记卡支付确认功能接口
    public static final String appConfirmationOfPpaymentByRechargeDebitCardOfUnionPay = Domain +
            "/appgate/order/topup/cup/debt/pay";

    //5.63	银联充值信用卡normal sale功能接口
    public static final String appUnionPayRecharGeableCreditCardNormalSale = Domain + "/appgate" +
            "/order/topup/cup/credit/normal";

    //5.64	卡列表查询功能接口
    public static final String appCardListQuery = Domain + "/appgate/bankcard/list/query";

    //5.66	绑定银行卡修改功能接口
    public static final String appBindingBankCardModification = Domain + "/appgate/bankcard/modify";

    //5.67	绑定银行卡删除功能接口
    public static final String appBindingBankCardDeletion = Domain + "/appgate/bankcard/delete";

    //5.68	获取参数列表功能接口
    public static final String appGetListOfParameters = Domain + "/appgate/system/param/query";

    //5.69	意见反馈功能接口
    public static final String appFeedBackSubmit = Domain + "/appgate/customer/feedback";

    //5.70	检查app版本功能接口
    public static final String appCheckAppVersion = Domain + "/appgate/system/version/check";

    //5.71	查询引导模式功能接口
    public static final String appQueryBootMode = Domain + "/appgate/system/guidemode/query";

    //5.72	查询用户协议功能接口
    public static final String appQueryUserAgreement = Domain + "/appgate/system/useragreement/query";
}
