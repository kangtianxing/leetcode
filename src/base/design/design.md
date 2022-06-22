# 设计模式
## 创建型
### 建造者模式
分离了对象子组件的单独构造和装配，从而可以构造出复杂的都西昂，这种模式适用于构建过程复杂的情况下使用。

## 结构型
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
