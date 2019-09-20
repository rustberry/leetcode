# Common Pitfalls

1. Input (array) is empty
2. When the answer is exactly the largest possible one



### Overflow

```java
int a = -2147483648;
int b = 2147483647;

if (b - a <= 0) {
    System.out.println("b: " + b + " < a: " + a);  
}  // output: b: 2147483647 < a: -2147483647

int ret = b - a;  // ret == -1, overflowed
ret = Integer.compare(a, b);  // ret > 0
boolean flag = a < b;  // true
```



## Detail but May be Critical

1. The initial capacity of `ArrayList` is `10`; [source.](https://stackoverflow.com/a/34250231/8144090)



#### The input may contain identical elements

```
[1,2,0,1]
```

#### Reset state 记得重置状态变量