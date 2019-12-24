### 框架开发手册

> 应用环境变量说明  
KOPDOCTOR_DEVELOPER_NAME: 开发者标识(用以区分注册中心服务实例名称,如: -Turing)  
KOPDOCTOR_CONFIG_ENV: 环境标识  
KOPDOCTOR_REGISTRY_ADDRESS: 注册中心地址  

> 框架配置说明  
是否开启日志过滤器
kopdoctor.framework.filter.logging.enabled: true  
日志过滤器URL匹配模式(多个用逗号隔开)  
kopdoctor.framework.filter.logging.url-patterns: /*  