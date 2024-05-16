# 泛型+策略模式+模板方法模式+组合模式  实现统一对外API接口

### 统一对外API接口

注意事项

* BaseDto 为接口请求参数的父类，所有的请求参数DTO必须继承于它
* BaseVo 为接口返回值的父类，所有接口的返回值VO都必须继承于它
* 根据请求参数 interfaceKey 来区分不同的接口实现与请求值
* interfaceKey 需要与请求参数绑定 ===>  EVENT_MAP
* interfaceKey 需要与service中的具体方法绑定 ===>  DTO_CLASS_MAP

### 实现思路

* 请求参数为 <? extends BaseDto>   必须是BaseDto的子类
* 返回值为  <? extends BaseVo>   必须是BaseVo的子类
* 通过Service中DTO_CLASS_MAP的参数绑定，转换成具体实际请求参数类。完成校验
* `Class<? extends BaseDto> realClass = DTO_CLASS_MAP.get(type);
  ServiceException.requireNonNull(realClass, "请检查interfaceType是否正确");
  // 实际参数转换
  BaseDto instance = JSONUtil.toBean(JSONUtil.toJsonStr(dto), realClass);`
* 通过Service中的EVENT_MAP的实现方法绑定，完成type对应的具体实现。
* `IApiService apiService = ApiServiceStrategyFactory.API_SERVICE_MAP.get(serviceType);
  ServiceException.requireNonNull(apiService, "interfaceType错误！");
  // 3.service实现
  BaseVo resultVo = apiService.doSomething(type, instance);`
* 最后完成统一的返回值
* ` @SuppressWarnings("unchecked")
  default <T extends BaseDto, R extends BaseVo> R doSomething(String type, T dto) {
  ServiceException.requireNonNull(type, "interfaceType为空！");
  ServiceException.requireNonNull(dto, "baseDto为空！");
  val function = EVENT_MAP.get(type);
  ServiceException.requireNonNull(function, "interfaceType错误！");
  return (R) function.apply(dto);
  }`

### 使用案例

ApiController
入参：
`{
"interfaceType": "elsa.openapi.basic.warehouse.info",
"sign": "xx",
"warehouseName": "DE001"
}`

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### 使用
* 后续的接口实现，需要在serviceImpl里面完成对 DTO_CLASS_MAP 请求参数的绑定
* 编写 接口的实现，以及完成 EVENT_MAP 具体实现的绑定
* 具体可参考：**ApiBasicServiceImpl**
