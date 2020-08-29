## 错误记录

#### 登陆之后线程读取不到ThreadLocal中的对象

ThreadLocal用于给当前线程存储数据，遇到这个问题可以查看当前线程

```java
Thread.currentThread();
```

发现存入时和读取时的线程不同，使用拦截器中的```preHandle```解决问题，在方法中通过cooike获取信息，获取当前ticket的user并且存入ThreadLocal，可见执行Controller和拦截器的是同一个线程