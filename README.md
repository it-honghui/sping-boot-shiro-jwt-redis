# sping-boot-shiro-jwt-redis

## 一、前言
在微服务中我们一般采用的是无状态登录，而传统的session方式，在前后端分离的微服务架构下，如继续使用则必将要解决跨域sessionId问题、集群session共享问题等等。这显然是费力不讨好的，而整合shiro，却很不恰巧的与我们的期望有所违背：

 1. shiro默认的拦截跳转都是跳转url页面，而前后端分离后，后端并无权干涉页面跳转。
 2. shiro默认使用的登录拦截校验机制恰恰就是使用的session。
 
这当然不是我们想要的，因此如需使用shiro，我们就需要对其进行改造，那么要如何改造呢？我们可以在整合shiro的基础上自定义登录校验，继续整合JWT，或者oauth2.0等，使其成为支持服务端无状态登录，即token登录。
## 二、需求
 1. 首次通过post请求将用户名与密码到login进行登入；
 2. 登录成功后返回token；
 3. 每次请求，客户端需通过header将token带回服务器做JWT Token的校验；
 4. 服务端负责token生命周期的刷新
 5. 用户权限的校验；
## 三、演示
**使用正确的用户名密码进行登陆，登陆成功后返回token**
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcuZ2F0aHViLmNuL2ltYWdlLzc0NThkMGEyODYzZGI1YjY4ZGFhYWEzYzVjYmY4NjQzLnBuZw?x-oss-process=image/format,png)
**使用错误的用户名密码进行登陆，登陆失败**
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcuZ2F0aHViLmNuL2ltYWdlLzIwMTFmOTkzMzkyY2ZlZDgzYjljZjIxZmUxMDA3YTY4LnBuZw?x-oss-process=image/format,png)
**headers中携带正确的token访问接口**
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcuZ2F0aHViLmNuL2ltYWdlLzNlMDIxOTRlYTM4ZTdmYzFjZGY3NjQ4YTc0M2M4Y2ZhLnBuZw?x-oss-process=image/format,png)
**headers中不携带token或者携带错误的token访问接口**
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcuZ2F0aHViLmNuL2ltYWdlLzdlZjBmZmY4NjA5MTUyNjE2MmRkYmMyM2IyZDJiNGI1LnBuZw?x-oss-process=image/format,png)
**无权限的用户访问接口**
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcuZ2F0aHViLmNuL2ltYWdlL2E2OWI4Njg5ZWZkMGZlNzBjYjU5MjE5NGIzOWNlODEwLnBuZw?x-oss-process=image/format,png)
**无需登陆token也可以访问的接口（在过滤器中将接口或者资源文件放开）**
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcuZ2F0aHViLmNuL2ltYWdlLzEyMjY2ZTE5MDljNjMxYjQ2ZmE3ZjVmYTAwZWFlYzllLnBuZw?x-oss-process=image/format,png)
