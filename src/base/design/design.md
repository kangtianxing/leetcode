# 设计模式
## 创建型
关注对象的创建过程
### 建造者模式
分离了对象子组件的单独构造和装配，从而可以构造出复杂的都西昂，这种模式适用于构建过程复杂的情况下使用。

## 结构型
关注对象和类的组织
是从程序的结构上实现松耦合，从而可以扩大整体的类结构，用来解救额更大的问题
### 适配器模式
#### 职责
将一个类的接口转换为客户希望的另一个接口，Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
### 代理模式
#### 职责
通过代理，控制对都西昂的访问，可以详细控制某个对象的方法，在调用这个方法前做前置处理，调用这个方法后做后置处理。
### 桥接模式
#### 职责
处理多层继承结构，处理多维度变化的场景，将各个维度设计成独立的继承结构，是各个维度可以独立的扩展在抽象层建立关联。
### 组合模式
#### 职责
把整体与部分的关系用树形结构来表示，从而使客户端可以使用统一的方式处理部分对象和整体对象。
### 装饰器模式
#### 职责
动态的为一个对象增加新功能，装饰模式使用一种用于代替继承的技术，无须通过继承增加子类就能扩展对象
的新功能。使用对象的关联关系代替继承关系，更加灵活，同时避免类型体系的快速膨胀。

### 享元模式
#### 职责
享元模式以共享的方式高效地支持大量细粒度对象的重用。
享元对象可以做到共享的关键还是区分了内部状态和外部状态。
        内部状态--可以共享，不会随环境变化而改变
        外部状态--不可以共享，会随环境变化而改变
## 行为型   
关注系统中对象之间的相互交互，研究系统在运行时对象之间的相互通信和写作，进一步明确对象的职业，共11种
     
### 责任链模式
#### 职责
享元模式以共享的方式高效地支持大量细粒度对象的重用。
享元对象可以做到共享的关键还是区分了内部状态和外部状态。
        内部状态--可以共享，不会随环境变化而改变
        外部状态--不可以共享，会随环境变化而改变        
### 迭代器模式
#### 职责
提供一种可以便利聚合对象的方式，又称为：游标cursor模式
- 聚合对象：存储数据
- 迭代器:遍历数据
### 命令模式
#### 职责
将一个请求封装成为一个对象，从而使我们可用不同的请求对客户进行参数化，对请求排队或者记录请求日志以及支持可撤销的操作。

### 模板方法模式
#### 职责
定义一个算法的骨架，将某些步骤延迟到子类中实现，这样，新的子类可以在不改变一个算法结构的前提下重新定义该算法的某些特定步骤。

- 处理步骤父类中定义好，具体实现延迟到子类中定义。
            
### 状态模式
#### 职责
用于解决系统中复杂对象的状态转换以及不同状态下行为的封装问题。
- 线程对象之间的各个状态的切换

### 广播模式
#### 职责
聊天室程序的创建。服务器创建好，A,B,C三个客户端连上来公开聊天，A向服务器发送数据，服务器端聊天数据改变。
- 我们可以把多个订阅者/客户称之为观察者；需要同步给多个订阅者的数据封装到对象总，称之为目标。

主要用于1：N的通知，当一个对象(目标对象Subject或Objservable)的状态变化时，他需要及时告知一系列对象(观察者,Observer),令他们做出响应

### 备忘录模式
#### 职责
保存某个对象内部状态的拷贝，这样以后就可以将该对象恢复到原先的状态
结构
- 源发器类 Originator
- 备忘录类 Memento
- 负责人类 CareTake
