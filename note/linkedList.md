发现使用github history功能做笔记很好用

以后要经常使用这个功能


截图功能 

1. shift + commend + 4
2. 拖拽到


# 使用链表实现队列

![](./img/Evernote Snapshot 20191103 113007.png)

别乱改仓库的名字

```java
class demo {
    public void enqueue(E e) {

        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next; // 这里的意思是 tail向后挪了一位,我没有理解这句话的根本原因是我没有理解java语言中的引用类型

//           代码 tail.next = new Node(e);
//            在当前链表的末尾后面又加了一个元素
//                    tail = tail.next;
//            上面的添加以后，tail已经不再指向最后一个元素了，所以要维护一下tail，让tail指向最后一个元素
        }
        size++;
    }
}
```

tail.next = new Node(e);

在当前链表的末尾后面又加了一个元素



tail = tail.next;

上面的添加以后，tail已经不再指向最后一个元素了，所以要维护一下tail，让tail指向最后一个元素
